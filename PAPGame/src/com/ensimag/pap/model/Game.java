/**
 * 
 */
package com.ensimag.pap.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author truaro
 * 
 */
public class Game implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -5722781422189284911L;

	private int id;
	private List<Question> questions;
	private User user1;
	private User user2;
}
