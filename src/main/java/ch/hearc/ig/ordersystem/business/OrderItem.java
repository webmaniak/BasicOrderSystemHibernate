package ch.hearc.ig.ordersystem.business;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="ARTICLES")
public class OrderItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name="CODE", nullable = false)
    private String code;

    @Column(name="NOM", nullable = false)
    private String name;

    @Column(name="DESCRIPTION", nullable = true)
    private String description;

    @Column(name="PRIX", nullable = false)
    private float price;

    @ManyToMany(mappedBy = "orderItems")
    private Set<Order> orders;

    public OrderItem() {}

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
