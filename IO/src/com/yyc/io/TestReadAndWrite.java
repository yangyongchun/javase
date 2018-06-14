package com.yyc.io;
import java.io.*;
/**
 * 先生成一个文件，然后把这个文件写入(copy)到另一个文件
 * @author yyc
 *
 */
public class TestReadAndWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f1=new File("/Users/yyc/Documents/test1.txt");
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(f1,true));
			//输出流如果文件不存在可以自动创建一个，输入流的话不行会报异常
			for(int i=0;i<10;i++) {
			bw.write("11111111111111"+"\r");
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File f2=new File("/Users/yyc/Documents/test2.java");
		try {
			BufferedReader br=new BufferedReader(new FileReader(f1));
			BufferedWriter bw=new BufferedWriter(new FileWriter(f2,true));
		
			String line=br.readLine();
			while(line!=null) {
				bw.write(line+"\r");
				line=br.readLine();
			}
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
