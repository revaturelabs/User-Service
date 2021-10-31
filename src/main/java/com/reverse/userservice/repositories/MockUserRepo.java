package com.reverse.userservice.repositories;

import com.reverse.userservice.models.Credentials;
import org.springframework.stereotype.Component;

@Component("MockUserRepo")
public class MockUserRepo {

    public Credentials getUser() {
        return new Credentials("testName", "$2a$10$ghIubX.25VrNf2LFtRddh.N7bsuU4I0SvDzKBjmXOQB0P5f4WhSaa");
    }
}
