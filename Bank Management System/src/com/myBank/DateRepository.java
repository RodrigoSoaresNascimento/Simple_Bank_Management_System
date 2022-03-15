package com.myBank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class DateRepository {
	
	HashMap <Integer, Accounts> accountsDates = new HashMap<>();
	
	public void register() {
		Scanner scr = new Scanner(System.in);
		System.out.println("Digite o numero da sua conta :");
		int acountNumber = scr.nextInt();
		if(acountNumber < 999999 && acountNumber > 100000) {
			System.out.println("Digite seu nome :");
			String acountName = scr.next();
			if(!acountName.equals(null)) {
				int generatePin = generatePinNumber();
				System.out.println("Digite seu numero pin : "  + generatePin);
				int pinNumber = scr.nextInt();
				if(pinNumber == generatePin) {
					System.out.println("Informe o valor do deposito inicial : ");
					double amount = scr.nextInt();
					while(amount < 50) {
						System.out.println("Informe um valor valido : ");
						amount = scr.nextInt();
					}
					Accounts account = new Accounts(acountName, pinNumber, amount);
					accountsDates.put(acountNumber, account);
					System.out.println("Conta criada com sucesso! ");
					
					System.out.println("Para continuar acesse o login! ");
					login();
				}
			}
		}
		scr.close();
	}
	
	public int generatePinNumber () {
		Random random = new Random();
		int firstNumber = random.nextInt(9), secondNumber = random.nextInt(9);
		int pinNumber = 1000 * (firstNumber * secondNumber);
		return pinNumber;
	}
	
	public void accountSection(int loginAccNum, int loginPinNun) {
		Scanner input = new Scanner(System.in);
		Menu menu = new Menu();
		Accounts accounts = null;
		boolean isAccountExist = false;
		for(Map.Entry<Integer, Accounts> entry1 : accountsDates.entrySet() ) {
			accounts = entry1.getValue();
			if(loginAccNum == entry1.getKey() && loginPinNun == accounts.getPinNumber()) {
				System.out.println("--------- Informações da conta -----------");
				System.out.println("Numero da conta " + entry1.getKey());
				System.out.println("Titular da conta "+ accounts.getAccountName());
				System.out.println("Saldo da conta "+ accounts.getDepositAmount());
				isAccountExist = true;
			}
		}
		if(isAccountExist == false) {
			System.out.println("Esta conta não está resgistrada ainda! ");
			System.out.println("Registre uma nova conta para continuar ");
			register();
		}else {
			System.out.println("Digite 1 para depositar ");
			System.out.println("Digite 0 para sair ");
			System.out.println("Digite 2 para sacar ");
			int choise = input.nextInt();
			switch(choise) {
			case 0:
				menu.home();
				break;
			case 1:
				System.out.println("Digite o valor do deposito : ");
				double deposit = input.nextDouble();
				accounts.setDepositAmount(accounts.getDepositAmount() + deposit); 
				accountSection(loginAccNum, loginPinNun);
				break;
			case 2:
				System.out.println("Digite o valor do saque : ");
				double withdraw = input.nextDouble();
				if(withdraw > accounts.getDepositAmount()) {
					System.out.println("Saldo insuficiente !");
					menu.home();
				}else {
					accounts.setDepositAmount(accounts.getDepositAmount() - withdraw); 
					accountSection(loginAccNum, loginPinNun);
				}
				break;
			default:
				System.out.println("Digite uma opção valida ");
				accountSection(loginAccNum, loginPinNun);
			}
		}
		input.close();
	}
	public void login () {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite seu numero de conta : ");
		int loginAccNum = input.nextInt();
		System.out.println("Digite seu numero pin : ");
		int loginPinNun = input.nextInt();
		accountSection(loginAccNum, loginPinNun);
		input.close();
	}
	

}
