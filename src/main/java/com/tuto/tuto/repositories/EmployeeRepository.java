package com.tuto.tuto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tuto.tuto.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}