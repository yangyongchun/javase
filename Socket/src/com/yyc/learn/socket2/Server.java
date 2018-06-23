package com.yyc.learn.socket2;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Server extends Frame implements ActionListener {

	Label label=new Label("输入聊天信息");
	TextField tf=new TextField(35);
	TextArea ta=new TextArea();
	Panel p=new Panel();
	ServerSocket server;
	Socket client;
	InputStream is;
	OutputStream os;
	public Server() {
		super("服务器");
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
		setSize(400,300);
		setVisible(true);
		try {
			server=new ServerSocket(9527);
			client=server.accept();
			ta.append("已经和客户机连接："+client.getInetAddress().getHostName()+"\n\n");
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
				ta.append("客户机说："+str+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			String str=new String(tf.getText());
			byte buf[]=str.getBytes();
			tf.setText("");
			os.write(buf);
			ta.append("服务器说："+str+"\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Server();
		
	}

}
