package com.project.project3.view;

import com.project.project3.domain.Employee;
import com.project.project3.domain.Programmer;
import com.project.project3.service.NameListService;
import com.project.project3.service.TeamException;
import com.project.project3.service.TeamService;

/**
 * ClassName:
 * Description:
 *              作為整個 project 執行的入口，包含前端畫面也一起寫在這。
 *              需求 1: 前端畫面的表現
 *              需求 2: main()作為 project執行的入口
 * @Author Rin
 * @Create 2024/4/16 下午 08:25
 * @Version 1.0
 */
public class TeamView {
    private NameListService nameListService = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean loopFlag = true;
        char key = 0;

        do {
            if (key != '1') {
                listAllEmployees();
            }
            System.out.print("1-團隊列表  2-添加團隊成員  3-刪除團隊成員 4-退出   請選擇(1-4):");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("確認是否退出(Y/N)：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y')
                        loopFlag = false;
                    break;
            }
        } while (loopFlag);
    }

    // 顯示所有的員工成員
    private void listAllEmployees() {
        System.out
                .println("\n-------------------------------優尚開發團隊調度系統--------------------------------\n");
        Employee[] emps = nameListService.getAllEmployees();
        if (emps.length == 0) {
            System.out.println("沒有客戶紀錄!");
        } else {
            System.out.println("ID\t姓名\t年齡\t薪水\t職位\t狀態\t獎金\t股票\t領用設備");
        }
        for(int i = 0;i < emps.length;i++){
            System.out.println(" " + emps[i]);
        }
        System.out
                .println("-------------------------------------------------------------------------------");
    }

    // 顯示開發團隊成員列表
    private void listTeam() {
        System.out
                .println("\n--------------------團隊成員列表---------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team.length == 0) {
            System.out.println("開發團隊目前沒有成員!");
        } else {
            System.out.println("TID/ID\t姓名\t年齡\t薪水\t職位\t獎金\t股票");
        }
        for (int i = 0; i < team.length; i++) {
            System.out.println(" " + team[i].getDetailsForTeam());
        }
        System.out
                .println("-----------------------------------------------------");
    }

    // 新增成員到團隊
    private void addMember() {
        System.out.println("---------------------添加成員---------------------");
        System.out.print("請輸入要添加的員工ID：");
        int id = TSUtility.readInt();

        try {
            Employee e = nameListService.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失敗，原因:" + e.getMessage());
        }
        // 輸入enter繼續...
        TSUtility.readReturn();
    }

    // 從團隊中刪除指定id的成員
    private void deleteMember() {
        System.out.println("---------------------刪除成員---------------------");
        System.out.print("請輸入要刪除員工的TID:");
        int id = TSUtility.readInt();
        System.out.print("確認是否刪除(Y/N):");
        char yn = TSUtility.readConfirmSelection();
        if (yn == 'N')
            return;

        try {
            teamSvc.removeMember(id);
            System.out.println("刪除成功");
        } catch (TeamException e) {
            System.out.println("刪除失敗，原因:" + e.getMessage());
        }
        // 輸入enter繼續...
        TSUtility.readReturn();
    }


    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
