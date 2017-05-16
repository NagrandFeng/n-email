/**
 * 
 */
package com.nagrand.email.excute;

/**
 * @author Nagrand
 */
public class SendEmailException extends Exception {
	private static final long serialVersionUID = 3825121815093565160L;

	public SendEmailException() {
		super();
	}

	public SendEmailException(String msg) {
		super(msg);
	}

	public SendEmailException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SendEmailException(Throwable cause) {
		super(cause);
	}
}
