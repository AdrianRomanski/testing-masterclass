package chapter02.exercise.service.id_generator;

import java.util.UUID;

@IdGeneratorType("uuidGenerator")
public class UUIDGenerator implements IdGenerator{

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }
}
