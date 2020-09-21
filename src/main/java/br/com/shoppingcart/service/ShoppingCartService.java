package br.com.shoppingcart.service;

import br.com.shoppingcart.model.CartItem;
import br.com.shoppingcart.model.ShoppingCart;

public class ShoppingCartService {

    private static TransportService transportService = new TransportService();

    public static double calcTotalValue(ShoppingCart shoppingCart) {
        double totalValue = shoppingCart.getItems().stream().mapToDouble(item -> item.getAmount()).sum();

        if (totalValue < 100) {
            totalValue += transportService.calcFreight(shoppingCart.getUser().getZipCode());
        }

        return totalValue;
    }

    public static void addItem(ShoppingCart shoppingCart, CartItem cartItem) {
        if (cartItem != null) {
            if (!verifyCartItemExists(shoppingCart, cartItem))
                shoppingCart.getItems().add(cartItem);
        }
    }

    public static boolean verifyCartItemExists(ShoppingCart shoppingCart, CartItem cartItem) {
        return shoppingCart.getItems().stream().anyMatch(o -> o.getProduct().getName().equals(cartItem.getProduct().getName()));
    }

}
