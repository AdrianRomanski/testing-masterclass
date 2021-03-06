package chapter02.exercise.service.id_generator;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@IdGeneratorType("incrementalIDGenerator")
public class IncrementIDGenerator implements IdGenerator {

    private static final String ID_FORMAT = "%010d";

    @Setter
    private long index;

    @Override
    public String getNext() {
        log.info("ID: " + String.format(ID_FORMAT, index) + " Generated with IncrementalIdGenerator");
        return String.format(ID_FORMAT, ++index);
    }
}
