package ru.alexandrov.transaction.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GenericGenerator(name = "keygen", strategy = "increment")
    @GeneratedValue(generator = "keygen")
    private long id;
    @Column(name="acc_id")
    private long accId;
    @Column(name="currency")
    private String currency;
    @Column(name = "amount")
    private int amount;
}
