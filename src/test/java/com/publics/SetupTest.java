package com.publics;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Component
public class SetupTest {

    @Autowired
    private WebApplicationContext wac;

    public MockMvc mockMvc;

    public ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Rule
    public TestName name = new TestName();

    @Before
    public void beforeTest() throws JsonProcessingException{
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();  //setupMockMvc
        //objectMapper = new ObjectMapper();
        //objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        System.out.println( "######################################### Before test the " + name.getMethodName() + " #########################################");
        //System.out.println( "######################################### Before test the #########################################");
    }

    @After
    public void afterTest(){
        System.out.println( "######################################### After test the  " + name.getMethodName() + " #########################################");
        //System.out.println( "######################################### After test the  #########################################");
    }
}
