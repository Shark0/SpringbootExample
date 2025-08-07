package org.shark.example.test.domain.user;

import org.junit.jupiter.api.Test;
import org.shark.example.domain.user.application.RegisterUserService;
import org.shark.example.domain.user.model.UserDto;
import org.shark.example.domain.user.model.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RegisterUserServiceTest {

    @Test
    void testRegisterSuccess() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.existsByEmail("test@example. ")).thenReturn(false);

        RegisterUserService service = new RegisterUserService(mockRepo);
        service.register("Alice", "test@example.com");

        verify(mockRepo, times(1)).save(any(UserDto.class));
    }

    @Test
    void testRegisterWithDuplicateEmail() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.existsByEmail("duplicate@example.com")).thenReturn(true);

        RegisterUserService service = new RegisterUserService(mockRepo);

        assertThrows(IllegalArgumentException.class, () ->
                service.register("Bob", "duplicate@example.com")
        );
    }
}
