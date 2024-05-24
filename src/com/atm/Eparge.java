package com.atm;

public class Eparge extends Account {

	Eparge(String id, double money, String t) {
		super(id, money);
		super.setType(t);
	}
	public int	retireMoney(double money) {
		if (this.getSolde() >= money) {
			this.setSolde(this.getSolde() - money);
			return 1;
		}
		return 0;
	}
	public int	transferMoney(Account acc, double money) {
		if (this.retireMoney(money) != 0) {
			acc.deposeMoney(money);
			return 1;
		}
		return 0;
	}
}
