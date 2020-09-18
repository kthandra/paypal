package com.paypal.bfs.test.employeeserv.daoimpl;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer createEmployee(Employee employee) throws Exception {
        Integer employeeNumber ;
        if(employee.getId()!=null && employee.getId() > 0) {
            employeeNumber = employee.getId();
            String selectEmployee = "select * from employee where id = ?";
            List<Map<String, Object>> data = jdbcTemplate.queryForList(selectEmployee,employeeNumber);
            if(data.size()>0) {
                throw new Exception("Employee with id " + employeeNumber + " already exits");
            }
        }else {
            Random random = new Random();
            employeeNumber = random.nextInt(90) + 10;
        }

        String insertEmployeeQuery = "insert into employee values(?,?,?,?)";
        jdbcTemplate.update(
                insertEmployeeQuery,employeeNumber,employee.getFirstName(),employee.getLastName(),employee.getDateOfBirth());

        Address address = employee.getAddress();
        Random random = new Random();
        int addressNumber = random.nextInt(90) + 10;
        String insertAddressQuery = "insert into address values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(insertAddressQuery,addressNumber,employeeNumber,address.getLine1(),address.getLine2(),address.getCity(),address.getState(),address.getCountry(),address.getZipCode());

        return employeeNumber;
    }

    @Override
    public Employee employeeGetById(String id) throws Exception {
        String selectEmployee = "select * from employee where id = ?";
        List<Map<String, Object>> data = jdbcTemplate.queryForList(selectEmployee,Integer.parseInt(id));
        if(data.size()>0) {
            Employee employee = new Employee();
            Map<String,Object> map = data.get(0);
            employee.setId((Integer) map.get("id"));
            employee.setFirstName((String) map.get("firstname"));
            employee.setLastName((String) map.get("lastname"));
            employee.setDateOfBirth((String) map.get("dateofbirth"));

            String selectAddress = "select * from address where employeeId = ?";
            List<Map<String, Object>> addressData = jdbcTemplate.queryForList(selectAddress,Integer.parseInt(id));
            Map<String,Object> addressMap = addressData.get(0);
            Address address = new Address();
            address.setLine1((String) addressMap.get("line1"));
            address.setLine2((String) addressMap.get("line2"));
            address.setCity((String) addressMap.get("city"));
            address.setState((String) addressMap.get("state"));
            address.setCountry((String) addressMap.get("country"));
            address.setCountry((String) addressMap.get("zipcode"));

            employee.setAddress(address);
            return employee;
        } else {
            throw new Exception("Employee with id does not exits");
        }
    }
}
