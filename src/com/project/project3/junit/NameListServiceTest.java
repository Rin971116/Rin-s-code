package com.project.project3.junit;

import com.project.project3.domain.Employee;
import com.project.project3.service.NameListService;
import com.project.project3.service.TeamException;
import org.junit.Test;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/17 上午 01:25
 * @Version 1.0
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployee(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        try {
            NameListService nameListService = new NameListService();
            int id = 13; //報TeamException
            id = 3;
            Employee e = nameListService.getEmployee(id);
            System.out.println(e);
        } catch (TeamException ex) {
//            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
