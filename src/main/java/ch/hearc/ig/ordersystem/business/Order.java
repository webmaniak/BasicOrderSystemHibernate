package ch.hearc.ig.ordersystem.business;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="COMMANDES")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="NO_REFERENCE", nullable = false)
    private String referenceNumber;

    @Column(name="CALC_COUT", nullable = true)
    private float cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="UTILISATEUR_ID", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name="COMMANDES_ARTICLES",
            joinColumns = @JoinColumn(name="COMMANDE_ID"),
            inverseJoinColumns = @JoinColumn(name="ARTICLE_ID"))
    private Set<OrderItem> orderItems;

    public int getId() {
        return id;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new HashSet<OrderItem>();
        }
        orderItems.add(orderItem);
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
