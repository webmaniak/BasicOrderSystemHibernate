package ch.hearc.ig.ordersystem;

import ch.hearc.ig.ordersystem.business.*;
import ch.hearc.ig.ordersystem.persistence.jpa.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Get the user and create its profile
        User user = em.find(User.class, 1);
        Profile profile = new Profile();
        profile.setLanguage("FR");
        profile.setUser(user);
        profile.setReceivesNewsletter(false);
        em.persist(profile);

        // Create an article
        OrderItem orderItem = new OrderItem();
        orderItem.setCode("AJ654");
        orderItem.setName("Article super-spécial");
        orderItem.setPrice(10.4F);
        em.persist(orderItem);

        // Create an order
        Order order = new Order();
        order.setUser(user);
        order.setCost(10.4F);
        order.setReferenceNumber("AR724652");
        order.addOrderItem(orderItem);
        em.persist(order);

        // Create an employee with an Address
        Employee emp = new Employee();
        emp.setFirstName("Jane");
        emp.setLastName("Doe");
        emp.setAddress(new Address("Rue des Chênes", "8a"));
        em.persist(emp);

        // Commit (if at any point anything went wrong, everything will rollback)
        tx.commit();

        // Demonstrate how Hibernate's association mapping works
        Map<Integer, Order> orders = user.getOrders();
        for (Integer orderId : user.getOrders().keySet()) {
            System.out.println(orders.get(orderId).getReferenceNumber());
        }

        em.close();
    }
}