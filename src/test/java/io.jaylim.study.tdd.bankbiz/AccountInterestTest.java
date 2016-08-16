package io.jaylim.study.tdd.bankbiz;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Jisung on 7/9/2016.
 */

@RunWith(Parameterized.class)
public class AccountInterestTest {

  @Parameterized.Parameters
  public static Collection data() {
    return Arrays.asList(new Object[][] {
       /*Balance, Interest_rate,Interest*/
        {    10000, 0.015,     150.0   },
        {    10001, 0.02 ,     200.02  },
        {   100000, 0.02 ,    2000.0   },
        {   100001, 0.025,    2500.025 },
        {  1000000, 0.025,   25000.0   },
        {  1000001, 0.03 ,   30000.03  },
        { 10000000, 0.03 ,  300000.0   },
        { 10000001, 0.035,  350000.035 },
        {100000000, 0.035, 3500000.0   },
        {100000001, 0.04 , 4000000.04  }
    });
  }

  private int balance;
  private double interestRate;
  private double interest;

  public AccountInterestTest(int balance, double interestRate, double interest) {
    this.balance = balance;
    this.interestRate = interestRate;
    this.interest = interest;

  }

  @Test
  public void testGetAnnualInterest() throws Exception {
    Account account = new Account(balance);
    assertEquals(this.interest, account.getAnnualInterest(), 0.01);
  }
}
