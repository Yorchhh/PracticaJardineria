package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class CrearPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textoIdCliente;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPedido frame = new CrearPedido();
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
	public CrearPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREAR NUEVO PEDIDO");
		lblNewLabel.setBounds(10, 0, 119, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo Pedido");
		lblNewLabel_1.setBounds(43, 41, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Creación Pedido");
		lblNewLabel_2.setBounds(43, 112, 155, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Entrega Pedido");
		lblNewLabel_3.setBounds(43, 185, 155, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Esperada Pedido");
		lblNewLabel_4.setBounds(274, 41, 150, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Id Cliente");
		lblNewLabel_5.setBounds(274, 112, 102, 14);
		contentPane.add(lblNewLabel_5);
		
		textoIdCliente = new JTextField();
		textoIdCliente.setBounds(274, 137, 86, 20);
		contentPane.add(textoIdCliente);
		textoIdCliente.setColumns(10);
		
		JButton cotonCrearPedido = new JButton("CREAR PEDIDO");
		cotonCrearPedido.setBounds(274, 209, 131, 23);
		contentPane.add(cotonCrearPedido);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Opciones.main(null);
			}
		});
		btnNewButton.setBounds(165, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setModel(new SpinnerDateModel(new Date(1606863600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_6.setBounds(43, 137, 108, 20);
		contentPane.add(spinner_6);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setModel(new SpinnerDateModel(new Date(1606863600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_9.setBounds(43, 210, 102, 20);
		contentPane.add(spinner_9);
		
		textField = new JTextField();
		textField.setBounds(43, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1606863600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(274, 66, 108, 20);
		contentPane.add(spinner);
	}
}
