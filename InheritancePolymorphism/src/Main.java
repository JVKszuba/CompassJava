import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<TaxPayer>();
        String name;

        double annualIncome;
        double healthExpenditures;
        double totalTaxes = 0;
        int numberEmployees;
        int taxPayersQuantity;
        char taxPayerType;

        System.out.print("Enter the number of tax payers: ");
        taxPayersQuantity = sc.nextInt();

        for (int i = 0; i < taxPayersQuantity; i++) {

            System.out.println("\nTax payer #" + (i + 1) + " data:");

            do {

                System.out.print("Individual or company (i/c): ");
                taxPayerType = sc.next().charAt(0);

            } while (taxPayerType != 'i' && taxPayerType != 'c');

            System.out.print("Name: ");
            sc.nextLine();
            name = sc.nextLine();

            System.out.print("Annual Income: ");
            annualIncome = sc.nextDouble();

            if (taxPayerType == 'c') {

                System.out.print("Number of employees: ");
                numberEmployees = sc.nextInt();

                taxPayers.add(new Company(name, annualIncome, numberEmployees));

            } else {

                System.out.print("Health expenditures: ");
                healthExpenditures = sc.nextDouble();

                taxPayers.add(new Individual(name, annualIncome, healthExpenditures));
            }
        }

        System.out.println("\nTAXES PAID: ");

        for (TaxPayer payer : taxPayers) {

            System.out.printf("%s: $ %.2f%n", payer.getName(), payer.calculateTax());

            totalTaxes += payer.calculateTax();
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f", totalTaxes);

        sc.close();
    }
}