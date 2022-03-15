package com.myBank;

import java.util.Scanner;

public class Menu {
	
	public void home() {
		Scanner scanner = new Scanner(System.in);
		DateRepository repository = new DateRepository();
		System.out.println("Digite 1 para logar ");
		System.out.println("Digite 2 para registar ");
		int choise = scanner.nextInt();
		if(choise == 1) {
			repository.login();
		}else if(choise == 2) {
			
			repository.register();
			
		}else {
			System.out.println("Opção invalida digitada ");
			home();
		}
		
		scanner.close();
	}
	
}
