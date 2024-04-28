package com.project.project3.service;

import com.project.project3.domain.*;

/**
 * ClassName:
 * Description:
 *              關於開發團隊成員的管理: 添加、刪除等。
 * @Author Rin
 * @Create 2024/4/17 上午 02:04
 * @Version 1.0
 */
public class TeamService {
    private static int counter = 1; //給memberId自動賦值的基數
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {
    }

    public TeamService(int counter, Programmer[] team, int total) {
        this.counter = counter;
        this.team = team;
        this.total = total;
    }

    /**
     * 傳回小組 目前現有人數 組成的一個新數組。
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] currentTeam = new Programmer[total];
        for (int i = 0; i < total; i++) {
            currentTeam[i] = team[i];
        }
        return currentTeam;
    }

    /**
     * 若排除下敘述各種可能，則添加小組成員
     * @param e
     * @throws TeamException
     */
    public void addMember(Employee e) throws TeamException{
        if (total >= MAX_MEMBER)
            throw new TeamException("成員已滿，無法添加");
        if (!(e instanceof Programmer))
            throw new TeamException("該成員不是開發人員，無法添加");

        Programmer p = (Programmer)e;
        switch (p.getStatus()) {
            case BUSY    :throw new TeamException("該員工已是某小組的成員");
            case VOCATION:throw new TeamException("該員工正在休假，無法添加");
        }

        int numOfArch = 0, numOfDsgn = 0, numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDsgn++;
            else if (team[i] instanceof Programmer) numOfPrg++;
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("團隊中最多只能有一名架構師");
        } else if (p instanceof Designer) {
            if (numOfDsgn >= 2) throw new TeamException("團隊中最多只能有兩名設計師");
        } else if (p instanceof Programmer) {
            if (numOfPrg >= 3) throw new TeamException("團隊中最多只能有三名程序員");
        }
        //添加到数组
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;

//        if (e instanceof Programmer){
//            Programmer p = (Programmer) e;
//            team[total] = p;
//            total++;
//            p.setMemberId(counter++); //賦值完才++，相當於p.setMemberId(counter); counter++; 兩行代碼
//            p.setStatus(Status.BUSY);
//        }else {
//            throw new TeamException("普通員工無法加入小組");
//        }
    }

    /**
     * 移除小組成員，並把剩餘成員 向前排序。
     * @param memberId
     * @throws TeamException
     */
    public void removeMember(int memberId) throws TeamException{

        int i = 0;
        for (; i < total; i++) {
            if(team[i].getMemberId() == memberId){
                team[i].setMemberId(-1); //可改可不改，MemberId由counter賦值，代表每個數都只會使用一次，所以不會有衝突情況。
                team[i].setStatus(Status.FREE);
                team[i] = null;

                for (int j = i; j < total - 1; j++) {
                    team[j] = team[j+1];
                }
//                team[total-1] = null;
//                total--;
                //合併
                team[--total] = null;
            }
        }

        if (i == total){
            throw new TeamException("找不到該小組成員");
        }
    }
}
