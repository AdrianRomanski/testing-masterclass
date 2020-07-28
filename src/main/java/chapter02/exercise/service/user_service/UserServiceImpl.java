package chapter02.exercise.service.user_service;

import chapter02.exercise.enums.Country;
import chapter02.exercise.model.User;
import chapter02.exercise.service.id_generator.IdGenerator;
import chapter02.exercise.service.id_generator.IdGeneratorType;

public class UserServiceImpl implements UserService {

    private final IdGenerator idGenerator;

    public UserServiceImpl(@IdGeneratorType("incrementalIDGenerator") IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public User createUser(String firstName, String lastName, Country country) {
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .country(country)
                .id(idGenerator.getNext()).build();
    }
}
