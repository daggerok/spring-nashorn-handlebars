package daggerok.config;

import daggerok.IsomorphicSpringApplication;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

@Configuration
@ComponentScan(basePackageClasses = IsomorphicSpringApplication.class)
public class AppCfg {

  @Bean
  ScriptTemplateConfigurer handlebarsConfigurer() {
    val scriptTemplateConfigurer = new ScriptTemplateConfigurer();
    scriptTemplateConfigurer.setEngineName("nashorn");
    scriptTemplateConfigurer.setScripts(
        "/static/polyfill.js",
        "/vendors/handlebars/handlebars.js",
        "/static/render.js"
    );
    scriptTemplateConfigurer.setRenderFunction("render");
    scriptTemplateConfigurer.setSharedEngine(false);
    return scriptTemplateConfigurer;
  }

  @Bean
  ViewResolver viewResolver() {
    val scriptTemplateViewResolver = new ScriptTemplateViewResolver();
    scriptTemplateViewResolver.setPrefix("/templates/");
    scriptTemplateViewResolver.setSuffix(".hbs");
    return scriptTemplateViewResolver;
  }
}
