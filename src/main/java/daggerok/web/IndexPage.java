package daggerok.web;

import daggerok.web.model.Comment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Controller
public class IndexPage {

  @Value("${spring.application.name:title}")
  String appName;

  @GetMapping
  public String index(final Model model) {
    model.addAttribute("title", appName);
    model.addAttribute("comments",
                       Stream.of("one", "two", "three")
                             .map(i -> Comment.of(i, String.valueOf(i.length())))
                             .collect(toSet()));
    return "index";
  }
}
