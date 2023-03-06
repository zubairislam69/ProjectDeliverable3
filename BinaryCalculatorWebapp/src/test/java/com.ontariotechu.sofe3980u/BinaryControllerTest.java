package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    // Design 1: Add three more test cases for the binary web application.

    /*
    @Test
    public void missingOperator() throws Exception {
        this.mvc.perform(post("/").param("operand1", "10100").param("operator", "").param("operand2", "11111"))
                .andExpect(status().isOk())
                .andExpect(view().name("Error"))
                .andExpect(model().attributeDoesNotExist("result"))
                .andExpect(model().attribute("operand1", "10100"));
    }

    @Test
    public void noParameters() throws Exception {
        this.mvc.perform(post("/").param("operand1", "").param("operator", "").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("Error"))
                .andExpect(model().attributeDoesNotExist("result"))
                .andExpect(model().attribute("operand1", ""));
    }
    */
    
    @Test
    public void missingOperands() throws Exception {
        this.mvc.perform(post("/").param("operand1", "").param("operator", "+").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeDoesNotExist("Error"))
                .andExpect(model().attribute("operand1", ""));
    }

    // Test cases for newly implemented operations

    // test case when both operands are of the same length
    @Test
    public void logicalOR() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1011").param("operator", "|").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111"))
                .andExpect(model().attribute("operand1", "1011"));
    }

    // test case where one operand is 0
    @Test
    public void logicalOR2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1100").param("operator", "|").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1100"))
                .andExpect(model().attribute("operand1", "1100"));
    }

    // test case for when both operands are of the same value
    @Test
    public void logicalOR3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "10001").param("operator", "|").param("operand2", "10001"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10001"))
                .andExpect(model().attribute("operand1", "10001"));
    }

    // test case for when operands are of different lengths
    @Test
    public void logicalOR4() throws Exception {
        this.mvc.perform(post("/").param("operand1", "101").param("operator", "|").param("operand2", "01101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "101"));
    }

    // test case for when both operands are 0
    @Test
    public void logicalOR5() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "|").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    // test case when both operands are of the same length
    @Test
    public void logicalAND() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "&").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "101"))
                .andExpect(model().attribute("operand1", "111"));
    }

    // test case where one operand is 0
    @Test
    public void logicalAND2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "&").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    // test case for when both operands are of the same value
    @Test
    public void logicalAND3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "110").param("operator", "&").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "110"))
                .andExpect(model().attribute("operand1", "110"));
    }

    // test case for when operands are of different lengths
    @Test
    public void logicalAND4() throws Exception {
        this.mvc.perform(post("/").param("operand1", "10").param("operator", "&").param("operand2", "11010"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10"))
                .andExpect(model().attribute("operand1", "10"));
    }

    // test case for when both operands are 0
    @Test
    public void logicalAND5() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "&").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    // test case when both operands are of the same length
    @Test
    public void multiply() throws Exception {
        this.mvc.perform(post("/").param("operand1", "100").param("operator", "*").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11000"))
                .andExpect(model().attribute("operand1", "100"));
    }

    // test case where one operand is 0
    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "001101").param("operator", "*").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "001101"));
    }

    // test case for when both operands are of the same value
    @Test
    public void multiply3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1110").param("operator", "*").param("operand2", "1110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11000100"))
                .andExpect(model().attribute("operand1", "1110"));
    }

    // test case for when operands are of different lengths
    @Test
    public void multiply4() throws Exception {
        this.mvc.perform(post("/").param("operand1", "10").param("operator", "*").param("operand2", "1111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11110"))
                .andExpect(model().attribute("operand1", "10"));
    }

    // test case for when both operands are 0
    @Test
    public void multiply5() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0000").param("operator", "*").param("operand2", "0000"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0000"));
    }

}
