package com.movieminers.moviemine.User;

import com.movieminers.moviemine.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void testConstructs() {
        User subject = new User( "firstName", "lastName", "username", "password");
        assertNull(subject.getId());
        assertEquals("username", subject.getUsername());
        assertEquals("password", subject.getPassword());
        assertEquals("firstName", subject.getFirstName());
        assertEquals("lastName", subject.getLastName());
        assertTrue(subject.isAccountNonExpired());
        assertTrue(subject.isAccountNonLocked());
        assertTrue(subject.isCredentialsNonExpired());
        assertTrue(subject.isEnabled());
    }

    @Test
    void testGetAuthorities() {
        User subject = new User( "firstName", "lastName", "username", "password");
        assertEquals(1, subject.getAuthorities().size());
        assertEquals("ROLE_USER", subject.getAuthorities().iterator().next().getAuthority());
    }
}
