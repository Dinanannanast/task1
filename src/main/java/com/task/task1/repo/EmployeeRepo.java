package com.task.task1.repo;

import com.task.task1.model.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends BaseRepo<Employee, Long> {
    @Query("select e from Employee e where LOWER(e.firstName)  like lower(concat('%',?1 ,'%'))")
    List<Employee> findByFirstNameIgnoringCase(String name);
}
