
package animal.model.tailed.implementation;

import animal.model.tailed.AnimalWithTail;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode(callSuper = true)
public class Lion extends AnimalWithTail {
    public Lion(String name, String favouriteFood, int age, LocalDate arrivalDate, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, arrivalDate, weight, height, tailLength);
    }
}
