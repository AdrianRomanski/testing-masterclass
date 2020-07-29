package chapter02.exercise.service.id_generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;


class IncrementIDGeneratorTest {

    IdGenerator idGenerator;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        idGenerator = new IncrementIDGenerator();
    }


    @Test
    @DisplayName("Get Next - IncrementalIDGenerator")
    void getNext() {
        //when
        var returnID = idGenerator.getNext();
        var returnID2 = idGenerator.getNext();
        var returnID3 = idGenerator.getNext();

        //then
        assertThat(returnID).isEqualTo("0000000001");
        assertThat(returnID2).isEqualTo("0000000002");
        assertThat(returnID3).isEqualTo("0000000003");
    }
}