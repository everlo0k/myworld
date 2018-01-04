package com.bigears.pattern.strategy;

/**
 * NoDiscountSaleStratey
 *
 * @author shenyang
 */
public class NoDiscountSaleStratey implements SaleStrategy{

    @Override
    public double calculate() {
        return 0;
    }
}
