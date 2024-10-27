package Elements;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
	
	/**
	 * JTextFieldLimit.java
	 * 
	 * Limite le nombre de caractère autorisé
	 * Passe en majuscul la chaine de caratère
	 * 
	 * Copyright (c) 2017 Sébastien Drillaud
	 * All Rights Reserved.
	 */

	private static final long serialVersionUID = 1L;
	
	private int limit;

JTextFieldLimit(int limit) {
    super();
    this.limit = limit;
}

JTextFieldLimit(int limit, boolean upper) {
    super();
    this.limit = limit;
}

@Override
public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
    return;

    if ((getLength() + str.length()) <= limit) {
    	
    super.insertString(offset, str.toUpperCase(), attr);
    }
}
}

