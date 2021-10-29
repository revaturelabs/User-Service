package com.reverse.userservice.repositories;

import com.reverse.userservice.models.Credentials;
import org.springframework.stereotype.Component;

@Component("MockUserRepo")
public class MockUserRepo {

    public Credentials getUser() {
        return new Credentials("testName", "testPass");
    }
}
