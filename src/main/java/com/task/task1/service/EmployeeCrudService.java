package com.task.task1.service;

import com.task.task1.model.dto.EmployeeDto;
import com.task.task1.model.entity.Employee;
import com.task.task1.repo.EmployeeRepo;
import com.task.task1.service.mapper.EmployeeDtoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeCrudService extends BaseCrudService<Employee, EmployeeDto, Long> {

    private final EmployeeRepo repo;
    private final EmployeeDtoMapper mapper;

    public EmployeeCrudService(EmployeeRepo employeeRepo, EmployeeDtoMapper employeeDtoMapper) {
        super(employeeRepo, employeeDtoMapper, Employee.class, EmployeeDto.class);
        this.repo = employeeRepo;
        this.mapper = employeeDtoMapper;
    }

    @Transactional
    public List<EmployeeDto> findByFirstNameIgnoringCase(String name) {
        List<Employee> entities = repo.findByFirstNameIgnoringCase(name);
        log.debug("Found {} entities", entities.size());
        return mapper.toDto(entities, EmployeeDto.class);
    }
}
