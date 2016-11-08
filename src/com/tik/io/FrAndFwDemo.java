package com.tik.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static String src = "e:\\a.txt";
	public static String dst = "e:\\b.txt";
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(src);
		FileWriter fw = new FileWriter(dst);
		int c;
		char[] buf = new char[8 * 1024];
		while((c = fr.read(buf, 0, buf.length)) != -1){
			System.out.println(new String(buf, 0, c));
			fw.write(buf, 0, c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
