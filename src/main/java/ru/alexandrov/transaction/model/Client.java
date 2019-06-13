package ru.alexandrov.transaction.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class Client {
    @Id
    @GenericGenerator(name = "keygen", strategy = "increment")
    @GeneratedValue(generator = "keygen")
    private long id;
    @Column(name = "type")
    private String type;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
}
