package com.itmo.movies.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createAndGet() throws Exception {
        mockMvc.perform(
                        post("/director")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"fio\":\"123\"}")
                )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/director")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("123")));
    }

    @Test
    void createAndUpdate() throws Exception {
        mockMvc.perform(
                        post("/director")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"fio\":\"123\",\"id\":\"2\"}")
                )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(
                        patch("/director/2")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"fio\":\"234\",\"id\":\"2\"}")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("234")));
    }

    @Test
    void createAndDelete() throws Exception {
        mockMvc.perform(
                        post("/director")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"fio\":\"123\",\"id\":\"1\"}")
                )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/director/1")).andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void failCreate() throws Exception {
        mockMvc.perform(
                        post("/director")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"id\":\"1\"}")
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}