package ru.sstu.ushankashop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sstu.ushankashop.dto.Cart;
import ru.sstu.ushankashop.service.CartService;

/**
 * @author Dmitry Tarasov
 * Date: 11/06/2017
 * Time: 15:12
 */
@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cart addItemToCart(@RequestParam("itemId") Long itemId, @RequestParam("quantity") Integer quantity) {
        return cartService.addItemToCart(itemId, quantity);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Cart removeItemFromCart(@RequestParam("itemId") Long itemId) {
        return cartService.removeItemFromCart(itemId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Cart getCart() {
        return cartService.getCart();
    }
}
