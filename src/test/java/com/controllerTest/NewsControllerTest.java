package com.controllerTest;

import com.publics.GeneralControllerTest;
import com.publics.PublicServiceTest;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NewsControllerTest extends GeneralControllerTest {
    String mainUrlController = "/acntwg";

    @Test
    @Ignore
    public void acnShouldReturnDefaultMessage2() throws Exception {
        shouldReturnDefaultMessage();
    }

    @Test
    @Ignore
    public void acnSave() {
        String url = mainUrlController + "/save";
        Map<String, Object> params = new HashMap<>();
        params.put("acntno", "1057-701-8234561-5");
        params.put("wage", "98765.7");
        params.put("trndate", PublicServiceTest.convertDate(new Date()));
        save(url, params);
    }

    @Test
    @Ignore
    public void acnLoadWage() throws Exception {
        String url = mainUrlController + "/loadWage";
        String accno = "1057-701-8234561-2";
        loadWage(url, accno);
    }
}
