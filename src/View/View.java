/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package View;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author ekard
 * @param <Type>
 */


 public interface View<Type> {
 public static void maximize(JFrame frm){
 frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
 }

 public static void showInternal(JDesktopPane desk,JInternalFrame frm){
 int desktopWidth = desk.getWidth();
 int desktopHeight = desk.getHeight();
 int internalFrameWidth = frm.getWidth();
 int internalFrameHeight = frm.getHeight();
 int x = (desktopWidth - internalFrameWidth) / 2;
 int y = (desktopHeight - internalFrameHeight) / 2;
 frm.setLocation(x, y);
 desk.add(frm);
 frm.setVisible(true);
 }
    void clear();
    void display(Type obj);
    void displayMessage(String message);
    boolean displayConfirmMessage(String message);
    void displayErrorMessage(String message);
}
