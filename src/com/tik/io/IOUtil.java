package com.tik.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * 单字节读取不适合大文件
	 * @param filename
	 * @throws IOException
	 */
	public static void printHex(String filename) throws IOException{
		FileInputStream in = new FileInputStream(filename);
		int b;
		int i = 1;
		while((b = in.read()) != -1){
			if(b <= 0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if(i++ % 10 == 0){
				System.out.println();
			}
		}
		in.close();
	}
	
	/**
	 * 批量读取，大文件读取效率高
	 * @param filename
	 * @throws IOException
	 */
	public static void printHexByByteArray(String filename) throws IOException{
		FileInputStream in = new FileInputStream(filename);
		byte[] buf = new byte[8 * 1024];
		/*
		 * 从in中批量读取字节，放入到buf字节数组中，
		 * 从第0个位置开始放，最多放buf.length个，
		 * 返回的是读到的字节的个数
		 */
		/*
		int bytes = in.read(buf, 0, buf.length);
		int j = 1;
		for (int i = 0; i < bytes; i++) {
			if(buf[i] <= 0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
			if(j++ % 10 == 0){
				System.out.println();
			}
		}
		*/
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf, 0, buf.length)) != -1){
			for (int i = 0; i < bytes; i++) {
				if(buf[i] <= 0xf){
					System.out.print("0");
				}
				/*
				 * byte类型为8位，int类型32
				 * 为了避免数据转换错误，通过&0xff将高24位清零
				 */
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if(j++ % 10 == 0){
					System.out.println();
				}
			}
		}
		in.close();
	}

	public static void writeByte(String filepath) throws IOException{
		FileOutputStream out = new FileOutputStream(filepath);
		out.write('A');//写'A'的低八位
		out.write('B');//写'B'的低八位
		int a = 10;
//		out.write(a >>> 24);
//		out.write(a >>> 16);
//		out.write(a >>> 8);
		out.write(a);
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		out.close();
		IOUtil.printHex(filepath);
	}
	
	/**
	 * 文件拷贝，字节批量读写
	 * @param src
	 * @param dst
	 * @throws IOException
	 */
	public static void copyFile(File src, File dst) throws IOException{
		if(!src.exists()){
			throw new IllegalArgumentException("文件:"+ src + "不存在");
		}
		if(!src.isFile()){
			throw new IllegalArgumentException(src + "不是文件");
		}
		FileInputStream in = new FileInputStream(src);
		//dst若不存在，会自动创建
		FileOutputStream out = new FileOutputStream(dst);
		byte[] buf = new byte[8 * 1024];
		int bytes = 0;
		while((bytes = in.read(buf, 0, buf.length)) != -1){
			out.write(buf, 0, bytes);
			out.flush();
		}
		in.close();
		out.close();
	}
	
	/**
	 * 文件拷贝，字节缓冲流读取
	 * @param src
	 * @param dst
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File src, File dst) throws IOException{
		if(!src.exists()){
			throw new IllegalArgumentException("文件:"+ src + "不存在");
		}
		if(!src.isFile()){ 
			throw new IllegalArgumentException(src + "不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dst));
		int c;
		while((c = bis.read()) != -1){
			bos.write(c);
			bos.flush();
		}
		bis.close();
		bos.close();
	}
}
