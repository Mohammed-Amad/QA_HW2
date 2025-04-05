package main.najah.test;

import main.najah.code.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("User Service Simple Tests")
public class UserServiceSimpleTest {

    UserService service;

    @BeforeEach
    void setup() {
        service = new UserService();
    }

    @Test
    @DisplayName("Valid Email Check")
    void validEmail() {
        assertTrue(service.isValidEmail("test@example.com"));
    }

    @Test
    @DisplayName("Invalid Email Check")
    void invalidEmail() {
        assertFalse(service.isValidEmail("testexample"));
    }

    @Test
    @DisplayName("Authentication Success")
    void testAuthSuccess() {
        assertTrue(service.authenticate("admin", "1234"));
    }

    @Test
    @DisplayName("Authentication Failure")
    void testAuthFail() {
        assertFalse(service.authenticate("admin", "wrong"));
    }
}