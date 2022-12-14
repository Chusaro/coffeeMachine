package fr.arolla;

import org.apache.commons.lang3.StringUtils;

public class CustomerOrdersTranslator {

	public static final String ZERO_STICK = "0";

	public static String renderOrder(final Order order) {
		if (notEnoughMoneyprovided(order)) {
			return String.format(order.getMoneyMissingMessage(), order.getMoneyMissing());
		}
		return String.format("%s%s:%s:%s", order.getDrink().getDrinkCode(), order.getExtraHotCode(), getSugarNumberString(order), getStickString(order));
	}

	private static boolean notEnoughMoneyprovided(final Order order) {
		return order.getMoney() < order.getDrink().getPrice();
	}

	private static String getSugarNumberString(final Order order) {
		return order.sugarAsked() ? String.valueOf(order.getSugarNumber()) : StringUtils.EMPTY;
	}


	private static String getStickString(final Order order) {
		return order.sugarAsked() ? ZERO_STICK : StringUtils.EMPTY;
	}
}
