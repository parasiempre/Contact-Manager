/*
 * sxs135630
 * UI Assignment 2
 * 
 */

package GUI;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

// Table Model that is implemented by the JTable
public class Table_Model extends AbstractTableModel {

	
	ArrayList<Object[]> al;
	String[] columnNames ={"First Name","Middle Initials","Last Name","Phone Number"};
	
	// To initialize the Table Model contents
	public Table_Model(Object[][] obj)
	{
		al=new ArrayList<Object[]>();
		if(obj!=null)
		{
			for(int i=0;i<obj.length;i++)
				al.add(obj[i]);
		}
		
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return al.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return al.get(rowIndex)[columnIndex];
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
	    return false; // does not allowed to edit cells 
	}
	
	//Adds a new row to the content
	void add(String name, String MI, String Lastname, String phone)
	{
		
		String str[] = new String[4];
		str[0]=name;
		str[1]=MI;
		str[2]=Lastname;
		str[3]=phone;
		al.add(str);
		fireTableDataChanged();
		
		
	}
	
	//Clears the entire content of the Table Model
	void remove()
	{
		al.clear();
	}

	 @Override
	 public String getColumnName(int columnIndex) {
	  return columnNames[columnIndex];
	 }

	
}
