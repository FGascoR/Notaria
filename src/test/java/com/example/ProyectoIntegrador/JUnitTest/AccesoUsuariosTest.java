package com.example.ProyectoIntegrador.JUnitTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class AccesoUsuariosTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginExitosoRedireccionaASistemaNotario() throws Exception {
        mockMvc.perform(formLogin("/Login")
                        .user("luisb")
                        .password("1234"))
                .andExpect(status().isFound()) // Espera código 302
                .andExpect(redirectedUrl("/SistemaNotario"));
    }

    @Test
    void testLoginFallidoRedireccionaError() throws Exception {
        mockMvc.perform(formLogin("/Login")
                        .user("usuarioNoExiste")
                        .password("claveErronea"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/Login?error=true"));
    }

    @Test
    void testAccesoProtegidoSinLogin() throws Exception {
        mockMvc.perform(get("/SistemaNotario"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("http://localhost/Login"));
    }
}