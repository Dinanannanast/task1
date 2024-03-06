package com.task.task1.controller;

import com.task.task1.service.EmployeeCrudService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class EmployeePageController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final EmployeeCrudService employeeCrudService;

    @GetMapping(path = "/employee")
    public String employee() {
        return "employee";
    }

    @GetMapping(path = "/addEmployee")
    public String addEmployee() {
        return "addEmployee";
    }
}
