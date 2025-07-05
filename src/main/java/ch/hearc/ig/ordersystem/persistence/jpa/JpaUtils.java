package ch.hearc.ig.ordersystem.persistence.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtils {

    private static EntityManagerFactory emf;
    private static EntityManager em;


    public static EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("orderSystemJPA");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}
