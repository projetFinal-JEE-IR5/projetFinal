package com.projetFinal.projetFinal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.projetFinal.controller.NotificationControleur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@WebAppConfiguration()

public class TestsRestSpring4 {
	//adapter selon le context path de l'appli web
    final String BASE_URL = "http://localhost:8080/";

    final String URI_RESUME = BASE_URL + "notificationResume";
    final String URI_DETAILLE = BASE_URL + "notificationDetaille";

    @Autowired NotificationControleur NotificationCtrl;
    @Autowired RestTemplate restTemplate;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
