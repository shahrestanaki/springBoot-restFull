package com.publics;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestMain {
    @Autowired
    public TestRestTemplate restTemplate;

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("############## Start Test ##############");
        System.out.println("*** Name Of Tested Class : " + testInfo.getTestClass());
        System.out.println("*** Name Of Tested Method : " + testInfo.getTestMethod().get().getName());
        System.out.println(testInfo.getTags());
        System.out.println();
    }

    @AfterAll
    public static void cleanUp() {
        System.out.println("############## End Test ##############");
    }
}