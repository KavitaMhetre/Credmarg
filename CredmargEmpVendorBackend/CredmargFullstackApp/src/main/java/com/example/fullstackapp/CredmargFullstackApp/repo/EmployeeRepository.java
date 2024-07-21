package com.example.fullstackapp.CredmargFullstackApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fullstackapp.CredmargFullstackApp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
