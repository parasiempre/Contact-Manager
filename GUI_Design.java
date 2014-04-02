 * sxs135630

package GUI;

import javax.swing.JFrame;

public class GUI_Design extends JFrame {
	
	//Declare the GUI Components
	public JTextField First_Name;
	public JLabel lblFirstName;
	public JTable table;
	public JScrollPane scroll;
	public JLabel lblMiddleInitial;
	public JTextField Middle_Initial;
	public JLabel lblLastName;
	public JTextField Last_Name;
	public JLabel lblAddressLine;
	public JTextField Address_Line_1;
	public JLabel lblAddressLine_1;
	public JLabel lblAddressLine_2;
	public JTextField Address_Line_2;
	public JLabel lblCity;
	public JTextField City;
	public JLabel lblState;
	public JTextField State;
	public JLabel lblZipCode;
	public JTextField Zip_Code;
	public JLabel lblPhoneNumber;
	public JTextField Phone_No;
	public JTextField Country;
	public JLabel lblEmail;
	public JTextField Email;
	public JPanel panel;
	public JButton btnInsert;
	public JButton btnDelete;
	public JLabel lblCountry;
	public JLabel lblcannotDeleteEntry;
	private JButton btnClear;
	public JLabel lblInsertEdit;
	public JPanel mainpanel;
	public Object[][] tab;
	public String[] columnNames = {"First Name","Middle Initials","Last Name","Phone Number"};
	public Table_Model tm;
	public boolean List_selection = false;
	// Constructor calla set_components() method to initialize components
	public GUI_Design() 
	{		
		set_components();	
	}
	
