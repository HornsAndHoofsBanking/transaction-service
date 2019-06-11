package ru.alexandrov.transaction.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "operation")
@Accessors(chain = true)
public class Transfer {
    @Id
    @GenericGenerator(name = "keygen", strategy = "increment")
    @GeneratedValue(generator = "keygen")
    private long id;
    @Column(name = "from_acc_id")
    private long fromAccId;
    @Column(name = "to_acc_id")
    private long toAccId;
    @Column(name = "currency")
    private String currency;
    @Column(name = "amount")
    private int amount;
}
