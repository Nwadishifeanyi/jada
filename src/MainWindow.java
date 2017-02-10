import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtTypeHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLabel = new JLabel("Label1");
		lblLabel.setBounds(10, 24, 136, 14);
		contentPane.add(lblLabel);
		
		
		txtTypeHere = new JTextField();
		txtTypeHere.setBounds(175, 21, 141, 20);
		txtTypeHere.setText("type here....*");
		contentPane.add(txtTypeHere);
		txtTypeHere.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(175, 75, 159, 20);
		contentPane.add(comboBox);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(215, 169, 89, 23);
		contentPane.add(btnOk);
	}
}
