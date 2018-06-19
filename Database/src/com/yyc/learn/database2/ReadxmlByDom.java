package com.yyc.learn.database2;
import java.util.ArrayList;  
import java.util.List;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
  
import org.w3c.dom.Document;  
import org.w3c.dom.NamedNodeMap;  
import org.w3c.dom.NodeList;  
  
  
/** 
 * 用DOM方式读取xml文件 
 * @author lune 
 */  
public class ReadxmlByDom {  
    private static DocumentBuilderFactory dbFactory = null;  
    private static DocumentBuilder db = null;  
    private static Document document = null;  
    private static List<Student> books = null;  
    static{  
        try {  
            dbFactory = DocumentBuilderFactory.newInstance();  
            db = dbFactory.newDocumentBuilder();  
        } catch (ParserConfigurationException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public static List<Student> getStudents(String fileName) throws Exception{  
        //将给定 URI 的内容解析为一个 XML 文档,并返回Document对象  
        document = db.parse(fileName);  
        //按文档顺序返回包含在文档中且具有给定标记名称的所有 Element 的 NodeList  
        NodeList bookList = document.getElementsByTagName("学生");  
        books = new ArrayList<Student>();  
        //遍历books  
        for(int i=0;i<bookList.getLength();i++){  
            Student s = new Student();  
            //获取第i个book结点  
            org.w3c.dom.Node node = bookList.item(i);  
            //获取第i个book的所有属性  
            NamedNodeMap namedNodeMap = node.getAttributes();  
            //获取已知名为id的属性值  
            String id = namedNodeMap.getNamedItem("学号").getTextContent();//System.out.println(id);  
            s.set学号(id);  
              
            //获取book结点的子节点,包含了Test类型的换行  
            NodeList cList = node.getChildNodes();//System.out.println(cList.getLength());9  
              
            //将一个book里面的属性加入数组  
            ArrayList<String> contents = new ArrayList<>();  
            for(int j=1;j<cList.getLength();j+=2){  
                  
                org.w3c.dom.Node cNode = cList.item(j);  
                String content = cNode.getFirstChild().getTextContent();  
                contents.add(content);  
                //System.out.println(contents);  
            }  
              
            s.set姓名(contents.get(0));  
            s.set性别(contents.get(1));  
            s.set年龄(contents.get(2));  
            books.add(s);  
        }  
          
        return books;  
          
    }  
      
    public static void main(String args[]){  
        String fileName = "src/com/yyc/learn/database2/Student.xml";  
        StudentDao dao=new StudentDao();
        try {  
            List<Student> list = ReadxmlByDom.getStudents(fileName);  
            for(Student s :list){  
                dao.addStudent(s);
            }  
            System.out.print("插入数据库成功！");
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
          
}  