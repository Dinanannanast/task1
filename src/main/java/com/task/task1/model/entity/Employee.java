package com.task.task1.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity<Long> {
    private String iin;
    private String firstName;
    private String secondName;
    private String patronymic;

    private String phone;
    private String email;
    private String country;
    private String city;
}
