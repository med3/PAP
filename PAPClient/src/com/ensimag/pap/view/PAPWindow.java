/**
 * 
 */
package com.ensimag.pap.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ensimag.pap.controller.PAPWindowController;

/**
 * @author truaro
 * 
 */
public class PAPWindow extends JFrame {

	/** Serial ID */
	private static final long serialVersionUID = 906182131508377758L;
	private JPanel panel = new JPanel();
	private PAPWindowController controller;

	private JButton butIns, butCon, butFindOpp, butListGame;

	/**
	 * 
	 */
	public PAPWindow() {
		setSize(500, 500);
		setTitle("Duel Quizz lite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		panel.setLayout(new GridLayout(2, 2));

		initComponants();

		setContentPane(panel);
	}

	public void setController(PAPWindowController controller) {
		this.controller = controller;
	}

	private void initComponants() {
		butIns = new JButton("Inscription");
		butIns.addActionListener(new ButInscriptionListener());
		butCon = new JButton("Connection");
		butCon.addActionListener(new ButConnectionListener());
		butFindOpp = new JButton("Find opponents");
		butFindOpp.setEnabled(false);
		butListGame = new JButton("List old games");
		butListGame.setEnabled(false);

		panel.add(butIns);
		panel.add(butCon);
		panel.add(butFindOpp);
		panel.add(butListGame);
	}

	class ButInscriptionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.displayPAPInscription();
		}
	}

	class ButConnectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			controller.displayPAPConnection();
		}
	}
}
