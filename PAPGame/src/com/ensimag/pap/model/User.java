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
public class User implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = -4566853342146272583L;

	private int id;
	private String mail;
	private String password;
	private List<Game> gamesPlayed;

}
