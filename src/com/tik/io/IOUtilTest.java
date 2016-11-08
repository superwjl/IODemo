package com.tik.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtilTest {

	public static String src = "e:\\a.txt";
	public static String dst = "e:\\b.txt";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long start = System.currentTimeMillis();
		// IOUtil.printHex("e:\\test.txt");
		// IOUtil.printHexByByteArray("e:\\test.txt");
		// long period = System.currentTimeMillis() - start;
		// System.out.println(period);
		// IOUtil.writeByte("/Users/xiaokangxin/Desktop/a.txt");
//		IOUtil.copyFile(new File(src), new File(dst));
		IOUtil.copyFileByBuffer(new File(src), new File(dst));
//		testDataOutputStream();
//		testDataInputStream();

	}

	public static void testDataOutputStream() {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(src));
			dos.writeInt(10);
			dos.writeLong(5L);
//			dos.writeDouble(10.4);
//			dos.writeFloat(1.5f);
			//采用utf-8编码写出
			dos.writeUTF("中国");
			//采用utf-16be编码写出
//			dos.writeChars("中国");
			dos.flush();
			dos.close();
			IOUtil.printHex(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testDataInputStream(){
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(src));
			int i = dis.readInt();
			System.out.println(i);
			long l = dis.readLong();
			System.out.println(l);
			String s = dis.readUTF();
			System.out.println(s);
			dis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
