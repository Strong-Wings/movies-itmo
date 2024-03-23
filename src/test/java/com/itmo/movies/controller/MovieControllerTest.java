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
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createAndGet() throws Exception {
        mockMvc.perform(
                        post("/movies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\": \"m1\"," +
                                        "    \"year\": 2024," +
                                        "    \"length\": \"02:00:00\"," +
                                        "    \"rating\": 7," +
                                        "    \"director\": {" +
                                        "        \"fio\": \"abc\"" +
                                        "    }" +
                                        "}")
                )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/movies")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2024")));
    }

    @Test
    void createAndUpdate() throws Exception {
        mockMvc.perform(
                        post("/movies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\": \"m1\"," +
                                        "    \"year\": 2024," +
                                        "    \"length\": \"02:00:00\"," +
                                        "    \"rating\": 7," +
                                        "    \"director\": {" +
                                        "        \"fio\": \"abc\"" +
                                        "    }" +
                                        "}")
                )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(
                        patch("/movies/2")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\": \"m1\"," +
                                        "    \"year\": 2025," +
                                        "    \"length\": \"02:00:00\"," +
                                        "    \"rating\": 7," +
                                        "    \"director\": {" +
                                        "        \"fio\": \"abc\"" +
                                        "    }" +
                                        "}")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2025")));
    }

    @Test
    void createAndDelete() throws Exception {
        mockMvc.perform(
                        post("/movies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\": \"m1\"," +
                                        "    \"year\": 2024," +
                                        "    \"length\": \"02:00:00\"," +
                                        "    \"rating\": 7," +
                                        "    \"director\": {" +
                                        "        \"fio\": \"abc\"" +
                                        "    }" +
                                        "}")
                )
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(delete("/movies/1")).andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void failCreate() throws Exception {
        mockMvc.perform(
                        post("/movies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\": \"m1\"," +
                                        "    \"year\": 2101," +
                                        "    \"length\": \"02:00:00\"," +
                                        "    \"rating\": 11," +
                                        "    \"director\": {" +
                                        "        \"fio\": \"abc\"" +
                                        "    }" +
                                        "}")
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}