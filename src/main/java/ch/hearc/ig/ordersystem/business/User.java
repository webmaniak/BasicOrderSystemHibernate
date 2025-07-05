package ch.hearc.ig.ordersystem.business;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="UTILISATEURS")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="USERNAME")
    private String username;

    @Column(name="NOM")
    private String lastname;

    @Column(name="PRENOM")
    private String firstname;

    @Column(name="EMAIL")
    private String email;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @OneToMany(mappedBy = "user")
    @MapKey(name="id")
    private Map<Integer, Order> orders;

    public void addOrder(Order order) {
        if (orders == null)
            orders = new HashMap<Integer, Order>();

        orders.put(order.getId(), order);
        order.setUser(this); // important !
    }

    public User() { }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }
}



//EntityManager em = ...;
//User you = em.find(User.class, 1); // charge l'utilisateur
//for(Order order : you.getOrders()) { // charge les commandes
//    System.out.println(order.getId());
//}

//public class User {
//    // ...
//    public Set<Order> getOrders() {
//        if (this.orders == null) {
//            this.orders = Order.findForUser(this.getId());
//        }
//        return this.orders;
//    }
//    // ...
//}

