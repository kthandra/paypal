package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeService {

    public Integer createEmployee(@RequestBody Employee employee) throws Exception;

    public Employee employeeGetById(String id) throws Exception;
}
