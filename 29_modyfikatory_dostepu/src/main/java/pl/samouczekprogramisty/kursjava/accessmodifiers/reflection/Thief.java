package pl.samouczekprogramisty.kursjava.accessmodifiers.reflection;

import java.lang.reflect.Field;

public class Thief {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        BankAccount account = new BankAccount();
        System.out.println("Stan konta: " + account.getBalance());

        Field balance = BankAccount.class.getDeclaredField("balance");
        balance.setAccessible(true);
        balance.set(account, -5000);

        System.out.println("Stan konta: " + account.getBalance());
    }
}
