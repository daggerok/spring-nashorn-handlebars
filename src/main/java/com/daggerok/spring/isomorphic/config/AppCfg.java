package com.daggerok.spring.isomorphic.config;

import com.daggerok.spring.isomorphic.IsomorphingSpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

@Configuration
@ComponentScan(basePackageClasses = IsomorphingSpringApplication.class)
public class AppCfg {
    @Bean
    public ScriptTemplateConfigurer handlebarsConfigurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();

        configurer.setEngineName("nashorn");
        configurer.setScripts("/static/polyfill.js",
                "/vendors/handlebars/handlebars.js",
                "/static/render.js");
        configurer.setRenderFunction("render");
        configurer.setSharedEngine(false);
        return configurer;
    }
    @Bean
    public ViewResolver viewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();

        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".hbs");
        return viewResolver;
    }
}
