package finalExplored.immutableChallenges;

import finalExplored.immutableChallenges.bank.BankAccount;
import finalExplored.immutableChallenges.bank.BankCustomer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

        BankCustomer joe = new BankCustomer("Joe", 500.00, 10000.00);
        System.out.println(joe);

        List<BankAccount> accounts = joe.getAccounts(); //v constructoru jsme pozmenili referenci na novou kopii
        accounts.clear();
        System.out.println(joe);

//        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 150000)); error constructor v jinym packagi
//        System.out.println(joe);

    }

}
