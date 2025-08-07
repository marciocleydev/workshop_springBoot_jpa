package com.educandoweb.course.entities;

import com.educandoweb.course.entities.enums.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId     // no JPA é usada para definir uma chave primária composta (ou seja, uma @Id com múltiplos campos), usando uma classe embutida marcada com @Embeddable.
    private OrderItemPK id = new OrderItemPK(); // sempre que for criar um id composto tem que instânciar para não gerar nullPointException
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
        this.id.setOrder(order);
        this.id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //já tenho o getOrder na classe principal, entao @JsonIgnore serve para evitar que ele envie de novo a mesma informação e gere um código gigante.
    @JsonIgnore
    public Order getOrder() {// para o mundo exterior eu vou passar separado um produto e um order. E nao um tipo composto.
        return id.getOrder();
    }

    public void setOrder(Order order) {
        this.id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }
    public double getSubTotal(){
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
