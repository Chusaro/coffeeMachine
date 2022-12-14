package fr.arolla;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CustomerOrdersTranslatorTest {

	private static Order order;

	@BeforeAll
	static void init() {
		order = new Order(Drink.CHOCOLATE, 0, 0, false);

	}

	@Test
	void should_return_correctInstruction_for_drink_order() {
		order.setDrink(Drink.CHOCOLATE);
		order.setSugarNumber(0);
		order.setMoney(Drink.CHOCOLATE.getPrice());
		String drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("H::");

		order.setDrink(Drink.COFFEE);
		order.setMoney(Drink.COFFEE.getPrice());
		drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("C::");

		order.setDrink(Drink.TEA);
		order.setMoney(Drink.TEA.getPrice());
		drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("T::");

		order.setDrink(Drink.ORANGE_JUICE);
		order.setMoney(Drink.ORANGE_JUICE.getPrice());
		drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("O::");
	}

	@Test
	void should_return_number_of_sugars() {
		order.setDrink(Drink.COFFEE);
		order.setMoney(Drink.COFFEE.getPrice());
		order.setSugarNumber(2);

		String drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("C:2:0");
	}

	@Test
	void should_make_drink_only_if_enough_money() {
		order.setDrink(Drink.CHOCOLATE);
		order.setSugarNumber(0);
		order.setMoney(0.2f);
		String drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isNotEqualTo("H::");
	}

	@Test
	void should_return_message_if_not_enough_money() {
		order.setDrink(Drink.CHOCOLATE);
		order.setSugarNumber(0);
		order.setMoney(0.2f);
		String drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("M:You miss 3 cents to receive your drink !");
	}

	@Test
	void should_return_extra_hot_drink() {
		order.setDrink(Drink.CHOCOLATE);
		order.setSugarNumber(0);
		order.setMoney(Drink.CHOCOLATE.getPrice());
		order.setExtraHot(true);

		String drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("Hh::");

		order.setDrink(Drink.COFFEE);
		order.setMoney(Drink.COFFEE.getPrice());
		drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("Ch::");

		order.setDrink(Drink.TEA);
		order.setMoney(Drink.TEA.getPrice());
		drinkMakerInstruction = CustomerOrdersTranslator.renderOrder(order);
		Assertions.assertThat(drinkMakerInstruction).isEqualTo("Th::");
	}
}
