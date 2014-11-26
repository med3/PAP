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

	/**
	 * @param mail
	 * @param password
	 */
	public User(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	/**
	 * @param id
	 * @param mail
	 * @param password
	 */
	public User(int id, String mail) {
		super();
		this.id = id;
		this.mail = mail;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the gamesPlayed
	 */
	public List<Game> getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @param gamesPlayed
	 *            the gamesPlayed to set
	 */
	public void setGamesPlayed(List<Game> gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", password=" + password
				+ ", gamesPlayed=" + gamesPlayed + "]";
	}

}
