package chapter02.exercise.service.user_service;

import chapter02.exercise.enums.Country;
import chapter02.exercise.model.User;

public interface UserService {

    User createUser(String firstName, String lastName, Country country);
}
