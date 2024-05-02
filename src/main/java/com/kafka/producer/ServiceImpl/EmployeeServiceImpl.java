package com.kafka.producer.ServiceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.DTO.EmployeeDTO;
import com.kafka.producer.Entity.Employee;
import com.kafka.producer.Service.EmployeeService;
import com.kafka.producer.Utils.KafkaConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private KafkaTemplate<String,EmployeeDTO> kafkaTemplate;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);

        List<EmployeeDTO> employeeList =List.of(employeeDTO);
        employeeList.forEach(a -> kafkaTemplate.send(KafkaConstants.TOPIC, a));

        return employeeDTO;
    }
    
}
