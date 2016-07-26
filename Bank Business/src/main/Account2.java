package main;

/**
 * Use JUnit 3. Created by Jisung on 7/8/2016.
 */
public class Account2 {
  private int balance;

  public Account2(int money) {
    this.balance = money;
  }

  public int getBalance() {
    return this.balance;
  }

  public void withdraw(int money) {
    assert balance >= money : "Insufficient cash available";
    balance -= money;
  }

  public void deposit(int money) {
    balance += money;
  }
}
