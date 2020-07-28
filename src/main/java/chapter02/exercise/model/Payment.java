package chapter02.exercise.model;

import lombok.*;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private UUID id;
    private User user;
    private List<Product> products;
    private Double tax;
}
