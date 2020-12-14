/*
 * This is free to use in courses at University of Gävle.
 */
package lab3.main;
/**
 * Exception thrown when no data in Queue<V>
 * 
 * @author Anders Jackson
 * @version 2019-11-15
 */
public class QueueEmptyException extends RuntimeException {
	static final long serialVersionUID = 1;
			
	public QueueEmptyException() {
		super();
	}
	
	public QueueEmptyException(String message) {
        super(message);
    }
	
	public QueueEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public QueueEmptyException(Throwable cause) {
        super(cause);
    }
	
	protected QueueEmptyException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
