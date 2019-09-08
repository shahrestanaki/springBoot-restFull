package com.controllerTest;


import com.config.Application;
import com.publics.SetupTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NewsControllerTest extends SetupTest {

    @Test
    @Ignore
    public void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/acntwg/about")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
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
