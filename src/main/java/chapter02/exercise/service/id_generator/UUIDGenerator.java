package chapter02.exercise.service.id_generator;

import lombok.extern.java.Log;

import java.util.UUID;

@Log
@IdGeneratorType("uuidGenerator")
public class UUIDGenerator implements IdGenerator{

    @Override
    public String getNext() {
        UUID id = UUID.randomUUID();
        log.info("ID: " + id + " Generated with UUIDGenerator");
        return id.toString();
    }
}
