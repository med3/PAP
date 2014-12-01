/**
 * 
 */
package com.ensimag.pap.controller;

import com.ensimag.pap.model.User;
import com.ensimag.pap.view.PAPConnection;
import com.ensimag.pap.view.PAPInscription;
import com.ensimag.pap.view.PAPWindow;

/**
 * @author truaro
 * 
 */
public class PAPWindowController {

	private PAPWindow papWindow = new PAPWindow();
	private PAPInscription papInscription = new PAPInscription();
	private PAPConnection papConnection = new PAPConnection();
	private User user;

	public void displayPAPWindow() {
		papWindow.setController(this);
		papWindow.setVisible(true);
	}

	public void displayPAPInscription() {
		papInscription.setController(this);
		papInscription.setVisible(true);
	}

	public void displayPAPConnection() {
		papConnection.setController(this);
		papConnection.setVisible(true);
	}

	public void registerUser(User u) {
		// TODO : call TCP to register user
		System.out.println("Register : " + u);
		papInscription.dispose();
	}

	public void connectUser(User u) {
		// TOTO : call TCP to connect user
		System.out.println("Connect : " + u);
		papConnection.dispose();
	}
}
