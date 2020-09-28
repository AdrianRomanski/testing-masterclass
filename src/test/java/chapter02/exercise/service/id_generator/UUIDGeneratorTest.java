package chapter02.exercise.service.id_generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class UUIDGeneratorTest {

    private final Pattern uuidPattern = Pattern
            .compile("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");

    IdGenerator idGenerator;

    @BeforeEach
    void setUp() {
        idGenerator = new UUIDGenerator();
    }

    @Test
    @DisplayName("Should Return Next Id With Correct Pattern")
    void getNext() {
        //when
        var uuid1 = idGenerator.getNext();
        var uuid2 = idGenerator.getNext();
        //then
        assertThat(uuid1).isNotEqualTo(uuid2);
        assertThat(uuid1).containsPattern(uuidPattern);
        assertThat(uuid2).containsPattern(uuidPattern);
    }
}