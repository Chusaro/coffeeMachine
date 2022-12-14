package fr.arolla;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Drink {
	TEA("T"), COFFEE("C"), CHOCOLATE("H");

	private String drinkCode;


}
