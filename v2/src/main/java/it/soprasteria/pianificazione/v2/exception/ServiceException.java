package it.soprasteria.pianificazione.v2.exception;

public class ServiceException extends Exception {

	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable th) {
		super(message, th);
	}
	
	public ServiceException(Throwable th) {
		super(th);
	}
}
