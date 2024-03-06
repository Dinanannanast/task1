package com.task.task1.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.task.task1.model.dto.annotation.ValidCity;
import com.task.task1.model.dto.annotation.ValidCountry;
import com.task.task1.model.dto.annotation.ValidEmail;
import com.task.task1.model.dto.annotation.ValidFirstName;
import com.task.task1.model.dto.annotation.ValidIin;
import com.task.task1.model.dto.annotation.ValidPatronymic;
import com.task.task1.model.dto.annotation.ValidPhone;
import com.task.task1.model.dto.annotation.ValidSecondName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDto extends BaseDto {
    @ValidIin
    private String iin;
    @ValidFirstName
    private String firstName;
    @ValidSecondName
    private String secondName;
    @ValidPatronymic
    private String patronymic;
    @ValidPhone
    private String phone;
    @ValidEmail
    private String email;
    @ValidCountry
    private String country;
    @ValidCity
    private String city;
}
