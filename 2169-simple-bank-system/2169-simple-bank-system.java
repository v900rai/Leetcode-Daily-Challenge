public class Bank {
  public Bank(long[] balance) {
    this.balance = balance;
  }

  public boolean transfer(int account1, int account2, long money) {
    if (!isValid(account2))
      return false;
    return withdraw(account1, money) && deposit(account2, money);
  }

  public boolean deposit(int account, long money) {
    if (!isValid(account))
      return false;
    balance[account - 1] += money;
    return true;
  }

  public boolean withdraw(int account, long money) {
    if (!isValid(account))
      return false;
    if (balance[account - 1] < money)
      return false;
    balance[account - 1] -= money;
    return true;
  }

  private long[] balance;

  private boolean isValid(int account) {
    return 1 <= account && account <= balance.length;
  }
}
/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */