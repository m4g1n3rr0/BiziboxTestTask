package com.example.DataReceiving;

import java.util.Arrays;
import java.util.List;

import org.aspectj.weaver.ast.Call;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.DataReceiving.model.Contact;
import com.example.DataReceiving.repo.CallRepo;
import com.example.DataReceiving.service.PhNumService;

import junit.framework.Assert;

@SpringBootTest
//@RunWith(SpringRunner.class)
class DataReceivingApplicationTests {

    @Autowired
    private PhNumService callService;

    @MockBean
    private CallRepo callRepo;

    @Test
    public void testAddCall() {
        
        Contact person = new Contact();
        person.setId(1L);
        person.setBlacklist(false);

        Call call = new Call(null, null);
        call.setPerson(person);

        Mockito.when(callRepo.save(Mockito.any(Call.class))).thenReturn(call);

        callService.addCall(call);

        Mockito.verify(callRepo, Mockito.times(1)).save((Iterable<S>) Mockito.any(Call.class));
    }

    @Test
    public void testGetCallsByPerson() {
        
    	Contact person = new Contact();
        person.setId(1L);

        Call call1 = new Call(null, null);
        call1.setContact(person);

        Call call2 = new Call(null, null);
        call2.setContact(person);

        List<Call> expectedCalls = Arrays.asList(call1, call2);

        Mockito.when(callRepo.findByContact(person)).thenReturn(expectedCalls);

        // Вызываем метод сервиса
        List<Call> actualCalls = callService.getCallsByContact(person);

        Assert.assertEquals(expectedCalls, actualCalls);
    }

}
