package com.kafka.producer.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    
    private String name;
    private LocalDate dob;
    private String company;
    private String employeeId;
}
