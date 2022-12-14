package fr.arolla;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerOrdersTranslatorTest {

	private static Order order;

	@BeforeAll
	static void init() {
		order = new Order();
	}

	@Test
	void should_return_correctInstruction_for_drink_order() {
		order.setDrink(Drink.CHOCOLATE);
		order.setSugarNumber(0);
		String drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("H::");

		order.setDrink(Drink.COFFEE);
		drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("C::");

		order.setDrink(Drink.TEA);
		drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("T::");
	}

	@Test
	void should_return_number_of_sugars() {
		order.setDrink(Drink.COFFEE);
		order.setSugarNumber(2);
		String drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("C:2:0");
	}
}
