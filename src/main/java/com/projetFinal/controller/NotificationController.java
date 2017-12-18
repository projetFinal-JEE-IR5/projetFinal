package com.projetFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.projetFinal.model.metier.Notification;
import com.projetFinal.model.metier.Views;

@RestController
public class NotificationController {
	
	@Autowired INotificationService notificationService;

    @JsonView(Views.Resume.class)
    @RequestMapping(value = "/notificationResume")
    public Notification getNotification(
            @RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return notificationService.getNotificationDetail(id, null, (Long) null, null, null, null);
    }

    @JsonView(Views.Detaille.class)
    @RequestMapping(value = "/notificationDetaille")
    public Notification getNotificationDetail(
         @RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return notificationService.getNotificationDetail(id, null, (Long) null, null, null, null);
    }
}
