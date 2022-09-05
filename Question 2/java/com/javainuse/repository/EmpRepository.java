package com.javainuse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
