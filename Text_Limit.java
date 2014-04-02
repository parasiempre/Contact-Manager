
package GUI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// To restrict the Text field to a limit
class Text_Limit extends PlainDocument {
	 private int limit;
	  Text_Limit(int limit) {
	   super();
	   this.limit = limit;
	 }

	 Text_Limit(int limit, boolean upper) {
	   super();
	   this.limit = limit;
	 }

	 public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	   if (str == null)
	     return;

	   if ((getLength() + str.length()) <= limit) {
	     super.insertString(offset, str, attr);
	   }
	 }
	}

