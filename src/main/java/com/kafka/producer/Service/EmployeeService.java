package com.kafka.producer.Service;

import com.kafka.producer.DTO.EmployeeDTO;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
}
