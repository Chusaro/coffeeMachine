package fr.arolla;

import org.apache.commons.lang3.StringUtils;

public class CustomerOrdersTranslator {

	public static final String ZERO_STICK = "0";

	public static String renderOrder(final Order order) {
		return String.format("%s:%s:%s", order.getDrink().getDrinkCode(), getSugarNumberString(order), getStickString(order));
	}

	private static String getSugarNumberString(final Order order) {
		return order.getSugarNumber() > 0 ? String.valueOf(order.getSugarNumber()) : StringUtils.EMPTY;
	}

	private static String getStickString(final Order order) {
		return order.getSugarNumber() > 0 ? ZERO_STICK : StringUtils.EMPTY;
	}
}
