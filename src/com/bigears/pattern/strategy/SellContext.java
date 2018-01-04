package com.bigears.pattern.strategy;

/**
 * Seller
 *
 * @author shenyang
 */
public class SellContext {

    private SaleStrategy saleStrategy;

    public SellContext(SaleStrategy saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public double discount(){
        return saleStrategy.calculate();
    }

    public static void main(String[] args) {
        SaleStrategy saleStrategy = new HalfDiscountSaleStratey(3,1);
        SellContext seller = new SellContext(saleStrategy);
        System.out.println(seller.discount());
    }

}
