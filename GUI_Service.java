/*
 * sxs135630
 * UI Assignment 2
 * 
 */

package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class GUI_Service {

	static BufferedReader br;
	BufferedWriter bw;
	
	// Read a file if exists, else create one
	public String Read_File() throws IOException
	{
		File f=new File("GUI.txt");
		String content;
		if(f.exists())
		{
			Scanner scan = new Scanner(f);  
			scan.useDelimiter("\\Z");  
			if(scan.hasNext()==true)
				content = scan.next(); 
			else content=null;
			scan.close();
		}
		else
		{	
			f.createNewFile();
			content=null;
		}
		
		return content;
	}
	
	//Write Edited text into file
	public static void Edit_Text(String content_info) throws IOException
	{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("GUI.txt", false)));
		out.println(content_info);
		out.close();
	}
	
	//Delete record from file, by writing new String
	public static void Delete_Text(String content, String info_content) throws IOException
	{
		String[] lines=info_content.split("\\r");
		if(lines[lines.length-1].trim().equals(content.trim())==true)
		{
			System.out.println("LAST LINE");
			RandomAccessFile f = new RandomAccessFile("GUI.txt", "rw");
			int length = (int) (f.length() - 1);
			do {                     
			  length = length - 1;
			  System.out.println(length);
			  f.seek(length);
			 // byte b = f.readByte();
			} while(f.readByte() != 10 && length>0);
			if(length==0) f.setLength(0);
			else f.setLength(length+1);
			
		}
		else
		{
			info_content=info_content.replace(content.trim(),"**");
			String info=info_content.substring(info_content.indexOf("**"),info_content.indexOf("**")+3);
			info_content=info_content.replace(info,"");
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("GUI.txt", false)));
			out.println(info_content);
			out.close();
		}
	}
	
	//Append to the file
	public static void Insert_File(String content) throws IOException
	{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("GUI.txt", true)));
		out.println(content);
		out.close();
	}
	
	// Returns true if the File contains atleast one line, else returns false
	public static boolean is_first_line() throws IOException {
		// TODO Auto-generated method stub
		br=new BufferedReader(new FileReader("GUI.txt"));
		if(br.readLine().equals(""))
			return true;
		
		return false;
	}
	
	//Writes a first line into the file
	public static void first_line_insert(String content) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile f = new RandomAccessFile("GUI.txt", "rw");
		f.setLength(0);
		f.writeChars(content);
		f.close();
	}
	
}
