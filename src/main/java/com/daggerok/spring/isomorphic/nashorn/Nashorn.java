package com.daggerok.spring.isomorphic.nashorn;

import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
//import org.springframework.stereotype.Component;
//@Component // not used, see com.daggerok.spring.isomorphic.config.AppCfg
public class Nashorn {

    private Invocable nashorn;

    @PostConstruct
    private void engine() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByExtension("nashorn");
        this.nashorn = (Invocable) engine;
    }

    @SneakyThrows
    public Object call(String function, Object... arguments) {
        return nashorn.invokeFunction(function, arguments);
    }
}
