package com.yyc.learn.socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			URL url=new URL("http","www.baidu.com","");
			try {
				BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"gbk"));
				String line;
				while((line=br.readLine())!=null) {
					System.out.println(line);
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
