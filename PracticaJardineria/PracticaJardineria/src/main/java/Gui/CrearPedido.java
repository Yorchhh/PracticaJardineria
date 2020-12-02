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

public class CrearPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textoCodigoPedido;
	private JTextField textoFechaPedido;
	private JTextField textoFechaEntrega;
	private JTextField textoFechaEsperada;
	private JTextField textoIdCliente;

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
		
		textoCodigoPedido = new JTextField();
		textoCodigoPedido.setBounds(43, 66, 86, 20);
		contentPane.add(textoCodigoPedido);
		textoCodigoPedido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Creación Pedido");
		lblNewLabel_2.setBounds(43, 112, 155, 14);
		contentPane.add(lblNewLabel_2);
		
		textoFechaPedido = new JTextField();
		textoFechaPedido.setBounds(43, 137, 86, 20);
		contentPane.add(textoFechaPedido);
		textoFechaPedido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Entrega Pedido");
		lblNewLabel_3.setBounds(43, 185, 155, 14);
		contentPane.add(lblNewLabel_3);
		
		textoFechaEntrega = new JTextField();
		textoFechaEntrega.setBounds(43, 210, 86, 20);
		contentPane.add(textoFechaEntrega);
		textoFechaEntrega.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Esperada Pedido");
		lblNewLabel_4.setBounds(274, 41, 150, 14);
		contentPane.add(lblNewLabel_4);
		
		textoFechaEsperada = new JTextField();
		textoFechaEsperada.setBounds(274, 66, 86, 20);
		contentPane.add(textoFechaEsperada);
		textoFechaEsperada.setColumns(10);
		
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
	}
}
