/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package View;

/**
 *
 * @author ekard
 */
public interface View <Type>{
    void clear();
    void display(Type obj);
    void displayAll(Type[] objs);
    void displayMessage(String message);
    boolean displayConfirmMessage(String message);
    void displayErrorMessage(String message);
    // No necesariamente esto debe quedar así, se puede editar conforme a las necesidades.
}
