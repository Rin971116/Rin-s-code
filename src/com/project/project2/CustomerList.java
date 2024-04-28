package com.project.project2;

/**
 * ClassName:
 * Description:
 *      CustomerList類為Customer物件的管理模塊，內部使用數組管理一些Customer物件
 *      (訓練重點)管理系統；四大重點功能:
 *                                  1.數組的增
 *                                  2.數組的刪
 *                                  3.數組的改
 *                                  4.數組的查
 * @Author Rin
 * @Create 2024/3/12 下午 10:40
 * @Version 1.0
 */
public class CustomerList {

    Customer[] customers; //用來保存Customer類的物件
    int total; //紀錄數組中的Customer物件的數量,total-1則可以作為數組目前最後一位非null元素的索引

    /**
     * 用來初始化 customers 的長度
     * @param totalCustomer 指定 customers 長度的值
     */
    public CustomerList (int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 增加客戶至 customers數組的空位
     * @param customer 欲增加的 customer對象
     * @return true:添加成功; false:添加失敗
     */
    public boolean addCustomer(Customer customer){
        if (total < customers.length){
            customers[total] = customer;
            total++;
            return true;
        }
        return false;
    }

    /**
     * 替換客戶資料
     * @param index 被替換的客戶索引
     * @param newCustomer 替換上的客戶對象(從 0開始)
     * @return true:替換成功; false:替換失敗;
     */
    public boolean replaceCustomer(int index,Customer newCustomer){
        if (index >= 0 && index < total){
            customers[index] = newCustomer;
            return true;
        }
        return false;
    }

    /**
     * 刪除 customers[index]中的對象
     * @param index 欲刪除的對象索引
     * @return true:delete sucess; false:delete fail
     */
    public boolean deleteCustomer(int index){
        if (index >= 0 && index < total){
            for (int i = index; i < total; i++) {
                customers[i] = customers[i+1];
            }
//            customers[total-1] = null;
//            total--;
            customers[--total] = null;
            return true;
        }
        return false;
    }

    /**
     * 取得目前數組已有的所有物件，空的不傳回
     * @return 傳回複製後的數組
     */
    public Customer[] getAllCustomer(){
        Customer[] customersCopy = new Customer[total];
        for (int i = 0; i < total; i++) {
            customersCopy[i] = customers[i];
        }
        return customersCopy;
    }

    /**
     * 取得 customers[index]中的對象
     * @param index 欲取得的對象在數組中的索引
     * @return 欲取得的 customer對象
     */
    public Customer getCustomer(int index){
        if (index >= 0 && index < total){
            return customers[index];
        }
        return null;
    }

    /**
     * 獲取客戶數量，也就是total
     * @return 目前的客戶總數量
     */
    public int getTotal(){
        return total;
    }
}
