package com.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest{

    @Test
    public void sending_more_than_account_balance_cancels(){

        //Arrange
        BankAccount accountA = new BankAccount( 100);
        BankAccount accountB = new BankAccount(100);

        //Act
        boolean result = accountA.sendMoney(accountB, 200);


        //Assert

        //Did the function signal it canceled?
        assertFalse(result);

        //Are all the initial values the same? (Just because it signaled that it canceled doesn't mean it actually did)
        assertEquals(100, accountA.getBalance());
        assertEquals(100, accountB.getBalance());
    }

    @Test
    public void sending_valid_amount_succeeds(){

        //Arrange
        BankAccount accountA = new BankAccount( 100);
        BankAccount accountB = new BankAccount(100);

        //Act
        boolean result = accountA.sendMoney(accountB, 50);

        //Assert

        //Did the function signal success?
        assertTrue(result);

        //Are the balances of each account what we expect?
        assertEquals(50, accountA.getBalance());
        assertEquals(150, accountB.getBalance());
    }

    @Test
    public void sending_to_null_account_cancels(){

        //Arrange
        BankAccount accountA = new BankAccount( 100);
        BankAccount accountB = null;

        //Act
        boolean result = accountA.sendMoney(accountB, 50);

        //Assert
        assertFalse(result);
        assertEquals(100, accountA.getBalance());
    }


}