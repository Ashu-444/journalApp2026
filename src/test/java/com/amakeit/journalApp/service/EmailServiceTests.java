package com.amakeit.journalApp.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    void testEmailMail() {
        emailService.sendEmail("ashutoshsrivastav444@gmail.com" ,
                " Testing java mail Sender " ,
                " Hi , aap kaise hain ?");
    }


}
