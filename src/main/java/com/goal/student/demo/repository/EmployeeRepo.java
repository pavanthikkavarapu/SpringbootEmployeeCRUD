package com.goal.student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goal.student.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
