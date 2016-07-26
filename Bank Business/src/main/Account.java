package main;

/**
 * 1.2 Test Driven Development. (p.32)
 * Created by Jisung on 7/6/2016.
 */
public class Account {

  private int balance;

  public Account(int money) {
    assert money > 0 : "Account only can be created with money.";
    this.balance = money;
  }

  public int getBalance() {
    return this.balance;
  }

  public void deposit(int money) {
    this.balance += money;
  }

  public void withdrawal(int money) {
    assert balance >= money : "No sufficient money available.";
    this.balance -= money;
  }

  public double getAnnualInterest() {

    double iRate;
    if(balance <= 10000) {
      iRate = 0.015;
    } else if ( balance <= 100000) {
      iRate = 0.02;
    } else if ( balance <= 1000000) {
      iRate = 0.025;
    } else if ( balance <= 10000000) {
      iRate = 0.03;
    } else if ( balance <= 100000000) {
      iRate = 0.035;
    } else {
      iRate = 0.04;
    }
    return iRate * balance;
  }
}
