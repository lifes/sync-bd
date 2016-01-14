package com.hikvision.syncbd.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhuaming 2016-1-11
 * 
 */
public class FileUtil {
	public static File[] getFilesOnDirectoryNotIncludeFolder(
			String directoryPath) {
		File base = new File(directoryPath);
		File[] files = base.listFiles();
		List<File> list = new ArrayList<File>();
		for (File f : files) {
			if (!f.isDirectory()) {
				list.add(f);
			}
		}
		return list.toArray(new File[0]);
	}
	public static boolean del(File file){
		return file.delete();
	}
}
