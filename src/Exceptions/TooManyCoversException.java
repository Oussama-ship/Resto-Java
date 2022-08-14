/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Adrien
 */
public class TooManyCoversException extends Exception {

    private int couvert;
    
    /**
     * @return the couvert
     */
    public int getCouvert() {
        return couvert;
    }

    /**
     * @param couvert the couvert to set
     */
    public void setCouvert(int couvert) {
        this.couvert = couvert;
    }
    
    /**
     * Creates a new instance of <code>TooManyCoversException</code> without
     * detail message.
     */
    public TooManyCoversException() {
    }

    /**
     * Constructs an instance of <code>TooManyCoversException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TooManyCoversException(String msg) {
        super(msg);
    }
    
    public TooManyCoversException(int couvert) {
        this.couvert = couvert;
    }
}
