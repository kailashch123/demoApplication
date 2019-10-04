package com.demo.repo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.controller.AbstractTest;
import com.demo.model.User;
import com.demo.repo.impl.ValidateRepoImpl;
import com.demo.util.CRUDUtil;

@RunWith(SpringRunner.class)
public class ValidateRepoImplTest extends AbstractTest{
	
	@InjectMocks
	ValidateRepoImpl validateRepoImpl;
	
	@Mock
	CRUDUtil crud;
	
	@Test
	public void loginTest() throws Exception{
		
		User user = new User("001","a_fname","a_lname","pwd_1");
				
		when(crud.getUser(user)).thenReturn("User found with user Id: " +user.getUserId());
		String response = validateRepoImpl.login(user);
		String expected = "User found with user Id: 001";
		assertEquals(expected, response);
		
	}
	
	
	
	@Test
	public void createTest() {
		String expected = "User created";
		User user = new User("004","d_fname","d_lname","pwd_4");
		
		when(crud.createUser(user)).thenReturn(expected);
		String response = validateRepoImpl.create(user);
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
		
		when(crud.updateUser(user)).thenReturn(Response);
		String response = validateRepoImpl.update(user);
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
		
		when(crud.deleteUser(user)).thenReturn(Response);
		String response = validateRepoImpl.delete(user);
		assertEquals(Response, response);
	}
	
	
	
}

