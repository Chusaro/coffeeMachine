package fr.arolla;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

@Getter
@Setter
@AllArgsConstructor
public class Order {

	private Drink drink;

	private int sugarNumber;

	private float money;

	private boolean extraHot;


	public int getMoneyMissing() {
		return (int) ((drink.getPrice() - money) * 10);
	}

	public String getMoneyMissingMessage() {
		return "M:You miss %s cents to receive your drink !";
	}

	public boolean sugarAsked() {
		return getSugarNumber() > 0;
	}

	public String getExtraHotCode() {
		if (isExtraHot()) {
			return drink.getExtraHotCode();
		}
		return "";
	}

}
