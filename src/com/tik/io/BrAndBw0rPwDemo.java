package com.tik.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBw0rPwDemo {
	
	public static String src = "e:\\a.txt";
	public static String dst = "e:\\b.txt";

	public static void main(String[] args) throws IOException{
		InputStreamReader reader = new InputStreamReader(new FileInputStream(src), "utf-8");
		BufferedReader br = new BufferedReader(reader);
//		BufferedReader br = new BufferedReader(new FileReader(src));//不能指定编码格式
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dst), "utf-8");
		/*
		BufferedWriter bw = new BufferedWriter(writer);
//		BufferedWriter bw = new BufferedWriter(new FileWriter(dst));//不能指定编码格式
		*/
		PrintWriter pw = new PrintWriter(new FileOutputStream(dst), false);
		String line;
		while((line = br.readLine()) != null){
			System.out.println(line);;//一次读一行，并不能识别换行
			/*
			bw.write(line);
			bw.newLine();
			bw.flush();
			*/
			pw.print(line);//不带换行符
			pw.println(line);//带换行符
			pw.flush();//若new PrintWriter(outputstream, autoFlush)的autoFlush为true，可省略此行
		}
		br.close();
		/*
		bw.close();
		*/
		pw.close();
	}

}
