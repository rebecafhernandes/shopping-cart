package br.com.shoppingcart.services;

import br.com.shoppingcart.model.CartItem;
import br.com.shoppingcart.model.Product;
import br.com.shoppingcart.model.ShoppingCart;
import br.com.shoppingcart.service.ShoppingCartService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static br.com.shoppingcart.builder.ShoppingCartBuilder.shoppingCartWithAmountLessThan100;
import static br.com.shoppingcart.builder.ShoppingCartBuilder.shoppingCartWithAmountMoreThan100;

public class ShoppingCartServiceTest {
    @Mock
    private ShoppingCartService shoppingCartService;

    ShoppingCart shoppingCart;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        shoppingCart = Mockito.mock(ShoppingCart.class);
    }

    @Test
    public void testShoppingCartBuilder() {
        shoppingCart = shoppingCartWithAmountLessThan100().now();
        Assert.assertNotNull(shoppingCart);
    }

    @Test
    public void testCalcTotalValueShoppingCart() {
        shoppingCart = shoppingCartWithAmountLessThan100().now();
        Assert.assertNotNull(shoppingCart);

        double totalValue = shoppingCartService.calcTotalValue(shoppingCart);
        Assert.assertEquals(66.25, totalValue, 0.01);
    }

    @Test
    public void testCalcTotalValueShoppingCartWithoutFreight() {
        shoppingCart = shoppingCartWithAmountMoreThan100().now();
        Assert.assertNotNull(shoppingCart);

        double totalValue = shoppingCartService.calcTotalValue(shoppingCart);
        Assert.assertEquals(1433.7, totalValue, 0.01);
    }

    @Test
    public void testIfCartItemExists() {
        //Tenta adicionar um produto que já existe no carrinho
        shoppingCart = shoppingCartWithAmountMoreThan100().now();

        CartItem cartItem = new CartItem(new Product(1L, "Base cooler para notebook C3", 65.7), 65.7);

        Assert.assertTrue(shoppingCartService.verifyCartItemExists(shoppingCart, cartItem));
    }

    @Test
    public void testIfCartItemNotExists() {
        //Tenta adicionar um produto que já existe no carrinho
        shoppingCart = shoppingCartWithAmountLessThan100().now();

        CartItem cartItem = new CartItem(new Product(1L, "Base cooler para notebook C3", 65.7), 65.7);

        Assert.assertFalse(shoppingCartService.verifyCartItemExists(shoppingCart, cartItem));
    }
}
