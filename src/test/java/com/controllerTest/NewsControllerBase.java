package com.controllerTest;


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
public class NewsControllerBase extends SetupTest {

    @Test
    @Ignore
    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/acntwg/about")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
    @Ignore
    public void save() {
        MvcResult mvcResult = null;
        /*Acntwg obj = new Acntwg();
        obj.setAcntno("1057-701-8234561-3");
        obj.setWage(98765.7);
        String sendJson = PublicServiceTest.addCustomDate(gson.toJson(obj), "trndate", new Date());*/
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("acntno", "1057-701-8234561-5");
        params.put("wage", "98765.7");
        params.put("trndate", PublicServiceTest.convertDate(new Date()));

        String sendJson = gson.toJson(params);
        try {
            mvcResult = mockMvc.perform(post("/acntwg/save")
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

    @Test
    @Ignore
    public void getwage() throws Exception {
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(get("/acntwg/getwage")
                .header("User-Agent", "Firefox")
                .header("lang", "fa_IR")
                .param("accno", "1057-701-8234561-2")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andReturn();
        String responseValue = mvcResult.getResponse().getContentAsString();
        System.out.println("********* responseValue:  " + responseValue);
    }

    @Test
    @Ignore
    public void loadWage() throws Exception {
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(get("/acntwg/loadWage")
                .header("User-Agent", "Firefox")
                .header("lang", "fa_IR")
                .param("accno", "1057-701-8234561-2")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andReturn();
        String responseValue = mvcResult.getResponse().getContentAsString();
        System.out.println("********* responseValue:  " + responseValue);
    }

    @Test
    @Ignore
    public void delete() throws Exception {
        String del = "3";
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/acntwg/delete/{id}", del)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    //@Ignore
    public void findAll() throws Exception {
        MvcResult mvcResult = null;
        mvcResult = mockMvc.perform(get("/acntwg/findAll")
                .header("User-Agent", "Firefox")
                .header("lang", "fa_IR")
                .contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andReturn();
        String responseValue = mvcResult.getResponse().getContentAsString();
        System.out.println("********* responseValue:  " + responseValue);
    }

    @Test
    //@Ignore
    public void update() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", 5);
        params.put("acntno", "1057-701-8234561-5");
        params.put("wage", "123");

        String sendJson = gson.toJson(params);
        try {
            MvcResult mvcResult = mockMvc.perform(put("/acntwg/update")
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

    /*@Test
    public void saveNewsTest()  {
        MvcResult mvcResult = null;
        NewsView obj = new NewsView();
        obj.setName("نام خبر تستی");
        obj.setEnglishName("test menu");
        obj.setType("FORM");
        obj.setEnabled(true);
        try {
            mvcResult = mockMvc.perform(post("/admin/api/news/save")
                    .header("User-Agent", "Firefox")
                    .header("Referrer", "/NewsControllerAPI")
                    .header("lang", "fa_IR")
                    .content(objectMapper.writeValueAsString(obj))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            NewsView responseValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), NewsView.class);
            if (responseValue.getCode().compareTo("200") == 0){
                System.out.println("سرویس ذخیره خبر به درستی اجرا شد");
            }else{
                System.out.println("سرویس ذخیره خبر خطا دارد");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void editNewsTest()  {
        MvcResult mvcResult = null;
		NewsView obj = new NewsView();
		obj.setId(21L);
        obj.setName("نام خبر تستی");
        obj.setEnglishName("test menu");
        obj.setType("FORM");
        obj.setEnabled(true);
        try {
            mvcResult = mockMvc.perform(post("/admin/api/news/edit")
                    .header("User-Agent", "Firefox")
                    .header("Referrer", "/NewsControllerAPI")
                    .header("lang", "fa_IR")
                    .content(objectMapper.writeValueAsString(obj))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            NewsView responseValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), NewsView.class);
            if (responseValue.getCode().compareTo("200") == 0){
                System.out.println("سرویس ویرایش خبر به درستی اجرا شد !");
            }else{
                System.out.println("سرویس ویرایش خبر خطا دارد");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



	@Test
	public void loadNewsByIdTest(){
		MvcResult mvcResult = null;
		try {
			mvcResult = mockMvc.perform(get("/admin/api/news/load")
					.header("User-Agent", "Firefox")
                    .header("Referrer", "/NewsControllerAPI")
                    .header("lang", "fa_IR")
					.contentType(MediaType.APPLICATION_JSON))
					.andReturn();
			//assertThat(mvcResult);
			NewsView responseValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), NewsView.class);
            if (responseValue.getCode().compareTo("200") == 0){
                System.out.println("سرویس دریافت خبر به درستی اجرا شد");
                System.out.println(responseValue.getResponseDto());
            }else{
                System.out.println("سرویس دریافت خبر خطا دارد");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
