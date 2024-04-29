package threads.synchonization;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) { //when one thread is exe a sync method for an obj, all other threads
        //that invoke sync methods for the same obj block and suspend their exe until first thread is done with the obj

        try {
            System.out.println("Deposit - Talking to the teller at the bank...");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            double origBalance = balance;
            balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f) : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        }
    }

    public synchronized void withdrawal(double amount) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double origBalance = balance;
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f) : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        } else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f) : INSUFFICIENT FUNDS!", origBalance, amount);
        }
    }
}
