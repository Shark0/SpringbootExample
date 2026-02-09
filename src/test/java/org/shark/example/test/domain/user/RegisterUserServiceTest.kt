package org.shark.example.test.domain.user

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.shark.example.domain.user.application.RegisterUserService
import org.shark.example.domain.user.model.UserDto
import org.shark.example.domain.user.model.UserRepository

class RegisterUserServiceTest {

    @Test
    fun testRegisterSuccess() {
        val mockRepo = mock(UserRepository::class.java)
        `when`(mockRepo.existsByEmail("test@example. ")).thenReturn(false)

        val service = RegisterUserService(mockRepo)
        service.register("Alice", "test@example.com")

        verify(mockRepo, times(1)).save(any(UserDto::class.java))
    }

    @Test
    fun testRegisterWithDuplicateEmail() {
        val mockRepo = mock(UserRepository::class.java)
        `when`(mockRepo.existsByEmail("duplicate@example.com")).thenReturn(true)

        val service = RegisterUserService(mockRepo)

        assertThrows(IllegalArgumentException::class.java) {
            service.register("Bob", "duplicate@example.com")
        }
    }
}
