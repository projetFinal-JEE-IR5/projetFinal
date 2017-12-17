package com.projetFinal.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Session {
	private Integer currentUserId;
	private String currentTypePersonne;
	private String currentLogin;

	public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

	public String getCurrentTypePersonne() {
		return currentTypePersonne;
	}

	public void setCurrentTypePersonne(String currentTypePersonne) {
		this.currentTypePersonne = currentTypePersonne;
	}

	public String getCurrentLogin() {
		return currentLogin;
	}

	public void setCurrentLogin(String currentLogin) {
		this.currentLogin = currentLogin;
	}
}
