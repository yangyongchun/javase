package com.yyc.learn.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Login extends JFrame{

	JLabel label1;
	JLabel label2;
	JLabel label3;
	JButton button1;
	JButton button2;
	JButton button3;
	JTextField txf1;
	JTextField txf2;
	JComboBox jcb;
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp4;
	JPanel jp5;
	public Login() {
		super("用户登录");
		jcb=new JComboBox();
		jcb.addItem("教师用户");
		jcb.addItem("学生用户");
		label1=new JLabel("用户类别");
		label2=new JLabel("用户名");
		label3=new JLabel("密码");
		button1=new JButton("登录");
		button2=new JButton("取消");
		button3=new JButton("退出");
		txf1=new JTextField(10);
		txf2=new JTextField(10);
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp1.add(label1);
		jp1.add(jcb);
		jp2.add(label2);
		jp2.add(txf1);
		jp3.add(label3);
		jp3.add(txf2);
		jp4.add(button1);
		jp4.add(button2);
		jp4.add(button3);
		jp5.setLayout(new BorderLayout());
		jp5.add(jp1,"North");
		jp5.add(jp2,"Center");
		jp5.add(jp3,"South");
		setLayout(new BorderLayout());
		add(jp5,"North");
		add(jp4,"South");
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jcb.getSelectedItem().equals("教师用户")&&txf1.getText().equals("teacher")&&txf2.getText().equals("teacher"))
				{
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "登录成功", "标题",JOptionPane.DEFAULT_OPTION);  
				}
				
				else if(jcb.getSelectedItem().equals("学生用户")&&txf1.getText().equals("student")&&txf2.getText().equals("student"))
				{
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "登录成功", "标题",JOptionPane.DEFAULT_OPTION);  
				}
				
				else {
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "用户名不存在或密码不正确", "标题",JOptionPane.WARNING_MESSAGE);  
				}
			}
			
		});
	}

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Login();
	}

}
