package com.gevernova.bankaccount;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        balance = initialBalance;
    }
    // synchronized deposit method to avoid race conditions
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", balance: " + balance);
    }

    // synchronized withdraw method to avoid race conditions
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw " + amount + " (Insufficient funds), balance: " + balance);
        }
    }
    public int getBalance() {
        return balance;
    }
}
