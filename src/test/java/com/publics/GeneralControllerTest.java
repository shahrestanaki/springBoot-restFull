package com.publics;

import com.config.Application;

import com.model.Acntwg;
import com.publics.PublicServiceTest;
import com.publics.SetupTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GeneralControllerTest extends SetupTest {

    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/acntwg/about")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    public void save(String url, Map<String, Object> params) {
        String sendJson = gson.toJson(params);
        try {
            MvcResult mvcResult = mockMvc.perform(post(url)
                    .header("User-Agent", "Firefox")
                    .header("lang", "fa_IR")
                    .content(sendJson)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            String responseValue = mvcResult.getResponse().getContentAsString();
            System.out.println("********* responseValue:  " + responseValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadWage(String url, String accno) throws Exception {
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(get(url)
                .header("User-Agent", "Firefox")
                .header("lang", "fa_IR")
                .param("accno", accno)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andReturn();
        String responseValue = mvcResult.getResponse().getContentAsString();
        System.out.println("********* responseValue:  " + responseValue);
    }

    public void delete(String url, String del) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete(url, del)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public void findAll(String url) throws Exception {
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(get(url)
                .header("User-Agent", "Firefox")
                .header("lang", "fa_IR")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andReturn();
        String responseValue = mvcResult.getResponse().getContentAsString();
        System.out.println("********* responseValue:  " + responseValue);
    }

    public void update(String url, Map<String, Object> params) {
        String sendJson = gson.toJson(params);
        try {
            MvcResult mvcResult = mockMvc.perform(put(url)
                    .header("User-Agent", "Firefox")
                    .header("lang", "fa_IR")
                    .content(sendJson)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            String responseValue = mvcResult.getResponse().getContentAsString();
            System.out.println("********* responseValue:  " + responseValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
