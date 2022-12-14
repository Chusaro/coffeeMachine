package fr.arolla;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Drink {
	TEA("T", 0.4f), COFFEE("C", 0.6f), CHOCOLATE("H", 0.5f);

	private String drinkCode;

	private float price;
}
