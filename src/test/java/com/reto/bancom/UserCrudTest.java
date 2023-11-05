package com.reto.bancom;

import com.reto.bancom.infrastructure.persistence.entity.UserEntity;
import com.reto.bancom.infrastructure.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserCrudTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserTest() {
        UserEntity user = new UserEntity();
        user.setCellPhone("1234567890");
        user.setName("Test");
        user.setLastName("User");
        user.setPassword("password");

        // Save the user
        UserEntity savedUser = userRepository.save(user);

        // Retrieve the user
        Optional<UserEntity> foundUser = userRepository.findById(savedUser.getUserId());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getCellPhone()).isEqualTo(user.getCellPhone());
        assertThat(foundUser.get().getName()).isEqualTo(user.getName());
        assertThat(foundUser.get().getLastName()).isEqualTo(user.getLastName());
    }
}
