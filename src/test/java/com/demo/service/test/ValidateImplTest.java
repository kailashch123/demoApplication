package com.demo.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.controller.AbstractTest;
import com.demo.model.User;
import com.demo.repo.inf.validateRepoImpl;
import com.demo.service.impl.ValidateImpl;

@RunWith(SpringRunner.class)
public class ValidateImplTest extends AbstractTest{
	
	@InjectMocks
	ValidateImpl valImpl;
	
	@Mock
	validateRepoImpl ValidateRepoInf;
	
	@Test
	public void loginTest() throws Exception{
		
		User user = new User("001","a_fname","a_lname","pwd_1");
				
		when(ValidateRepoInf.login(user)).thenReturn("User found with user Id: " +user.getUserId());
		String response = valImpl.login(user);
		String expected = "User found with user Id: 001";
		assertEquals(expected, response);
		
	}
	
	
	
	@Test
	public void createTest() {
		String expected = "User created";
		User user = new User("004","d_fname","d_lname","pwd_4");
		
		when(ValidateRepoInf.create(user)).thenReturn(expected);
		String response = valImpl.create(user);
		assertEquals(expected, response);
	}
	
	/*
	 * @Test public void createTestFailure() { User user = new User("", "", "", "");
	 * 
	 * when(validateImpl.create(user)).thenReturn(null); ResponseEntity<String>
	 * response = valUserCont.create(user);
	 * assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	 * response.getStatusCodeValue()); }
	 */
	
	@Test
	public void updateTest() throws Exception {
		/*
		 * String uri = "validate/update"; MvcResult mvcResult =
		 * mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.
		 * APPLICATION_JSON_VALUE)).andReturn();
		 * 
		 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
		 */
		
		
		String Response = "User updated for the userID: 002";
		User user = new User("002","change_fname","b_lname","pwd_2");
		
		when(ValidateRepoInf.update(user)).thenReturn(Response);
		String response = valImpl.update(user);
		assertEquals(Response, response);
	}
	
	/*
	 * @Test public void updateTestFailure() throws Exception {
	 * 
	 * User user = new User("", "", "", "");
	 * 
	 * when(validateImpl.update(user)).thenReturn(null); ResponseEntity<String>
	 * response = valUserCont.update(user);
	 * assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	 * response.getStatusCodeValue()); }
	 */
	
	@Test
	public void deleteTest() {
		String Response = "User deleted for the userID: 003";
		User user = new User("003","c_fname","c_lname","pwd_3");
		
		when(ValidateRepoInf.delete(user)).thenReturn(Response);
		String response = valImpl.delete(user);
		assertEquals(Response, response);
	}
	
	/*
	 * @Test public void deleteTestFailure() { User user = new User("", "", "", "");
	 * 
	 * 
	 * when(validateImpl.delete(user)).thenReturn(null); ResponseEntity<String>
	 * response = valUserCont.delete(user);
	 * assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	 * response.getStatusCodeValue()); }
	 */
	
	
}

