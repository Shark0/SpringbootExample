package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shark.example.datasource.mysql.pojo.UserDo;
import org.shark.example.datasource.mysql.repository.UserRepository;
import org.shark.example.service.user.UserService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserDo user1Do;
    private UserDo user2Do;

    @BeforeEach
    void setUp() {
        user1Do = new UserDo();
        user1Do.setId(1L);
        user1Do.setName("John Doe");
        user1Do.setEmail("john@example.com");

        user2Do =  new UserDo();
        user2Do.setId(2L);
        user2Do.setName("Jane Doe");
        user2Do.setEmail("jane@example.com");
    }

    @Test
    void shouldReturnAllUsers() {
        List<UserDo> users = Arrays.asList(user1Do, user2Do);
        when(userRepository.findAll()).thenReturn(users);

        List<UserDo> result = userService.start().getData();

        // Assert
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

}
