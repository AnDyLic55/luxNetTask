package com.luxnet.testTask.repo;

import com.luxnet.testTask.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
}
