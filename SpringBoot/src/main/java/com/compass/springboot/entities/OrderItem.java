package com.compass.springboot.entities;

import com.compass.springboot.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem() {}
    public OrderItem(Order order, Product product, Integer quantity, Double price) {

        id.setOrder(order);
        id.setProduct(product);

        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {return id.getOrder();}
    public Product getProduct() {return id.getProduct();}
    public Integer getQuantity() {return quantity;}
    public Double getPrice() {return price;}

    public void setOrder(Order order) {id.setOrder(order);}
    public void setProduct(Product product) {id.setProduct(product);}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
    public void setPrice(Double price) {this.price = price;}

    public Double getSubTotal() {return price * quantity;}

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(id);
    }
}
