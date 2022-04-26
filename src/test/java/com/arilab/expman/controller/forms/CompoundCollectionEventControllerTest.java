package com.arilab.expman.controller.forms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompoundCollectionEventControllerTest {


    @Test
    public void shouldFailIfUserSelectedNewLocalityButDidNotEnteredAnyLocalityCode() {
        fail();
    }

    @Test
    public void shouldFailIfUserSelectedNewLocalityButEnteredExistingLocalityCode() {
        fail();
    }

    @Test
    public void shouldBeOkIfUserSelectedNewLocalityAndEnteredNewLocalityCode() {
        fail();
    }

    @Test
    public void shouldPassIfUserSelectedNewLocalityAndEnteredValidLocalityInformation() {
     fail();
    }

    @Test
    public void shouldFailIfUserSelectedNewlocalityAndEnteredInvalidLocalityInformation() {
        fail();
    }


    @Test
    public void shouldFailIfUserEnteredExistingCollectionEventCode() {
        fail();
    }


    @Test
    public void shouldBeOkIfUserEnteredNewCollectionEvenCode() {
        fail();
    }





}