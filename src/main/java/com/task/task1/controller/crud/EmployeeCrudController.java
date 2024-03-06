package com.task.task1.controller.crud;

import com.task.task1.model.dto.EmployeeDto;
import com.task.task1.model.entity.Employee;
import com.task.task1.service.EmployeeCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/empl")
public class EmployeeCrudController extends BaseCrudController<Employee, EmployeeDto, Long> {

    private final EmployeeCrudService crudService;

    public EmployeeCrudController(EmployeeCrudService crudService) {
        super(crudService);
        this.crudService = crudService;
    }

    @GetMapping(path = "/byFirstName")
    public ResponseEntity<List<EmployeeDto>> findByFirstName(String name) {
        var employeeDtoList = crudService.findByFirstNameIgnoringCase(name);
        return ResponseEntity.ok(employeeDtoList);
    }

}
