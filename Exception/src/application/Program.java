package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account;
        int numberAccount;
        String holderName;
        double balance;
        double withdrawLimit;

        System.out.println("Enter account data: ");

        try {

            System.out.print("Number: " );
            numberAccount = sc.nextInt();
            sc.nextLine();

            System.out.print("Holder: ");
            holderName = sc.nextLine();

            System.out.print("Initial balance: ");
            balance = sc.nextDouble();

            System.out.print("Withdrawal limit: ");
            withdrawLimit = sc.nextDouble();

            account = new Account(numberAccount, holderName, balance, withdrawLimit);

            System.out.print("\nEnter the amount for withdraw: ");
            balance = sc.nextDouble();

            account.withdraw(balance);

            System.out.println("New balance: " + account.getBalance());

        } catch (BusinessException e) {System.out.println("Withdraw error: " + e.getMessage());
        } catch (InputMismatchException e) {System.out.println("Please enter an integer");}

        sc.close();
    }
}
