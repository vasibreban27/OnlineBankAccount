public class BankAccount {
    private String accountHolder;
    private double balance;
    private double economyAccountBalance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.economyAccountBalance = 0.0;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getEconomyAccountBalance() {
        return this.economyAccountBalance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if(amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public boolean depositToEconomyAccount(double amount) {
        if(amount <= balance)
        {
            balance -= amount;
            this.economyAccountBalance += amount;
            return true;
        }
        return false;
    }

    public boolean withdrawFromEconomyAccount(double amount) {
        if(amount <= economyAccountBalance)
        {
            economyAccountBalance -= amount;
            return true;
        }
        return false;
    }
}