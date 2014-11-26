/**
 * 
 */
package com.ensimag.pap.model;

import java.io.Serializable;

/**
 * @author truaro
 * 
 */
public class Question implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = 1112150860240791193L;

	private int id;
	private String theme;
	private String value;
	private String proposition1;
	private String proposition2;
	private String proposition3;
	private String proposition4;
	private String answer;

}
