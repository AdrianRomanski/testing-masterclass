package chapter02.exercise.service.id_generator;

import lombok.Setter;

@IdGeneratorType("incrementalIDGenerator")
public class IncrementIDGenerator implements IdGenerator {

    private static final String ID_FORMAT = "%010d";

    @Setter
    private long index;

    @Override
    public String getNext() {
        return String.format(ID_FORMAT, ++index);
    }
}
