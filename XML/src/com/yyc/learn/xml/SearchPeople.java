package com.yyc.learn.xml;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class Student{
private String id;
private String name;
private String sex;
private String age;
public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "学号=" + id + "\r\n姓名=" + name + "\r\n性别=" + sex + "\r\n年龄=" + age + "\r\n———————--\r\n";
	}
}
class ReadXML{
private static DocumentBuilderFactory dbf=null;
private static DocumentBuilder db=null;
private static Document d=null;
static {
dbf=DocumentBuilderFactory.newInstance();
try {
	db=dbf.newDocumentBuilder();
} catch (ParserConfigurationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}//
}
public static List<Student> getStudents(String path){
try {
	d=db.parse(path);
} catch (SAXException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
NodeList nl1=d.getElementsByTagName("学生");//
List<Student> l1=new ArrayList<Student>();//

for(int i=0;i<nl1.getLength();i++){
Student s=new Student();//
Node n1=nl1.item(i);//
NamedNodeMap nnm=n1.getAttributes();//
String id=nnm.getNamedItem("学号").getTextContent();//
s.setId(id);
NodeList nl2=n1.getChildNodes();//
List<String> l2=new ArrayList<String>();
for(int j=1;j<nl2.getLength();j+=2){
Node n2=nl2.item(j);
String str=n2.getFirstChild().getTextContent();
l2.add(str);
}
s.setName(l2.get(0));
s.setSex(l2.get(1));
s.setAge(l2.get(2));
l1.add(s);
}
return l1;
}
}
public class SearchPeople extends JFrame{
JLabel jl1;
JLabel jl2;
JTextField jtf1;
JTextField jtf2;
JTextArea jta;
JScrollPane jsp;
JPanel jp1;
JButton jb1;
public SearchPeople(){
jl1=new JLabel("姓名中包含：");
jl2=new JLabel("学号中包含：");
jtf1=new JTextField(12);
jtf2=new JTextField(12);
jta=new JTextArea();
jsp=new JScrollPane(jta);
jp1=new JPanel();
jp1.setPreferredSize(new Dimension(300,300));
jb1=new JButton("确定");
jb1.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
			List<Student> l1=ReadXML.getStudents("src//com/yyc/learn/xml/Student.xml");
			List<Student> l2=new ArrayList<Student>();
			String str1=jtf1.getText();
			String str2=jtf2.getText();

			if((!str1.equals(""))&&(str2.equals("")))
			{
			for(Student s:l1){
			if(s.getName().contains(str1)){
			l2.add(s);
			}}}
			else if((str1.equals(""))&&(!str2.equals("")))
			{
			for(Student s:l1){
			if(s.getId().contains(str2)){
			l2.add(s);
			}
			}
			}
			else if((!str1.equals(""))&&(!str2.equals(""))){
			for(Student s:l1){
			if(s.getName().contains(str1)&&s.getId().contains(str2))
			{
			l2.add(s);
			}
			}
			}
			else{
			}
			String str3="";
			for(Student s:l2){
			str3+=s.toString();
			}
			jta.setText(str3);
			}
});
jp1.setLayout(new FlowLayout());
jp1.add(jl1);
jp1.add(jtf1);
jp1.add(jl2);
jp1.add(jtf2);
jp1.add(jb1);
setLayout(new BorderLayout());
add(jp1,"West");
add(jsp);
setSize(600,300);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
	new SearchPeople();
}

}