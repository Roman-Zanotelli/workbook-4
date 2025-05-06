package com.pluralsight;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance(){

        return balance;
    }

    public void addMoney(double amount){
        this.balance += amount;
    }

    /**
     * Sends Money from this Account to a recipient
     * @param recipient the account receiving money
     * @param amount the amount of money being sent
     * @return was the transaction a success
     */
    public boolean sendMoney(BankAccount recipient, double amount){

        /*
            If the recipient is null (does not exist)
            OR the amount being sent is more than the account has
            return false (signaling the transaction failed)
        */
        if(recipient == null || amount > this.balance) return false;

        //Add the money to the recipients account
        recipient.addMoney(amount);

        //remove the money from the senders (this) account
        this.balance -= amount;

        //return true (signaling the transaction was a success)
        return true;
    }
}
