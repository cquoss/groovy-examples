package de.quoss.groovy.example.checkcontent

class CheckContentException extends Exception {

    /**
     * Default serial version id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor with message.
     *  
     * @param msg Message. 
     */
    CheckContentException(String msg) {
        super(msg);
    }

}