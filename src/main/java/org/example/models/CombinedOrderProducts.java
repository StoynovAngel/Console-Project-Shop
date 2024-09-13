package org.example.models;

public class CombinedOrderProducts {
    private OrderProduct orderProduct;
    private Product product;

    public CombinedOrderProducts(OrderProduct orderProduct, Product product) {
        this.orderProduct = orderProduct;
        this.product = product;
    }

    @Override
    public String toString() {
        return "CombinedOrderProducts{" +
                "orderProduct=" + orderProduct +
                ", product=" + product +
                '}';
    }
}
