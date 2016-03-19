package com.daggerok.spring.isomorphic.web;

import com.daggerok.spring.isomorphic.web.annotation.Get;
import com.daggerok.spring.isomorphic.web.model.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;

@Controller
public class IndexPage {
    @Value("{spring.application.name:title}")
    String appName;

    @Get("/")
    public String index(Model model) {
        model.addAttribute("title", appName);
        model.addAttribute("comments", asList("one,two.three".split(",")).stream()
                .map(i -> Comment.of(i, String.valueOf(i.length())))
                .collect(toSet()));
        return "index";
    }
}
