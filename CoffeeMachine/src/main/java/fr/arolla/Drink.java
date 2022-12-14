package fr.arolla;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Drink {
	TEA("T", 0.4f, "h"), COFFEE("C", 0.6f, "h"), CHOCOLATE("H", 0.5f, "h"), ORANGE_JUICE("O", 0.6f, "");

	private String drinkCode;

	private float price;

	private String extraHotCode;
}
