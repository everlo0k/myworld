package com.bigears.pattern.strategy;

/**
 * HalfDiscountSaleStratey
 *
 * @author shenyang
 */
public class HalfDiscountSaleStratey implements SaleStrategy {

    private double price;

    private int num;

    public HalfDiscountSaleStratey(double price, int num) {
        this.price = price;
        this.num = num;
    }

    @Override
    public double calculate() {
        return price * num / 2;
    }
}
