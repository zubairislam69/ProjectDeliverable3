package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "111").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // test case when both operands are of the same length
    @Test
    public void logicalOR() throws Exception {
        this.mvc.perform(get("/logicalOR").param("operand1", "11111").param("operand2", "11010"))
                .andExpect(status().isOk())
                .andExpect(content().string("11111"));
    }

    @Test
    public void logicalOR2() throws Exception {
        this.mvc.perform(get("/logicalOR_json").param("operand1", "11111").param("operand2", "11010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalOR"));
    }

    // test case where one operand is 0
    @Test
    public void logicalOR3() throws Exception {
        this.mvc.perform(get("/logicalOR").param("operand1", "1010").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("1010"));
    }

    // test case where one operand is 0
    @Test
    public void logicalOR4() throws Exception {
        this.mvc.perform(get("/logicalOR_json").param("operand1", "1010").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalOR"));
    }

    // test case for when both operands are of the same value
    @Test
    public void logicalOR5() throws Exception {
        this.mvc.perform(get("/logicalOR").param("operand1", "11110").param("operand2", "11110"))
                .andExpect(status().isOk())
                .andExpect(content().string("11110"));
    }

    // test case for when both operands are of the same value
    @Test
    public void logicalOR6() throws Exception {
        this.mvc.perform(get("/logicalOR_json").param("operand1", "11110").param("operand2", "11110"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalOR"));
    }

    // test case for when operands are of different lengths
    @Test
    public void logicalOR7() throws Exception {
        this.mvc.perform(get("/logicalOR").param("operand1", "101101").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(content().string("101111"));
    }

    // test case for when operands are of different lengths
    @Test
    public void logicalOR8() throws Exception {
        this.mvc.perform(get("/logicalOR_json").param("operand1", "101101").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(101111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalOR"));
    }

    // test case for when both operands are 0
    @Test
    public void logicalOR9() throws Exception {
        this.mvc.perform(get("/logicalOR").param("operand1", "0000").param("operand2", "0000"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    // test case for when both operands are 0
    @Test
    public void logicalOR10() throws Exception {
        this.mvc.perform(get("/logicalOR_json").param("operand1", "0000").param("operand2", "0000"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalOR"));
    }

    // test case for when both operands are of the same length
    @Test
    public void logicalAND() throws Exception {
        this.mvc.perform(get("/logicalAND").param("operand1", "11111").param("operand2", "11010"))
                .andExpect(status().isOk())
                .andExpect(content().string("11010"));
    }

    @Test
    public void logicalAND2() throws Exception {
        this.mvc.perform(get("/logicalAND_json").param("operand1", "11111").param("operand2", "11010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalAND"));
    }

    // test case for when one operand is 0
    @Test
    public void logicalAND3() throws Exception {
        this.mvc.perform(get("/logicalAND").param("operand1", "11011").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    // test case for when one operand is 0
    @Test
    public void logicalAND4() throws Exception {
        this.mvc.perform(get("/logicalAND_json").param("operand1", "11011").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11011))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalAND"));
    }

    // test case for when both operands are of the same value
    @Test
    public void logicalAND5() throws Exception {
        this.mvc.perform(get("/logicalAND").param("operand1", "0111").param("operand2", "0111"))
                .andExpect(status().isOk())
                .andExpect(content().string("0111"));
    }

    // test case for when both operands are of the same value
    @Test
    public void logicalAND6() throws Exception {
        this.mvc.perform(get("/logicalAND_json").param("operand1", "0111").param("operand2", "0111"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalAND"));
    }

    // test case for when operands are of different lengths
    @Test
    public void logicalAND7() throws Exception {
        this.mvc.perform(get("/logicalAND").param("operand1", "10001").param("operand2", "0110111"))
                .andExpect(status().isOk())
                .andExpect(content().string("010001"));
    }

    // test case for when operands are of different lengths
    @Test
    public void logicalAND8() throws Exception {
        this.mvc.perform(get("/logicalAND_json").param("operand1", "10001").param("operand2", "0110111"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(10001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(110111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(010001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalAND"));
    }

    // test case for when both operands are 0
    @Test
    public void logicalAND9() throws Exception {
        this.mvc.perform(get("/logicalAND").param("operand1", "0000").param("operand2", "0000"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    // test case for when both operands are 0
    @Test
    public void logicalAND10() throws Exception {
        this.mvc.perform(get("/logicalAND_json").param("operand1", "0000").param("operand2", "0000"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("logicalAND"));
    }

    // test case for when both operands are of the same length
    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "11111").param("operand2", "11010"))
                .andExpect(status().isOk())
                .andExpect(content().string("1100100110"));
    }

    // test case for when both operands are of the same length
    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "11111").param("operand2", "11010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1100100110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // test case for when one operand is 0
    @Test
    public void multiply3() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "1110").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    // test case for when one operand is 0
    @Test
    public void multiply4() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "1110").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // test case for when both operands are of the same value
    @Test
    public void multiply5() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "0101").param("operand2", "0101"))
                .andExpect(status().isOk())
                .andExpect(content().string("11001"));
    }

    // test case for when both operands are of the same value
    @Test
    public void multiply6() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "0101").param("operand2", "0101"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // test case for when operands are of different lengths
    @Test
    public void multiply7() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "110011").param("operand2", "1100"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001100100"));
    }

    // test case for when operands are of different lengths
    @Test
    public void multiply8() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "110011").param("operand2", "1100"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(110011))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1100))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1001100100))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    // test case for when both operands are 0
    @Test
    public void multiply9() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "0000").param("operand2", "0000"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    // test case for when both operands are 0

    @Test
    public void multiply10() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "0000").param("operand2", "0000"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

}