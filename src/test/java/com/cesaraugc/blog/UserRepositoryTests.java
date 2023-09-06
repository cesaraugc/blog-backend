package com.cesaraugc.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.cesaraugc.blog.model.User;
import com.cesaraugc.blog.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("cesar2");
        user.setEmail("email@gmail.com");
        user.setPassword("12345");
        user.setFirstName("Usuario");
        user.setLastName("Test");
        userRepository.save(user);

        User existentUser = entityManager.find(User.class, user.getId());

        User userFindEmail = userRepository.findByEmail(user.getEmail()).get();

        assertEquals(user.getEmail(), existentUser.getEmail());
        assertEquals(user.getEmail(), userFindEmail.getEmail());
    }
}
