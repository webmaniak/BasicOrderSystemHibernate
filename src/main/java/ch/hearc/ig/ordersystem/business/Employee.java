package ch.hearc.ig.ordersystem.business;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYES")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="NOM")
    private String lastName;

    @Column(name="PRENOM")
    private String firstName;

    @Embedded
    private Address address;

    public Employee() {}

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
