package ConfidentialInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisteredUser {
	
	private static final String USER_1 ="shobhit";
	private static final String USER_2 ="Gaurav";
	
	public List<String> listOfUsers = new ArrayList<String>();
	

	private HashMap<String, String> map = new HashMap<String, String>();

	public List<String> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<String> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public static String getUser1() {
		return USER_1;
	}

	public static String getUser2() {
		return USER_2;
	}

	
	

}
