/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_poo.exceptions;

/**
 *
 * @author User
 */
public class InvalidOperator extends Exception {

    /**
     * Creates a new instance of <code>InvalidOperator</code> without detail
     * message.
     */
    public InvalidOperator() {
    }

    /**
     * Constructs an instance of <code>InvalidOperator</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidOperator(String msg) {
        super(msg);
    }
}
