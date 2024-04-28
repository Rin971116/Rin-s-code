package com.project.project1;

import java.util.*;


class AccountCalculator{

	int times = 0;
	int allMoney = 0;
	//?H?U????i??A?}?C???äD
	ArrayList<Integer> details = new ArrayList<Integer>();
	ArrayList<String> directions = new ArrayList<String>();

	void addMoney(int money){
		allMoney += money;
		details.add(money);
		times++;
		System.out.println("?w?s?J"+ money +"???A??e?b??l?B??:"+ allMoney +"??");
	}

	void minusMoney(int money){
		allMoney -= money;
		details.add(-money);
		times++;
		System.out.println("?w????"+ money +"???A??e?b??l?B??:"+ allMoney +"??");
	}

	void storeDirections(String directions){
		this.directions.add(directions);
	}
	
	void showDetails(){
		System.out.println("?b??l?B\t??????B\t??    ??");
		if(times != 0){
			for(int index = 0; index <= times-1; index++){
				System.out.println(allMoney + "\t\t" + details.get(index) + "\t\t" + directions.get(index));
			}
		}
	}
}


class GoAccountCalculator{

	public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);

	AccountCalculator ac1 = new AccountCalculator();
	
	loopOption:while(true){					
					System.out.println("----------------------------------------\n");
					System.out.println("1.???????");
					System.out.println("2.?n?O???J");
					System.out.println("3.?n?O??X");
					System.out.println("4.?h?X\n");
					System.out.println("----------------------------------------\n");
					System.out.println("???J1-4:");
					
					String option = sc.next();
					
					switch(option){
						case "1": 
							System.out.println("----------------?b?????----------------");
							ac1.showDetails();
							break;
						case "2":
							System.out.println("???J?A???J?????B:");
							ac1.addMoney(sc.nextInt());
							System.out.println("???J????:");
							ac1.storeDirections(sc.next());
							break;
						case "3": 
							System.out.println("???J?A??X?????B:");
							ac1.minusMoney(sc.nextInt());
							System.out.println("???J????:");
							ac1.storeDirections(sc.next());
							break;
						case "4": 
							System.out.println("???b?h?X...");
							break loopOption;
						default: System.out.print("??J???~");
							break;
					}
				}
	}
}