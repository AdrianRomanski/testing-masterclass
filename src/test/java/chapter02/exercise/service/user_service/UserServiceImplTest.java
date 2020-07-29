package chapter02.exercise.service.user_service;

import chapter02.exercise.service.id_generator.IncrementIDGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static chapter02.exercise.enums.Country.POLAND;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    public static final String ID = "0000000001";
    public static final String FIRST_NAME = "Walter";
    public static final String LAST_NAME = "White";

    @Mock
    IncrementIDGenerator idGenerator;
    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Happy Path, method = createUser")
    void createUser() {
        //when
        when(idGenerator.getNext()).thenReturn(ID);
        //then
        var user = userService.createUser(FIRST_NAME, LAST_NAME, POLAND);

        assertThat(user.getId()).isEqualTo(ID);
        assertThat(user.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(user.getLastName()).isEqualTo(LAST_NAME);
        assertThat(user.getCountry()).isEqualTo(POLAND);
    }
}