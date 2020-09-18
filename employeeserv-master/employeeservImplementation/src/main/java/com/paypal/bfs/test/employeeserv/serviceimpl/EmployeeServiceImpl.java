package com.paypal.bfs.test.employeeserv.serviceimpl;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Integer createEmployee(Employee employee) throws Exception {
       return employeeDao.createEmployee(employee);
    }

    @Override
    public Employee employeeGetById(String id) throws Exception {
        return employeeDao.employeeGetById(id);
    }
}
