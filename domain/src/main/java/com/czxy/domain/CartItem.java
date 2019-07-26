package com.czxy.domain;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/22 20:22
 */
public class CartItem {
    private Product product;
    private Integer count;
    private Integer subMoney;

    public CartItem(Product product, Integer count, Integer subMoney) {
        this.product = product;
        this.count = count;
        this.subMoney = subMoney;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", count=" + count +
                ", subMoney=" + subMoney +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSubMoney() {
        subMoney = Integer.parseInt(product.getPrice())*count;
        return subMoney;
    }

    public void setSubMoney(Integer subMoney) {
        this.subMoney = subMoney;
    }

    public CartItem() {
    }
}
