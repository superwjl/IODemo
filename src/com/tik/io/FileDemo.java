package com.tik.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("E:\\javaio\\test");
		File file1 = new File("E:" + File.separator);
		if(!file.exists()){
			file.mkdir();//file.mkdirs();
		}else{
			file.delete();
		}
		//是否是一个目录，如果是目录返回true，如果不是目录或者目录不存在返回false
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());
//		File file2 = new File("e:\\javaio\\test.txt");
		File file2 = new File("e:\\javaio", "test.txt");
		if(!file2.exists()){
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			file2.delete();
		}
		System.out.println(file);//file2.toString()
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());
	}

}
