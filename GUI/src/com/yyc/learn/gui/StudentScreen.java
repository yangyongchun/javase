package com.yyc.learn.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.*;
public class StudentScreen extends JFrame{
	static int count;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JButton button1;
	JButton button2;
	JButton button3;
	JTextField txf;
	JPanel jp1;
	JPanel jp2;
	String s1;
	String s2;
	String s3;
	String time1;
	String time2;
	Random rand=new Random();
	Date d1;
	Date d2;
	public StudentScreen() {
		super("我是小学生");
		Integer i =rand.nextInt(100);
		s1=i.toString();
		Integer j =rand.nextInt(3)+1;
		if(j==1) {
			s2="+";
		}
		else if(j==2) {
			s2="-";
		}
		else{
			s2="*";
		}
		Integer k =rand.nextInt(100);
		s3=k.toString();
		label1=new JLabel(s1);
		label2=new JLabel(s2);
		label3=new JLabel(s3);
		label4=new JLabel("=");
		button1=new JButton("开始");
		button2=new JButton("结束");
		button3=new JButton("下一题");
		txf=new JTextField(10);
		jp1=new JPanel();
		jp2=new JPanel();
		jp1.add(button1);
		jp1.add(button2);
		jp2.add(label1);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(label4);
		jp2.add(txf);
		setLayout(new BorderLayout());
		add(jp1,"North");
		add(jp2,"Center");
		add(button3,"South");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = 0;
				String s1=label1.getText();
				String s2=label2.getText();
				String s3=label3.getText();
				if(s2.equals("+")) {
				result=Integer.parseInt(s1)+Integer.parseInt(s3);
				}
				if(s2.equals("-")) {
					result=Integer.parseInt(s1)-Integer.parseInt(s3);
					}
				if(s2.equals("*")) {
					result=Integer.parseInt(s1)*Integer.parseInt(s3);
					}
				String s4=String.valueOf(result);
				if(txf.getText().equals(s4)) {
					count++;
					System.out.println("对");
				}
				else {
					System.out.println("错");
				}
				
				
				Integer i =rand.nextInt(100);
				s1=i.toString();
				label1.setText(s1);
				Integer j =rand.nextInt(3)+1;
				if(j==1) {
					s2="+";
				}
				else if(j==2) {
					s2="-";
				}
				else{
					s2="*";
				}
				label2.setText(s2);
				Integer k =rand.nextInt(100);
				s3=k.toString();
				label3.setText(s3);
				txf.setText(null);
			}
			
		});
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				d1=new Date();
			    time1=dateFormat.format(d1);
				System.out.println("开始时间："+time1);
			}
			
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				d2=new Date();
				time2=dateFormat.format(d2);
				System.out.println("结束时间"+time2);
				long x=(d2.getTime()-d1.getTime())/1000;
				System.out.println("用时："+x+"秒");
				System.out.println("答对："+count+"题");
				
			}
			
		});
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new StudentScreen();
	}
}
