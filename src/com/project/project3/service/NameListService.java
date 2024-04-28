package com.project.project3.service;

import com.project.project3.domain.*;

/**
 * ClassName:
 * Description:
 *      負責將 Data中的數據封裝到Employee[] 中，同時提供操作 Employee[]的方法。
 *
 * @Author Rin
 * @Create 2024/4/16 下午 08:12
 * @Version 1.0
 */
public class NameListService {
    private Employee[] employees;

    /**
     * constructor，建立 NameListService時，就要把 Employee[]中的所有對象建好 (把 Data中的資料 new成對象塞進去)。
     */
    public NameListService(){
        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            // 获取通用的属性
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Integer.parseInt(Data.EMPLOYEES[i][4]);

            //
            Equipment eq;
            double bonus;
            int stock;

            switch (type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case Data.DESIGNER:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case Data.ARCHITECT:
                    eq = createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus,
                            stock);
                    break;
            }
        }
    }

    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQIPMENTS[index][0]);
        switch (type) {
            case Data.PC:
                return new PC(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
            case Data.NOTEBOOK:
                int price = Integer.parseInt(Data.EQIPMENTS[index][2]);
                return new NoteBook(Data.EQIPMENTS[index][1], price);
            case Data.PRINTER:
                return new Printer(Data.EQIPMENTS[index][1], Data.EQIPMENTS[index][2]);
        }
        return null;
    }
    /**
     * 傳回整個數組，也就是員工名冊
     * @return
     */
    public Employee[] getAllEmployees(){
        return employees;
    }

    /**
     * 傳回 Employee[]中的個別員工 (Employee對象)。
     * @param id = Employee[]中的 index+1
     * @return
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException{
        if (id <= 0 || id > employees.length){
            throw new TeamException("找不到指定員工");
        }else{
            return employees[id-1];
        }
    }
}
