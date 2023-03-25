/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author thiag
 */
public class NumericoIntUtil extends PlainDocument{
    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        // verifica se a string contém apenas dígitos
        if (str.matches("\\d+")) {
            super.insertString(offs, str, a);
        }
    }
}
