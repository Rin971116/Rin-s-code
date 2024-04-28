package com.project.project2;


/**
 * ClassName:
 * Description:
 * CustomerView為主模塊，負責 menu的顯示和處理用戶的操作
 *
 * @Author Rin
 * @Create 2024/3/12 下午 10:40
 * @Version 1.0
 */
public class CustomerView {
    CustomerList cl = new CustomerList(10);

    public void enterMainMenu() {
        char selection;

        loopMenu:
        while (true) {
            System.out.println("--------客戶管理系統--------");
            System.out.println("\t\t1.添加客戶");
            System.out.println("\t\t2.修改客戶");
            System.out.println("\t\t3.刪除客戶");
            System.out.println("\t\t4.客戶列表");
            System.out.println("\t\t5.退\t出");
            System.out.println();
            System.out.print("\t\t請選擇(1~5):");

            selection = CMUtility.readMenuSelection();

            switch (selection) {

                case '1':
                    addNewCustomer();
                    break;

                case '2':
                    modifyCustomer();
                    break;

                case '3':
                    deleteCustomer();
                    break;

                case '4':
                    listAllCustomers();
                    break;

                case '5':
                    System.out.print("是否要退出(Y/N):");
                    char isOut = CMUtility.doubleCheck();
                    if(isOut == 'y'){
                        System.out.println("退出中...");
                        break loopMenu;
                    } else if (isOut == 'n') {
                        break;
                    }

            }
        }
    }

    private void addNewCustomer() {
        System.out.println("--------添加客戶--------");

        System.out.print("姓名:");
        String name = CMUtility.readString(4);

        System.out.print("性別:");
        char gender = CMUtility.readChar();

        System.out.print("年紀:");
        int age = CMUtility.readInt();

        System.out.print("電話:");
        String phoneNumber = CMUtility.readString(10);

        System.out.print("電子信箱:");
        String email = CMUtility.readGmail();

        boolean isFlag = cl.addCustomer(new Customer(name,gender,age,phoneNumber,email));
        if (isFlag) {
            System.out.println("--------添加完成--------");

        }else System.out.println("------失敗!!目錄已滿------");
    }

    private void modifyCustomer() {
        boolean isFill = true;
        while (isFill) {

            System.out.print("請輸入欲更改的客戶編號:");
            int index = CMUtility.readInt()-1; //用戶看到編號從1開始
            Customer target = cl.getCustomer(index);

            if (target == null) {
                System.out.println("查無此人，請重新輸入:");

            }else {
                System.out.print("姓名("+target.getName()+") :");
                String name = CMUtility.readString(4,target.getName());

                System.out.print("性別("+target.getGender()+") :");
                char gender = CMUtility.readChar(target.getGender());

                System.out.print("年紀("+target.getAge()+") :");
                int age = CMUtility.readInt(target.getAge());

                System.out.print("電話("+target.getPhoneNumber()+") :");
                String phoneNumber = CMUtility.readString(10,target.getPhoneNumber());

                System.out.print("電子信箱("+target.getEmail()+") :");
                String email = CMUtility.readGmail(target.getEmail());

                cl.replaceCustomer(index,new Customer(name,gender,age,phoneNumber,email));
                System.out.println("--------更改成功--------");
                isFill = false;
            }
        }
    }

    private void deleteCustomer() {
        boolean isFill = true;
        System.out.print("請輸入欲刪除的客戶編號(輸入0離開):");

        while (isFill) {

            int index = CMUtility.readInt()-1; //用戶看到編號從1開始
            if (index < 0){
                break;
            }

            Customer target = cl.getCustomer(index);

            if (target == null) {
                System.out.println("查無此人，請重新輸入:");

            }else {
                while (true) {
                    System.out.print("是否要刪除(Y/N):");
                    char isDelete = CMUtility.doubleCheck();
                    if (isDelete == 'y') {
                        cl.deleteCustomer(index);
                        System.out.println("--------刪除成功--------");

                    } else if (isDelete == 'n') break;
                }

                isFill = false;
            }
        }
    }

    private void listAllCustomers() {
        System.out.println("--------客戶列表--------");
        System.out.println("編號\t姓名\t性別\t年紀\t電話\t\t\t電子信箱");
        Customer[] customers = cl.getAllCustomer();
        if (customers.length == 0){
            System.out.println("--------尚無客戶資料--------");

        }else {
            for (int i = 0; i < customers.length; i++) {

                System.out.println(i + 1 + "\t\t" + customers[i].getName() + "\t" + customers[i].getGender() + "\t\t" + customers[i].getAge() +
                        "\t\t" + customers[i].getPhoneNumber() + "\t\t" + customers[i].getEmail()); //用戶看到編號從1開始
            }
        }
    }

    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }
}
