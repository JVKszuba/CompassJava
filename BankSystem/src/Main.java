import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;
        String name;
        char answer;
        double value;
        int id;

        System.out.print("Enter account number: ");
        id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter account holder: ");
        name = sc.nextLine();

        do {

            System.out.print("Is there an initial deposit (y/n)?");
            answer = sc.nextLine().toLowerCase().charAt(0);

        } while (answer != 'y' && answer != 'n');

        if (answer == 'y') {

            System.out.print("Enter initial deposit amount: ");
            value = sc.nextDouble();

            account = new Account(id, name, value);

        } else account = new Account(id, name);

        System.out.println("\nAccount data:\n" + account);

        System.out.print("Enter a deposit amount: ");
        value = sc.nextDouble();
        account.makeDeposit(value);
        System.out.println("Updated account data:\n" + account);

        System.out.print("Enter a withdrawal amount: ");
        value = sc.nextDouble();
        account.makeWithdraw(value);
        System.out.println("Updated account data:\n" + account);

        sc.close();
    }
}