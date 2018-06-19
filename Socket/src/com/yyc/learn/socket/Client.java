package com.yyc.learn.socket;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class Client extends Frame implements ActionListener {
	Label label=new Label("输入聊天信息");
	TextField tf=new TextField(35);
	TextArea ta=new TextArea();
	Panel p=new Panel();
	Socket client;
	InputStream is;
	OutputStream os;
	File f;
	BufferedWriter out;
	public Client() {
		super("客户机");
		setSize(400,300);
		setVisible(true);
		p.add(label);
		p.add(tf);
		tf.addActionListener(this);
		add("Center",ta);
		add("South",p);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		try {
			f=new File("C:\text.txt");
			f.createNewFile();
			out = new BufferedWriter(new FileWriter(f));
			client=new Socket("127.0.0.1",9527);
			ta.append("已经和服务器连接："+client.getInetAddress().getHostName()+"\n\n");
			is=client.getInputStream();
			os=client.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true) {
			try {
				byte buff[]=new byte[1024];
				is.read(buff);
				String str=new String(buff);
				ta.append("服务器说："+str+"\n");
				out.write(str+"\n");
				out.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Client();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		try {
			String str=new String(tf.getText());
			byte buf[]=str.getBytes();
			tf.setText("");
			os.write(buf);
			ta.append("客户机说："+str+"\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
