package com.kafka.producer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.producer.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    boolean findByEmployeeId(String b);
    boolean existsByEmployeeId(String b);
}
