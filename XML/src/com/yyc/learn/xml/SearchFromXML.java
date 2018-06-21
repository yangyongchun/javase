package com.yyc.learn.xml;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class SearchFromXML extends JFrame {

	private JLabel jl1;
	private JLabel jl2;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextArea jta;
	private JScrollPane js;
	private JPanel jp1;
	private JButton b1;
	public SearchFromXML() {
		super("查人");
		jl1 =new JLabel("姓名中包含：");
		jl2 =new JLabel("学号中包含：");
		jtf1=new JTextField(12);
		jtf2=new JTextField(12);
		jta=new JTextArea();
		js=new JScrollPane(jta);
		js.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jp1=new JPanel();
		b1=new JButton("确定");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  String fileName = "src/com/yyc/learn/xml/Student.xml"; 
				  try {
					  String str1=jtf1.getText();
					  String str2=jtf2.getText();
					List<Student> list = ReadxmlByDom.getStudents(fileName);
					  for(Student s :list){  
			         String str3=s.get姓名();
			         String str4=s.get学号();
			         if((!str1.equals(""))&&str3.contains(str1)) {
			        	 jta.append("姓名："+s.get姓名()+"\r\n"+"性别："+s.get性别()+"\r\n"+"年龄："+s.get年龄()+"\r\n"+"---------------"+"\r\n");
			         }
			         if((!str2.equals(""))&&str4.contains(str2)) {
			        	 jta.append("学号："+s.get学号()+"\r\n"+"性别："+s.get性别()+"\r\n"+"年龄："+s.get年龄()+"\r\n"+"---------------"+"\r\n");
			         }
			            }  
					  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			}
			
		});
		jp1.setPreferredSize(new Dimension(300, 300));
		jp1.setLayout(new FlowLayout());
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(b1);
		
		
		setLayout(new BorderLayout());
		add(jp1,"West");
		add(js);
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SearchFromXML();
	}

}
