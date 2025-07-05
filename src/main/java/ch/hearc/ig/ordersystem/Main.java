package ch.hearc.ig.ordersystem;

import ch.hearc.ig.ordersystem.business.Order;
import ch.hearc.ig.ordersystem.business.User;
import ch.hearc.ig.ordersystem.persistence.jpa.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        User user = em.find(User.class, 1);
//        Profile profile = new Profile();
//        profile.setLanguage("FR");
//        profile.setUser(user);
//        profile.setReceivesNewsletter(false);
//        em.persist(profile);
//
//        Order order = new Order();
//        order.setUser(user);
//        order.setCost(10.4F);
//        order.setReferenceNumber("AR724652");
//
//        OrderItem orderItem = new OrderItem();
//        orderItem.setCode("AJ654");
//        orderItem.setName("Article super-spécial");
//        orderItem.setPrice(10.4F);
//        order.addOrderItem(orderItem);
//
//        em.persist(order);
//        em.persist(orderItem);

        Map<Integer, Order> orders = user.getOrders();
        for (Integer orderId : user.getOrders().keySet()) {
            System.out.println(orders.get(orderId).getReferenceNumber());
        }

        tx.commit();
        em.close();
    }
}