	//The window properties are set here 
	public void set_window()
	{
		setSize(800, 800);
		setTitle("Assignment 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	//Initialize Components
	private void set_components() {
		
		FlowLayout flowlayout=new FlowLayout();
		flowlayout.setAlignOnBaseline(true);
		getContentPane().setLayout(flowlayout);
		flowlayout.setAlignment(FlowLayout.CENTER);
		lblFirstName = new JLabel("First Name");
		First_Name = new JTextField();
		First_Name.setColumns(10);
		First_Name.setName("FirstName");
		First_Name.setDocument(new Text_Limit(20));

		panel = new JPanel();
		lblMiddleInitial = new JLabel("Middle Initial");
		
		Middle_Initial = new JTextField();
		Middle_Initial.setName("MI");
		Middle_Initial.setColumns(10);
		Middle_Initial.setDocument(new Text_Limit(1));
		
		lblLastName = new JLabel("Last Name");
		Last_Name = new JTextField();
		Last_Name.setColumns(10);
		Last_Name.setName("LastName");
		Last_Name.setDocument(new Text_Limit(20));
		
		JPanel infoPanel=new JPanel();
		infoPanel.setLayout(new GridLayout(1, 6));
		infoPanel.add(lblFirstName);
		infoPanel.add(First_Name);
		infoPanel.add(lblMiddleInitial);
		infoPanel.add(Middle_Initial);
		infoPanel.add(lblLastName);
		infoPanel.add(Last_Name);
		
		lblAddressLine_1 = new JLabel("Address Line 1");
		infoPanel.add(lblAddressLine_1);
		
		Address_Line_1 = new JTextField();
		infoPanel.add(Address_Line_1);
		Address_Line_1.setColumns(10);
		Address_Line_1.setName("AddressLine1");
		Address_Line_1.setDocument(new Text_Limit(35));
		
		lblAddressLine_2 = new JLabel("Address Line 2");
		infoPanel.add(lblAddressLine_2);
		
		Address_Line_2 = new JTextField();
		infoPanel.add(Address_Line_2);
		Address_Line_2.setColumns(10);
		Address_Line_2.setName("AddressLine2");
		Address_Line_2.setDocument(new Text_Limit(35));
		
		lblCity = new JLabel("City");
		infoPanel.add(lblCity);
		
		City = new JTextField();
		infoPanel.add(City);
		City.setColumns(10);
		City.setName("City");
		City.setDocument(new Text_Limit(25));
		
		lblState = new JLabel("State");
		infoPanel.add(lblState);
		
		State = new JTextField();
		infoPanel.add(State);
		State.setColumns(10);
		State.setName("State");
		State.setDocument(new Text_Limit(2));
		
		lblZipCode = new JLabel("Zip Code");
		infoPanel.add(lblZipCode);
		
		Zip_Code = new JTextField();
		infoPanel.add(Zip_Code);
		Zip_Code.setColumns(10);
		Zip_Code.setName("ZipCode");
		Zip_Code.setDocument(new Text_Limit(9));
		
		lblPhoneNumber = new JLabel("Phone No");
		infoPanel.add(lblPhoneNumber);
		
		Phone_No = new JTextField();
		infoPanel.add(Phone_No);
		Phone_No.setColumns(10);
		Phone_No.setName("PhoneNo");
		Phone_No.setDocument(new Text_Limit(21));
		
		lblCountry = new JLabel("Country");
		infoPanel.add(lblCountry);
		
		Country = new JTextField();
		infoPanel.add(Country);
		Country.setColumns(10);
		Country.setName("Country");
		Country.setDocument(new Text_Limit(30));
		
		
		lblEmail = new JLabel("Email Address");
		infoPanel.add(lblEmail);
		
		Email = new JTextField();
		infoPanel.add(Email);
		Email.setColumns(10);
		Email.setName("Email");
		Email.setDocument(new Text_Limit(100));
		
		GridLayout infolayout=new GridLayout(4,6);
		infolayout.setHgap(20);
		infolayout.setVgap(5);
		infoPanel.setLayout(infolayout);
		
		GridLayout buttonlayout=new GridLayout(2, 5);
		JPanel buttonpanel=new JPanel();
		buttonpanel.setLayout(buttonlayout);
		buttonlayout.setVgap(5);
		buttonlayout.setHgap(4);
		btnInsert = new JButton("Insert");
		btnInsert.setToolTipText("Inserts into the File");
		btnInsert.addActionListener(new ActionInsert());
		buttonpanel.add(btnInsert);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new DelListner());
		buttonpanel.add(btnDelete);
		
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ClearListner());
		buttonpanel.add(btnClear);
		
		mainpanel=new JPanel();
		BorderLayout bl=new BorderLayout();
		mainpanel.setLayout(bl);
		mainpanel.add(infoPanel,BorderLayout.CENTER);
		mainpanel.add(buttonpanel,BorderLayout.SOUTH);
		bl.setVgap(30);
		
		
		
		lblcannotDeleteEntry = new JLabel("*Cannot Delete, Entry does not exist");
		lblcannotDeleteEntry.setForeground(new Color(255, 0, 255));
		lblcannotDeleteEntry.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 16));
		lblcannotDeleteEntry.setVisible(false);
		buttonpanel.add(lblcannotDeleteEntry);
		
		
		
		lblInsertEdit = new JLabel("*Cannot be Null");
		lblInsertEdit.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 16));
		lblInsertEdit.setForeground(new Color(255, 20, 147));
		lblInsertEdit.setVisible(false);
		buttonpanel.add(lblInsertEdit);
		
		tab=null;
		
		tm=new Table_Model(tab);
		table=new JTable(tm);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int i=0;i<table.getColumnCount();i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
		
		scroll=new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(900, 500));
		table.addMouseListener(new Table_Mouse_Listner());
		table.setSize(100, 100);
		
		panel.add(scroll);
		mainpanel.add(panel,BorderLayout.NORTH);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setSize(600, 100);
		table.setPreferredSize(new Dimension(900, 500));
		
		getContentPane().add(mainpanel);
	
	}
	
	// Clear button implememts this listener
	public class ClearListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				clear();
				List_selection=false;
		}
	}
	
	//Sets the Textfields to empty fields
	public void clear()
	{
		First_Name.setText(""); First_Name.setEditable(true);
		Middle_Initial.setText(""); Middle_Initial.setEditable(true);
		Last_Name.setText(""); Last_Name.setEditable(true);
		Address_Line_1.setText(""); Address_Line_1.setEditable(true);
		Address_Line_2.setText(""); Address_Line_2.setEditable(true);
		City.setText(""); City.setEditable(true);
		State.setText(""); State.setEditable(true);
		Zip_Code.setText(""); Zip_Code.setEditable(true);
		Phone_No.setText(""); Phone_No.setEditable(true);
		Country.setText(""); Country.setEditable(true);
		Email.setText(""); Email.setEditable(true);
		lblInsertEdit.setVisible(false);
		List_selection=false;
		ClearListner_Color();
	}
	
	//Changes the backgroud colour of the text fields back to white
	public void ClearListner_Color()
	{
			// TODO Auto-generated method stub
				First_Name.setBackground(Color.WHITE);
				Middle_Initial.setBackground(Color.WHITE);
				Last_Name.setBackground(Color.WHITE);
				Address_Line_1.setBackground(Color.WHITE);
				City.setBackground(Color.WHITE);
				State.setBackground(Color.WHITE);
				Zip_Code.setBackground(Color.WHITE);
				Phone_No.setBackground(Color.WHITE);
				Country.setBackground(Color.WHITE);
				Email.setBackground(Color.WHITE);

		
	}

	// Populates the Text Fields when the JTable cell is clicked
	public  class Table_Mouse_Listner implements MouseListener {

	 	@Override
	 	public void mouseClicked(MouseEvent e) {
	 		// TODO Auto-generated method stub
	 		int col = table.getSelectedColumn();
 			int row = table.getSelectedRow();
 			
 			if(row>=0 && col>=0) 
 			{
 				String[] lines=GUI_Control.get_content_info().split("\\r");
 				String[] info=new String[11];
 				String[] info1=lines[row].split(";");
 				String line=null;
 				System.out.println("info1 length="+info1.length+" info length="+info.length);
 				for(int i=0;i<info1.length;i++)
 				{
 					info[i]=info1[i];
 				}
 				
 				for(int i=0;i<info.length-1;i++)
 				{
 					if(i==0)
 						line=info[i]+";";
 					else line=line+info[i]+";";
 				}
 				line=line+info[info.length-1];
 				GUI_Control.set_line(line);
 				First_Name.setText(info[0].trim());
 				Middle_Initial.setText(info[1].trim());
 				Last_Name.setText(info[2].trim());
 				Address_Line_1.setText(info[3].trim());
 				Address_Line_2.setText(info[4].trim());
 				City.setText(info[5].trim());
 				State.setText(info[6].trim());
 				Zip_Code.setText(info[7].trim());
 				Phone_No.setText(info[8].trim());
 				Country.setText(info[9].trim());
 				Email.setText(info[10].trim());
 				List_selection=true;
 			}

	 			
	 	}

	 	@Override
	 	public void mousePressed(MouseEvent e) {
	 		// TODO Auto-generated method stub
		 }

	 	@Override
	 	public void mouseReleased(MouseEvent e) {
	 		// TODO Auto-generated method stub
	 		
	 		
	 	}

	 	@Override
	 	public void mouseEntered(MouseEvent e) {
	 		// TODO Auto-generated method stub

	 	}

	 	@Override
	 	public void mouseExited(MouseEvent e) {
	 		// TODO Auto-generated method stub

	 	}

	 }
	
	//Action Listener for Delete Button
	public class DelListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				String content=First_Name.getText().trim()+";"+Middle_Initial.getText().trim()+";"+Last_Name.getText().trim()+";"+Address_Line_1.getText().trim()+";"+Address_Line_2.getText().trim()+";"+City.getText().trim()+";"+State.getText().trim()+";"+Zip_Code.getText().trim()+";"+Phone_No.getText().trim()+";"+Country.getText().trim()+";"+Email.getText().trim();
				String content_info=GUI_Control.get_content_info();
					try {
						if(content_info.contains(content.trim())==true)
						{	
							//content=content+"\\r";
							GUI_Service.Delete_Text(content,content_info);
							GUI_Control.get_Table();
						}
						else
						{
							lblcannotDeleteEntry.setVisible(true);
						}
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					catch(NullPointerException ne)
					{
						System.out.println("Nothing to Delete");
					}
					clear();
					lblcannotDeleteEntry.setVisible(false);
				
				}	
			

	}
	
	 //ActionListener to invoke the Insert service
	 public  class ActionInsert implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String content_info=GUI_Control.get_content_info();
			String line=GUI_Control.line;
			
			// If the selection is out of the Jtable, does into modify mode
			if(List_selection==true)
			{	
				GUI_Control.ValidateInsert_Null();
				if(GUI_Control.get_NullFlag()==0 )
				{
					String content=First_Name.getText().trim()+";"+Middle_Initial.getText().trim()+";"+Last_Name.getText().trim()+";"+Address_Line_1.getText().trim()+";"+Address_Line_2.getText().trim()+";"+City.getText().trim()+";"+State.getText().trim()+";"+Zip_Code.getText().trim()+";"+Phone_No.getText().trim()+";"+Country.getText().trim()+";"+Email.getText().trim();
					content_info=content_info.replace(line.trim(),content.trim());
					try {
						GUI_Service.Edit_Text(content_info);
						clear();
						lblInsertEdit.setVisible(false);
						List_selection=false;
						GUI_Control.get_Table();
					} catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
				
				
			} 
			// If it is not from the JTable, goes into insert mode
			else
			{
			String name=First_Name.getText().trim()+";"+Middle_Initial.getText().trim()+";"+Last_Name.getText().trim();
			String content=name+";"+Address_Line_1.getText()+";"+Address_Line_2.getText()+";"+City.getText()+";"+State.getText()+";"+Zip_Code.getText()+";"+Phone_No.getText()+";"+Country.getText().trim()+";"+Email.getText().trim();
			if(content_info!=null)
			{	if(content_info.contains(name)==false)
				{
				ClearListner_Color();
				GUI_Control.ValidateInsert_Null();
				if(GUI_Control.get_NullFlag()==0)
				{
					
					try {	
						System.out.println("gujygljgfuyfgluy");
						if(!GUI_Service.is_first_line())
							GUI_Service.Insert_File(content);
						else GUI_Service.first_line_insert(content);
						
						clear();
						lblInsertEdit.setVisible(false);
						List_selection=false;
						GUI_Control.get_Table();
						} 
					catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
				else
				{
					lblInsertEdit.setText("Record already Exists");
					lblInsertEdit.setVisible(true);
				}

			}
			else
				try {
					GUI_Control.ValidateInsert_Null();
					if(GUI_Control.get_NullFlag()==0)
					{
						GUI_Service.Insert_File(content);
						clear();
						GUI_Control.get_Table();
					}
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	
		}
			
	}
}

	
	
}
