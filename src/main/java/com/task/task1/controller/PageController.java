package com.task.task1.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PageController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        log.debug("index request");
        model.addAttribute("name", applicationName);
        return "index";
    }
}
