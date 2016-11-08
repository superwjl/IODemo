package com.tik.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerialDemo1 {
	public static String src = "e:\\a.txt";
	public static String dst = "e:\\b.txt";
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//对象的序列化
		Student stu = new Student(1, "tik", 20);
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(src));
		os.writeObject(stu);
		os.flush();
		os.close();
		
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(src));
		Student student = (Student) is.readObject();
		System.out.println(student);
		is.close();
	}

}
