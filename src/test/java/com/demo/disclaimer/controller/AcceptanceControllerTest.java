package com.demo.disclaimer.controller;

import com.demo.disclaimer.model.api.Acceptance;
import com.demo.disclaimer.service.AcceptanceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AcceptanceControllerTest {

    @Mock
    private AcceptanceService acceptanceService;

    @InjectMocks
    private AcceptanceController acceptanceController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(acceptanceController).build();
    }

    @Test
    public void testCreateAcceptance() throws Exception {

        Acceptance acceptance = new Acceptance();
        acceptance.setId(1L);

        when(acceptanceService.createAcceptance(any(Acceptance.class))).thenReturn(acceptance);

        mockMvc.perform(post("/acceptances")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(acceptance)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));


        verify(acceptanceService, times(1)).createAcceptance(any(Acceptance.class));
    }

    @Test
    public void testGetAcceptancesByUserId() throws Exception {

        when(acceptanceService.listAcceptances(anyLong())).thenReturn(anyList());

        mockMvc.perform(get("/acceptances")
                .param("userId", String.valueOf(anyLong())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(anyList().size()));

        verify(acceptanceService, times(1)).listAcceptances(any());
    }
}
