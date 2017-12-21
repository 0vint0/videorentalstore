package com.vsvet.example.videorentalstore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * This entry represents the client(customer) database
 */
@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This almost will be client user identification
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    /**
     * This almost will represent client's wallet.
     * For simplicity will not create separate entry to hold it.
     * <p>
     * In this application simulation the balance can go under ZERO,
     * it will means that client owes to store some money, it can happens when
     * client returns movie later.
     */
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "bonus_points")
    private Long bonusPoints;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(Long bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getEmail(), client.getEmail()) &&
                Objects.equals(getPhoneNumber(), client.getPhoneNumber()) &&
                Objects.equals(getFirstName(), client.getFirstName()) &&
                Objects.equals(getLastName(), client.getLastName()) &&
                Objects.equals(getBalance(), client.getBalance()) &&
                Objects.equals(getBonusPoints(), client.getBonusPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPhoneNumber(), getFirstName(), getLastName(), getBalance(), getBonusPoints());
    }
}
