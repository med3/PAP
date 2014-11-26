/**
 * 
 */
package com.ensimag.pap.model;

import java.io.Serializable;

/**
 * @author truaro
 * 
 */
public class UserAnswer implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -6150111063623012492L;

	private User user;
	private Game game;
	private Question question;
	private String answer;
}
