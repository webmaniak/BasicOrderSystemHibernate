package ch.hearc.ig.ordersystem.business;

import jakarta.persistence.*;

@Entity
@Table(name="PROFILS")
public class Profile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="INSCRIT_NEWSLETTER")
    private boolean receivesNewsletter;
    @Column(name="LANGUE")
    private String language;

    @OneToOne
    @JoinColumn(name="UTILISATEUR_ID")
    private User user;

    public Profile() { }

    public int getId() {
        return id;
    }

    public boolean isReceivesNewsletter() {
        return receivesNewsletter;
    }

    public void setReceivesNewsletter(boolean receivesNewsletter) {
        this.receivesNewsletter = receivesNewsletter;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
