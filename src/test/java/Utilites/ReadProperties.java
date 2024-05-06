package Utilites;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class ReadProperties{
	public static  Properties properties;
	public static final String filePath = System.getProperty("user.dir")+File.separatorChar+"src\\test\\resources"+File.separatorChar+"TestData";;
	//public static void main(String[]agrs) throws IOException {
	public void getFile() throws IOException {
		properties=new Properties();
		FileInputStream fpro=new FileInputStream(filePath);
		properties.load(fpro);
		System.out.println(properties.get("URL"));
	}
	
}
