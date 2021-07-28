package com.arilab.expman.testsconfig;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Environment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestEnvironmentUsed {


    @Value("${spring.profiles.active}")
    private String activeProfile;


    @Test
    public void TestEnvironmentIsUsed() {

        assertEquals("test",activeProfile);

    }
}
