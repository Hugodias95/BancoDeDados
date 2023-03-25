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

public class NumericoFloatUtil extends PlainDocument{
    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        // verifica se a string contém apenas dígitos ou um ponto decimal
        if (str.matches("[0-9]*\\.?[0-9]{1}")) {
            super.insertString(offs, str, a);
        }
    }
}
