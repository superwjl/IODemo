package com.tik.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {
	public static String src = "e:\\a.txt";
	public static String dst = "e:\\b.txt";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream(src);
		InputStreamReader reader = new InputStreamReader(in, "utf-8");//默认项目的编码
		FileOutputStream out = new FileOutputStream(dst);
		OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
		int c;
		/*
		while((c = reader.read()) != -1){
			System.out.print((char)c);
		}*/
		char[] buf = new char[8 * 1024];
		while((c = reader.read(buf, 0, buf.length)) != -1){
			String s = new String(buf, 0, c);
			System.out.print(s);
			writer.write(buf, 0, c);
			writer.flush();
		}
		reader.close();
		writer.close();
	}

}
