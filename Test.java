package scandir;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test extends JFrame {

	private JPanel contentPane;
	private Noeud base;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnChoisir = new JButton("Choisir");
		panel.add(btnChoisir);
		
		JButton btnFermer = new JButton("Fermer");
		panel.add(btnFermer);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrResultat = new JTextArea();
		scrollPane.setViewportView(txtrResultat);
		
		btnChoisir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal;
				File nom;
	    		JFileChooser fileChooser = new JFileChooser();
	    		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			    returnVal = fileChooser.showOpenDialog(null);
			    if (returnVal == JFileChooser.APPROVE_OPTION) {   
			    	nom = new File(fileChooser.getSelectedFile().getPath());
			    	base = new Repertoire(null, nom);
			    	txtrResultat.setText(base.toString());
	    		}
			}
		});
		
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}