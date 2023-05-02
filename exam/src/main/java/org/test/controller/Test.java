package org.test.controller;

import org.test.dao.UserOperation;

public class Test {

	public static void main(String[] args) {
		UserOperation uo= new UserOperation();
		
//		uo.saveUserAndFoodorder();
//		uo.updateUserAndFoodorder();
//		uo.deleteFoodOrder();
//		uo.veifyUser();
//		uo.fetchFoodorderByUserId();
		uo.fetchFoodorderByUserdata();
		
	}
}