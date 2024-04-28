package com.project.project3.domain;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/16 下午 08:09
 * @Version 1.0
 */
public class Architect extends Designer{
    private int stock; //股票

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return  getDetails() + "\t架構師\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam(){
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t\t" + getSalary() + "\t程序員\t"
                + getBonus() + "\t" + getStock();
    }
}
