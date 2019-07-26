package com.czxy.controller;

import com.czxy.domain.Cart;
import com.czxy.domain.CartItem;
import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/22 20:13
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() {
        try {
            List<Product> products = productService.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CartItem>> addCart(HttpServletRequest request, @PathVariable("id") Integer id) {

        Product product = productService.findById(id);

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart=new Cart();
        }


        cart.addCart(product,1);

        request.getSession().setAttribute("cart",cart);
        List<CartItem> cartItems = new ArrayList<>();
        Map<Integer, CartItem> map = cart.getMap();
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            cartItems.add(map.get(key));
        }
        return new ResponseEntity<>(cartItems,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<CartItem>> delete(HttpServletRequest request,@PathVariable("id") Integer id){


        Cart cart = (Cart) request.getSession().getAttribute("cart");

        cart.delete(id);

        request.getSession().setAttribute("cart",cart);

        List<CartItem> cartItems = new ArrayList<>();
        Map<Integer, CartItem> map = cart.getMap();
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            CartItem cartItem = map.get(integer);
            cartItems.add(cartItem);
        }

        return new ResponseEntity<>(cartItems,HttpStatus.OK);
    }
}
