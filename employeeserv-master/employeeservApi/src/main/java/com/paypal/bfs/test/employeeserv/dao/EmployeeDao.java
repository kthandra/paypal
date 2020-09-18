package com.paypal.bfs.test.employeeserv.dao;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeDao {
    public Integer createEmployee(@RequestBody Employee employee) throws Exception;

    public Employee employeeGetById(String id) throws Exception;
}
