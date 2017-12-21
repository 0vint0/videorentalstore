package com.vsvet.example.videorentalstore.view;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.Instant;

public class ClientView {

    @ApiModelProperty(readOnly = true)
    private Long id;

    private String email;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private BigDecimal balance;

    @ApiModelProperty(readOnly = true)
    private Long bonusPoints;

    @ApiModelProperty(readOnly = true)
    private Instant createdDate;

    @ApiModelProperty(readOnly = true)
    private Instant modifiedDate;

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
