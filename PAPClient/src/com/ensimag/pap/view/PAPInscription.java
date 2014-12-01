/**
 * 
 */
package com.ensimag.pap.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ensimag.pap.controller.PAPWindowController;
import com.ensimag.pap.model.User;

/**
 * @author truaro
 * 
 */
public class PAPInscription extends JDialog {

	private JPanel panel = new JPanel();
	private PAPWindowController controller;

	private JTextField pseudoTF = new JTextField();
	private JLabel pseudoL = new JLabel("Enter your pseudo : ");

	private JTextField passwordTF = new JTextField();
	private JLabel passwordL = new JLabel("Enter your password : ");

	protected JButton butIns = new JButton("Register");

	public PAPInscription() {
		setTitle("Inscription");
		setModal(true);
		setResizable(false);
		setSize(300, 300);

		initComponants();

		setContentPane(panel);
	}

	private void initComponants() {
		panel.setLayout(new GridLayout(3, 2));

		butIns.addActionListener(new ButInscriptionListener());

		panel.add(pseudoL);
		panel.add(pseudoTF);
		panel.add(passwordL);
		panel.add(passwordTF);
		panel.add(butIns);
	}

	public void setController(PAPWindowController controller) {
		this.controller = controller;
	}

	class ButInscriptionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			User u = new User(pseudoTF.getText(), passwordTF.getText());
			controller.registerUser(u);
		}
	}
}
