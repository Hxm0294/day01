package com.czxy.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/22 20:22
 */
public class Cart {
    private Map<Integer,CartItem> map  = new HashMap<>();
    private Integer totalMoney;


    public void addCart(Product product,Integer count ){
        CartItem cartItem = map.get(product.getId());

        if (cartItem == null){
            cartItem = new CartItem(product,count,count*Integer.parseInt(product.getPrice()));
            map.put(product.getId(),cartItem);
        }else {
            cartItem.setCount(cartItem.getCount()+1);
        }

    }

    public void delete(Integer id){
        CartItem cartItem = map.get(id);

        Integer count = cartItem.getCount();

        if(count == 1){
            map.remove(id);
        }else {
            cartItem.setCount(count-1);

        }

    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                ", totalMoney=" + totalMoney +
                '}';
    }

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        //清零
        totalMoney = 0;

        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            CartItem cartItem = map.get(key);
            totalMoney += cartItem.getSubMoney();
        }

        this.totalMoney = totalMoney;
    }

    public Cart(Map<Integer, CartItem> map, Integer totalMoney) {
        this.map = map;
        this.totalMoney = totalMoney;
    }

    public Cart() {
    }
}
