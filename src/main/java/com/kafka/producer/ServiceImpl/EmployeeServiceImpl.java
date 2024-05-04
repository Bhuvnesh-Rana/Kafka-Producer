package com.kafka.producer.ServiceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.DTO.EmployeeDTO;
import com.kafka.producer.Entity.Employee;
import com.kafka.producer.Repository.EmployeeRepository;
import com.kafka.producer.Service.EmployeeService;
import com.kafka.producer.Utils.KafkaConstants;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private KafkaTemplate<String,EmployeeDTO> kafkaTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        if (employeeRepository.existsByEmployeeId(employee.getEmployeeId())) {
            System.out.println("Employee alredy present...");
            return "Employee allready present with Employee Id: "+employee.getEmployeeId();
        }
        
        
        else{
        employeeRepository.save(employee);
        List<EmployeeDTO> employeeList =List.of(employeeDTO);
        employeeList.forEach(a -> kafkaTemplate.send(KafkaConstants.TOPIC, a));
        return "Employee published "+employeeDTO;
        }
        
    }
    
}
