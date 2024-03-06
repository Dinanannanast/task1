package com.task.task1.service.mapper;

import com.github.dozermapper.core.Mapper;
import com.task.task1.model.dto.EmployeeDto;
import com.task.task1.model.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDtoMapper extends BaseDtoMapper<Employee, EmployeeDto, Long> {

    public EmployeeDtoMapper(Mapper mapper) {
        super(mapper);
    }

}
