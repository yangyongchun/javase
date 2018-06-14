package com.yyc.io;
import java.io.*;
/**
 * 通过文件名来进行过滤
 * @author yyc
 *
 */
class MyFilenameFilter implements FilenameFilter{

	
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		if(name.endsWith(".txt")) {
			return true;
		}
		else {
		return false;
		}
	}
	
}
/**
 * 通过文件对象来过滤，可以对对象做一些操作
 * @author yyc
 *
 */
class MyFileFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		if(pathname.isDirectory()) {
			return true;
		}
		else {
		return false;
		}
	}
	
}

public class TestFile {
	public static void main(String[] args) {
		
		File file=new File("/Users/yyc/Documents/test.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------目录.list()方法-------------------------------");
		File dir=new File("/Users/yyc/Documents/JavaHomework/JavaCode");
		dir.mkdir();
		String[] filename=dir.list();//返回的是file的名字
		for(String s:filename) {
			System.out.println(s+"");
		}
		System.out.println("-------------目录.listFile()方法-----------------------------");
		File[] fileObject=dir.listFiles();//返回的是file的对象，可以对其进行一些操作
	    for(File f:fileObject) {
	    	System.out.println(f.getAbsolutePath());
	    	System.out.println(f.getName());
	    	System.out.println(f.isFile());
	    }
	    
	    System.out.println("-------------目录.listFile()方法(使用MyFilenameFilter()过滤器)-----------------------------");
	    File[] fileObject1=dir.listFiles(new MyFilenameFilter());
	    for(File f:fileObject1) {
	    	System.out.println(f.getName());
	    }
	    System.out.println("-------------目录.listFile()方法(使用MyFileFilter()过滤器)-----------------------------");
	    File[] fileObject2=dir.listFiles(new MyFileFilter());
	    for(File f:fileObject2) {
	    	System.out.println(f.getName());//没有目录，所以输出为空
	    }
	   
	    
		
	}
}
