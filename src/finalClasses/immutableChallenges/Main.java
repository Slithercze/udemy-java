package finalClasses.immutableChallenges;

import finalClasses.immutableChallenges.bank.Bank;
import finalClasses.immutableChallenges.bank.BankAccount;
import finalClasses.immutableChallenges.bank.BankCustomer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

//        BankCustomer joe = new BankCustomer("Joe", 500.00, 10000.00);
//        System.out.println(joe);

        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe", 500.00, 10000.00);

        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, 35)){
            System.out.println(joe);
        }

        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, -535)){
            System.out.println(joe);
        }

        BankAccount checking = joe.getAccount(BankAccount.AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k,v) -> System.out.println(k + ": " + v));

//        System.out.println("----------------"); i prevent exposing transaction instance to client
//        for (var tx : transactions.values()){
//            tx.setCustomerId(2);
//            tx.setAmount(10000.00);
//        }
//        transactions.forEach((k,v) -> System.out.println(k + ": " + v));

       var test1 = joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions();
        System.out.println("funguje? "+test1);
        test1.clear();
        System.out.println("rip "+test1); //na joe transakce to nema zadny vliv

        System.out.println("--------------------");
        joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions()
                .forEach((k,v) -> System.out.println(k + ": " + v));

//        List<BankAccount> accounts = joe.getAccounts(); //v constructoru jsme pozmenili referenci na novou kopii
//        accounts.clear();
//        System.out.println(joe);

//        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 150000)); error constructor v jinym packagi
//        System.out.println(joe);

    }

}
