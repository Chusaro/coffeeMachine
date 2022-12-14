package fr.arolla;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

	private Drink drink;

	private int sugarNumber;

	private float money;

	public int getMoneyMissing() {
		return (int) ((drink.getPrice() - money) * 10);
	}

	public String getMoneyMissingMessage() {
		return "M:You miss %s cents to receive your drink !";
	}

	public boolean sugarAsked() {
		return getSugarNumber() > 0;
	}
}
