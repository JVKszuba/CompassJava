public class Account {

    private final int id;
    private String holderName;
    private double balance;

    public Account(int id, String holderName, double initialDeposit) {

        this.id = id;
        this.holderName = holderName;

        makeDeposit(initialDeposit);
    }

    public Account(int id, String holderName) {

        this.id = id;
        this.holderName = holderName;
    }

    public int getId() {

        return id;
    }

    public void setHolderName(String holderName) {

        this.holderName = holderName;
    }

    public String getHolderName() {

        return holderName;
    }

    public double getBalance() {

        return balance;
    }

    public void makeDeposit(double amount) {

        this.balance += amount;
    }

    public void makeWithdraw(double amount) {

        this.balance -= (amount + 5);
    }

    public String toString() {

        return "Account = " + getId() + ", Holder = " + getHolderName() + ", Balance = $ " + getBalance() + "\n";
    }
}
