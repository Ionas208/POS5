package at.kaindorf.intro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testHome() throws Exception{
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("homepage"))
                .andDo(print());
    }
}