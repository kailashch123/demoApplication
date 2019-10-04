package com.demo.service.inf;

import java.util.List;

import com.demo.model.User;

public interface ValidateInterface {
	String login(User user);
	String create(User user);
	String update(User user);
	String delete(User user);


}
