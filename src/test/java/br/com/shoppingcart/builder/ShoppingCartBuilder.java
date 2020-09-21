package br.com.shoppingcart.builder;

import br.com.shoppingcart.model.CartItem;
import br.com.shoppingcart.model.Product;
import br.com.shoppingcart.model.ShoppingCart;
import br.com.shoppingcart.model.User;

import java.util.Arrays;

public class ShoppingCartBuilder {

    private ShoppingCart shoppingCart;

    public ShoppingCartBuilder() {
    }

    public static ShoppingCartBuilder shoppingCartWithAmountLessThan100() {
        ShoppingCartBuilder shoppingCartBuilder = returnShoppingCartWithAmountLessThan100();
        return shoppingCartBuilder;
    }

    public static ShoppingCartBuilder shoppingCartWithAmountMoreThan100() {
        ShoppingCartBuilder shoppingCartBuilder = returnShoppingCartWithAmountMoreThan100();
        return shoppingCartBuilder;
    }

    public static ShoppingCartBuilder returnShoppingCartWithAmountLessThan100() {
        ShoppingCartBuilder shoppingCartBuilder = new ShoppingCartBuilder();

        User user = new User(1L, "Rebeca", "87302-899");

        Product p1 = Product.builder().id(1L).name("Caneta").price(5.5).build();
        Product p2 = Product.builder().id(2L).name("Lápis").price(3).build();
        Product p3 = Product.builder().id(3L).name("Borracha").price(0.75).build();

        CartItem c1 = CartItem.builder().product(p1).amount(11).build();
        CartItem c2 = CartItem.builder().product(p2).amount(3).build();
        CartItem c3 = CartItem.builder().product(p3).amount(2.25).build();

        shoppingCartBuilder.shoppingCart = new ShoppingCart();
        shoppingCartBuilder.shoppingCart.setId(1L);
        shoppingCartBuilder.shoppingCart.setItems(Arrays.asList(c1, c2, c3));
        shoppingCartBuilder.shoppingCart.setUser(user);

        return shoppingCartBuilder;
    }

    private static ShoppingCartBuilder returnShoppingCartWithAmountMoreThan100() {
        ShoppingCartBuilder shoppingCartBuilder = new ShoppingCartBuilder();

        User user = new User(1L, "Rebeca", "87302-899");

        Product p1 = Product.builder().id(1L).name("Base cooler para notebook C3").price(65.7).build();
        Product p2 = Product.builder().id(2L).name("Monitor AOC Gamer Sniper").price(998).build();
        Product p3 = Product.builder().id(3L).name("Headset Logitech G332").price(370).build();

        CartItem c1 = CartItem.builder().product(p1).amount(65.7).build();
        CartItem c2 = CartItem.builder().product(p2).amount(998).build();
        CartItem c3 = CartItem.builder().product(p3).amount(370).build();

        shoppingCartBuilder.shoppingCart = new ShoppingCart();
        shoppingCartBuilder.shoppingCart.setId(2L);
        shoppingCartBuilder.shoppingCart.setItems(Arrays.asList(c1, c2, c3));
        shoppingCartBuilder.shoppingCart.setUser(user);

        return shoppingCartBuilder;
    }

    public ShoppingCart now() {
        return shoppingCart;
    }
}
