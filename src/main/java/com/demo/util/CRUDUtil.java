package com.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.model.User;

@Component
public class CRUDUtil {
	
	List<User> userList = new ArrayList<User>(Arrays.asList(
			new User("001","a_fname","a_lname","pwd_1"),
			new User("002","b_fname","b_lname","pwd_2"),
			new User("003","c_fname","c_lname","pwd_3")
			));	
	
	@SuppressWarnings("unlikely-arg-type")
	public String getUser(User user) {
		String result = "";
		

		for (User s: userList) {
			if(s.getUserId().equals(user.getUserId())) {
				result = "User found";
				break;
			}else {
				result = "User Not found";
			}
			
		}
		System.out.println("getUSerTest::::  "+userList.size());
        Iterator<User> itr=userList.iterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
	
				
		return result;
		
	}

	
	public String createUser(User user) {
		
		 String response = "";
				 
		int beforeCount = userList.size();
		  userList.add(new User(user.getUserId(), user.getFirstName(), user.getLastName(), user.getPassword()));
		  int afterCount = userList.size();
		  if(afterCount > beforeCount) {
			   response = "User created";
		  }
		  
		  System.out.println("createUser::::  "+userList.size());
		  Iterator<User> itr=userList.iterator();

	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }
		  
		return response;	
				
	}
	
	public String updateUser(User user) {
		String update = "";		
		
		for (int i = 0; i < userList.size(); i++) {

	        if (userList.get(i).getUserId().equals(user.getUserId())) {

	        	userList.get(i).setFirstName(user.getFirstName());
	        	update = "User updated for the userID: "  + user.getUserId();
	        }
	    }
		System.out.println("updateUserTest::::  "+userList.size());
		  Iterator<User> itr=userList.iterator();

	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }
		
	        
		return update;
		
	}
	
	public String deleteUser(User user) {
		String delete = "";

		/*for (User s: userList) {
			if(s.getUserId().equals(user.getUserId())) {
				userList.remove(user);
				delete = "User deleted for the userID"  + user.getUserId();
			}else {
				delete = "User Not found";
			}
			
		}*/
		System.out.println("before deleteUser::::  "+userList.size());

		  Iterator<User> itr=userList.iterator();

	        while(itr.hasNext())
	        {
	        	User user_itr = itr.next();
	        	 if (user_itr.getUserId() == user.getUserId()){
	        	      itr.remove();
	        	      delete = "User deleted for the userID: "  + user.getUserId();
	        	      Iterator<User> itr1=userList.iterator();

	      	        while(itr1.hasNext())
	      	        {
	      	            System.out.println("after delete----" +itr1.next());
	      	        }
	        	  }else {
	    				delete = "User Not found";
	    			}
	        }
	        
	       
			return delete;
	        

		
	}
}
