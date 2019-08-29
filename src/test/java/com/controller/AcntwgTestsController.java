package com.controller;

import com.config.Application;
import com.publics.TestMain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@DisplayName(" * AcntwgController *")
public class AcntwgTestsController extends TestMain {

    @DisplayName(" * testAbout *")
    @Test
    public void testAbout(TestInfo testInfo) {

        String message = restTemplate.getForObject("/acntwg/getwage?accno=1057-701-8234561-1", String.class);
        System.out.println("message : " + message +  testInfo.getDisplayName());
    }
}
