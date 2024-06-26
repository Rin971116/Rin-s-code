package com.project.project3.domain;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/16 下午 08:08
 * @Version 1.0
 */
public class Designer extends Programmer{
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    @Override
    public String toString() {
        return  getDetails() + "\t設計師\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }
    @Override
    public String getDetailsForTeam(){
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t\t" + getSalary() + "\t程序員\t"
                 + getBonus();
    }
}
