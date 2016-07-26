package main;

import junit.framework.TestCase;

/**
 * .
 * Created by Jisung on 7/8/2016.
 */
public class Account2Test extends TestCase {

  // 1. Test Fixture
  private static final int INITIAL_MONEY = 10000;
  private static final int WITHDRAWAL_TEST = 5000;
  private static final int WITHDRAWAL_INSUFFICIENT_CASH_TEST = 100000000;

  private static final int DEPOSIT_TEST = 100000;

  private Account2 account2;

  // 2. Initialize Test Fixture using setUp() method
  @Override
  public void setUp() throws Exception {
    account2 = new Account2(INITIAL_MONEY);
  }

  // 3. compose unit test cases (or methods)
  // ** In junit3 unit test method must have the name start with 'test'.

  public void testGetBalance() throws Exception {
    assertEquals("", INITIAL_MONEY, account2.getBalance());
  }

  public void testWithdraw() throws Exception {
    account2.withdraw(WITHDRAWAL_TEST);
    assertEquals("", INITIAL_MONEY - WITHDRAWAL_TEST, account2.getBalance());
  }

  public void testWithdrawShortage() throws Exception {
    try {
      account2.withdraw(WITHDRAWAL_INSUFFICIENT_CASH_TEST);
      fail();
    } catch (AssertionError e) {
      assertTrue(true);
    }
  }

  public void testDeposit() throws Exception {
    account2.deposit(DEPOSIT_TEST);
    assertEquals("", INITIAL_MONEY + DEPOSIT_TEST, account2.getBalance());
  }

  // 4. Clean the Test Fixture using tearDown() method
}
