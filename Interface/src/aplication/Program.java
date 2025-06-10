package aplication;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ContractService contractService = new ContractService(new PaypalService());
        Contract contract;
        LocalDate contractDate;
        double contractAmount;
        int contractNumber;
        int months;

        System.out.println("Enter the contract data: ");

        System.out.print("Number: ");
        contractNumber = sc.nextInt();

        System.out.print("Date (dd/mm/yyyy): ");
        contractDate = LocalDate.parse(sc.next(), dtf);

        System.out.print("Contract amount: ");
        contractAmount = sc.nextDouble();

        contract = new Contract(contractNumber, contractDate, contractAmount);

        System.out.print("Enter the number of installments: ");
        months = sc.nextInt();

        contractService.processContract(contract, months);

        System.out.println("\nInstallments: ");
        for (Installment installment : contract.getInstallments()) System.out.println(installment);

        sc.close();
    }
}
