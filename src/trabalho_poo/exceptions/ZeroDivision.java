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
public class ZeroDivision extends Exception {

    /**
     * Creates a new instance of <code>ZeroDivision</code> without detail
     * message.
     */
    public ZeroDivision() {
    }

    /**
     * Constructs an instance of <code>ZeroDivision</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ZeroDivision(String msg) {
        super(msg);
    }
}
