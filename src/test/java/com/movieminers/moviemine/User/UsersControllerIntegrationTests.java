//package com.movieminers.moviemine.User;
//
//import com.movieminers.moviemine.user.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc(addFilters = false)
//@AutoConfigureTestDatabase
//
//
//class UsersControllerIntegrationTests {
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private UserRepository repository;
//
//    @Test
//    void testUsersPostCreatesNewUser() throws Exception {
//        mvc.perform(
//                        MockMvcRequestBuilders.post("/signup")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content("{\"username\":\"test\",\"password\":\"test\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.user.username").value("johnj"));
//        assertNotNull(repository.findByUsername("johnj"));
//    }
//
//    @Test
//    void testUsersPost() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.post("/signup"));
//        assertNotNull(repository.findAll());
//    }
//}
