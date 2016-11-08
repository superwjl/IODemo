package com.tik.io;

import java.io.File;
import java.io.IOException;

public class FileUtils {

	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录:"+dir+"不存在.");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir+"不是目录.");
		}
		/*
		String[] filenames = dir.list();
		for (String string : filenames) {
			System.out.println(dir + "\\" + string);
		}
		*/
		File[] files = dir.listFiles();
		if(files != null && files.length > 0){
			for (File file : files) {
				if(file.isDirectory()){
					listDirectory(file);
				}else{
					System.out.println(file);
				}
			}
		}
		
	}
	
}
