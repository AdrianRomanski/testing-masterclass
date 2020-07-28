package chapter02.exercise.model;

import lombok.*;

import javax.persistence.Id;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private UUID id;
    private String name;
    private Double priceWithoutTax;

}
