package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textoId;
	private JTextField textoNombre;
	private JTextField textoApellidos;
	private JTextField textoCiudad;
	private JTextField textoTlf;
	private JTextField textoCodigoPostal;
	private JTextField textoEmail;
	private JTextField textoContraseña;
	private JTextField textoDocumento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario();
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
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREAR NUEVO CLIENTE");
		lblNewLabel.setBounds(10, 11, 122, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Cliente");
		lblNewLabel_1.setBounds(10, 62, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 103, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setBounds(10, 153, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono");
		lblNewLabel_4.setBounds(10, 208, 57, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ciudad");
		lblNewLabel_5.setBounds(233, 62, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("C.P.");
		lblNewLabel_6.setBounds(233, 103, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setBounds(233, 153, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Contraseña");
		lblNewLabel_8.setBounds(210, 208, 82, 14);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("DNI");
		rdbtnNewRadioButton.setBounds(138, 13, 46, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NIE");
		rdbtnNewRadioButton_1.setBounds(210, 13, 46, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Documento");
		lblNewLabel_9.setBounds(262, 17, 79, 14);
		contentPane.add(lblNewLabel_9);
		
		textoId = new JTextField();
		textoId.setBounds(66, 59, 86, 20);
		contentPane.add(textoId);
		textoId.setColumns(10);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(66, 100, 86, 20);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		
		textoApellidos = new JTextField();
		textoApellidos.setBounds(66, 150, 86, 20);
		contentPane.add(textoApellidos);
		textoApellidos.setColumns(10);
		
		textoCiudad = new JTextField();
		textoCiudad.setBounds(289, 59, 86, 20);
		contentPane.add(textoCiudad);
		textoCiudad.setColumns(10);
		
		textoTlf = new JTextField();
		textoTlf.setBounds(66, 205, 86, 20);
		contentPane.add(textoTlf);
		textoTlf.setColumns(10);
		
		textoCodigoPostal = new JTextField();
		textoCodigoPostal.setBounds(289, 100, 86, 20);
		contentPane.add(textoCodigoPostal);
		textoCodigoPostal.setColumns(10);
		
		textoEmail = new JTextField();
		textoEmail.setBounds(289, 150, 86, 20);
		contentPane.add(textoEmail);
		textoEmail.setColumns(10);
		
		textoContraseña = new JTextField();
		textoContraseña.setBounds(289, 205, 86, 20);
		contentPane.add(textoContraseña);
		textoContraseña.setColumns(10);
		
		JButton btnNewButton = new JButton("CREAR CLIENTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(158, 233, 134, 23);
		contentPane.add(btnNewButton);
		
		textoDocumento = new JTextField();
		textoDocumento.setBounds(325, 14, 86, 20);
		contentPane.add(textoDocumento);
		textoDocumento.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Opciones.main(null);
			}
		});
		btnNewButton_1.setBounds(32, 233, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
