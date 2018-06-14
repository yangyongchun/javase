package com.yyc.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase{
	int id() default 0;
	String description() default "no desc";
	
}

class Test1 {
	public void excute() {
		System.out.println("abc");
	}
	public void testExcute() {
		excute();
	}
	@UseCase(id=1,description="aaaaaaa")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}
	@UseCase(id=2)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}	
}



public class UseCaseTracker{
	public static void trackUseCases(List<Integer> useCases,Class<?> c) {
		for(Method m:c.getDeclaredMethods()){
		
			UseCase uc=m.getAnnotation(UseCase.class);
			if(uc!=null) {
				System.out.println("Found UseCase:"+uc.id()+" "+uc.description()); 
				useCases.remove(new Integer(uc.id()));
				
			}
			
		}
		
		for(int i:useCases) {
			System.out.println("Warning:Missing useCase:"+i);
		}
		
	}
	public static void main(String[] args) {
		List<Integer> l=new ArrayList<Integer>();

		Collections.addAll(l, 1,2,3,4);
		trackUseCases(l,Test1.class);
	}
}
