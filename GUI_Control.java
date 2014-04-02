 * sxs135630

package GUI;

import java.awt.Color;


public class GUI_Control {

	static GUI_Design desg;
	static GUI_Service serv;
	static public String content_info;
	static String line;
	static int Flag_Null=0;
	static int Flag_Len=0;
	
	// Constructor to initialize the UI and Service objects
	public GUI_Control() throws IOException
	{
		serv=new GUI_Service();
		desg=new GUI_Design();
		get_Table();
		desg.set_window();
	}
	
	//Validates for Null fields
	public static void ValidateInsert_Null()
	{
			// TODO Auto-generated method stub
			desg.ClearListner_Color();
			Flag_Null=0;
			if(desg.First_Name.getText().equals("")==true)
			{
				desg.First_Name.setBackground(Color.PINK);
				Flag_Null=1;
			}
			
			if(desg.Last_Name.getText().equals("")==true)
			{
				desg.Last_Name.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(desg.Address_Line_1.getText().equals("")==true)
			{
				desg.Address_Line_1.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(desg.City.getText().equals("")==true)
			{
				desg.City.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(desg.Phone_No.getText().equals("")==true)
			{
				desg.Phone_No.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(desg.Zip_Code.getText().equals("")==true)
			{
				desg.Zip_Code.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(desg.State.getText().equals("")==true)
			{
				desg.State.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(desg.Country.getText().equals("")==true)
			{
				desg.Country.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(desg.Email.getText().equals("")==true)
			{
				desg.Email.setBackground(Color.PINK);
				Flag_Null=1;
			}
			if(Flag_Null==1)
			{
				desg.lblInsertEdit.setVisible(true);
				desg.lblInsertEdit.setText("*Cannot be Null");
			}
			
		

	}
	
	 //To generate the JTable
	public static  void get_Table() throws IOException {
		// TODO Auto-generated method stub
		String content=serv.Read_File();
		content_info=content;
		if(content!=null)
		{
			System.out.println("inside get table");
			String[] line=content.split("\\r");
			String[][] info = new String[line.length][10];
		
			for(int i=0;i<line.length;i++)
			{
				if(line[i].contains(";"))
					info[i]=line[i].split(";");
				else info[i][0]=line[i];
			
			}
			System.out.println("info[0][0]="+info[0][0]);
			desg.tm.remove();
			if(info[0].length>10)
			{
				System.out.println("info length="+(info.length));
				System.out.println("i=="+1+info[0][0]+"," +info[0][1]+","+ info[0][2]+","+ info[0][8].trim());
				for(int i=0;i<info.length;i++)
				{	//System.out.println("i=="+i+info[i][0]+"," +info[i][1]+","+ info[i][2]+","+ info[i][8].trim());
					desg.tm.add(info[i][0], info[i][1], info[i][2], info[i][8].trim());
				}
			}
			}
		else desg.tm.remove();
		
		desg.table.updateUI();
	}
	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		GUI_Control cont=new GUI_Control();
		
	}

	// Returns the line field
	public static void set_line(String line2) {
		// TODO Auto-generated method stub
		line=line2;
	}
	// Returns the content_info field
	public static String get_content_info() {
		// TODO Auto-generated method stub
		return content_info;
	}
	//Returns the Flag_Null field
	public static int get_NullFlag() {
		// TODO Auto-generated method stub
		return Flag_Null;
	}
	 

}

