package chapter02.exercise.model;

import chapter02.exercise.enums.Country;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Country country;
    private List<Payment> payments;

    @Builder
    public User(String id, String firstName, String lastName, Country country, List<Payment> payments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.payments = Objects.requireNonNullElseGet(payments, ArrayList::new);
    }
}
