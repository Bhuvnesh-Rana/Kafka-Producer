package com.kafka.producer.Entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    private Integer id;
    private String name;
    private LocalDate dob;
    private String company;
    private String employeeId;
}
