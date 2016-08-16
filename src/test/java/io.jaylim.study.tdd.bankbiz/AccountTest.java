package io.jaylim.study.tdd.bankbiz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * Test module for Account.java
 * Created by Jisung on 7/6/2016.
 */
public class AccountTest {
  private Account account;

  private static final int INITIAL_MONEY = 10000;
  private static final int MINIMUM_INITIAL_MONEY = 1;
  private static final int INITIAL_MONEY_ZERO_BALANCE = 0;
  private static final int INITIAL_MONEY_MINUS_BALANCE = -50;

  private static final int LARGE_AMOUNT_OF_MONEY = 1000000000;

  private static final int WITHDRAWAL_TEST = 5000;
  private static final int WITHDRAWAL_INSUFFICIENT_CASH_TEST = 100000000;

  private static final int DEPOSIT_TEST = 100000;

  @Before
  public void setUp() {
    account = new Account(INITIAL_MONEY);
  }

  @Test
  public void testAccount() throws Exception {
    account = new Account(MINIMUM_INITIAL_MONEY);
  }

  @Test(expected = AssertionError.class)
  public void testAccountZeroBalance() throws Exception {
    account = new Account(INITIAL_MONEY_ZERO_BALANCE);
  }

  @Test(expected = AssertionError.class)
  public void testAccountMinusBalance() throws Exception {
    account = new Account(INITIAL_MONEY_MINUS_BALANCE);
  }

  @Test
  public void testGetBalance() throws Exception {
    assertEquals("Create Account with 10000 WON, and then check balance.",
        INITIAL_MONEY, account.getBalance());

    account = new Account(LARGE_AMOUNT_OF_MONEY);
    assertEquals("Create Account with 1000 WON, and then check balance.",
        LARGE_AMOUNT_OF_MONEY, account.getBalance());
  }

  @Test
  public void testDeposit() throws Exception {
    account.deposit(DEPOSIT_TEST);
    assertEquals("Create Account with 0 WON, Deposit 1000 WON, and then check balance.",
        INITIAL_MONEY + DEPOSIT_TEST, account.getBalance());
  }

  @Test
  public void testWithdrawal() throws Exception {
    account.withdrawal(WITHDRAWAL_TEST);
    assertEquals("Create Account with 0 WON, Withdrawal 1000 WON, and then check balance.",
        INITIAL_MONEY - WITHDRAWAL_TEST, account.getBalance());
  }

  @Test(expected = AssertionError.class)
  public void testWithdrawalShortage() throws Exception {
    account.withdrawal(WITHDRAWAL_INSUFFICIENT_CASH_TEST);
  }

}
