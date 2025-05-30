package com.gevernova.bankaccount;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        // Thread simulating deposits
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(200);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DepositThread");

        // Thread simulating withdrawals
        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(150);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "WithdrawThread");

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}
