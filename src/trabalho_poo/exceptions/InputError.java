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
public class InputError extends Exception {

    /**
     * Creates a new instance of <code>InputError</code> without detail message.
     */
    public InputError() {
    }

    /**
     * Constructs an instance of <code>InputError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InputError(String msg) {
        super(msg);
    }
}
