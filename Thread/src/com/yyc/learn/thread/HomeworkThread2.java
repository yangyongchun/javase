package com.yyc.learn.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

class ChangeNum implements Runnable{

	private Boolean b=true;
	private JLabel jlabel;
	
	public ChangeNum(JLabel jlabel) {
		super();
		this.jlabel = jlabel;
	}

	public Boolean getB() {
		return b;
	}


	public void setB(Boolean b) {
		this.b = b;
	}


	public JLabel getJlabel() {
		return jlabel;
	}


	public void setJlabel(JLabel jlabel) {
		this.jlabel = jlabel;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(b) {
			Random rand=new Random();
			String str=String.valueOf(rand.nextInt(10));
			jlabel.setText(str);
		}
	}
	
}
public class HomeworkThread2 extends JFrame{
	private JButton b1;
	private JLabel j1;
	private JLabel j2;
	private JLabel j3;
	private JLabel j4;
	private JLabel j5;
	private JLabel j6;
	private JPanel jp1;
	private Thread t1;
	private Thread t2;
	private Thread t3;
	private Thread t4;
	private Thread t5;
	private Thread t6;
	private ChangeNum c1;
	private ChangeNum c2;
	private ChangeNum c3;
	private ChangeNum c4;
	private ChangeNum c5;
	private ChangeNum c6;
	public HomeworkThread2() {
		super("摇号");
		j1=new JLabel("0");
		j2=new JLabel("0");
		j3=new JLabel("0");
		j4=new JLabel("0");
		j5=new JLabel("0");
		j6=new JLabel("0");
		c1=new ChangeNum(j1);
		c2=new ChangeNum(j2);
		c3=new ChangeNum(j3);
		c4=new ChangeNum(j4);
		c5=new ChangeNum(j5);
		c6=new ChangeNum(j6);
		t1=new Thread(c1);
		t2=new Thread(c2);
		t3=new Thread(c3);
		t4=new Thread(c4);
		t5=new Thread(c5);
		t6=new Thread(c6);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		b1=new JButton("停止");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			c1.setB(false);
			c2.setB(false);
			c3.setB(false);
			c4.setB(false);
			c5.setB(false);
			c6.setB(false);
			}
			
		});
		jp1=new JPanel();
		jp1.setPreferredSize(new Dimension(200, 50));
		jp1.add(j1);
		jp1.add(j2);
		jp1.add(j3);
		jp1.add(j4);
		jp1.add(j5);
		jp1.add(j6);
		setLayout(new FlowLayout());
		add(b1);
		add(jp1);
		setSize(200,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new HomeworkThread2();
	}
}
