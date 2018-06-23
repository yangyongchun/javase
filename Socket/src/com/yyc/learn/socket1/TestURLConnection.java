package com.yyc.learn.socket1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestURLConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			URL url=new URL("http","www.baidu.com","");
			URLConnection conn=url.openConnection();
			conn.setDoOutput(true);
			PrintStream ps=new PrintStream(conn.getOutputStream());
			//在URL后加上123；
			ps.println("123");
			ps.close();
			
			DataInputStream dis=new DataInputStream(conn.getInputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(dis));
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			dis.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
