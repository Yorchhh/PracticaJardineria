package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Opciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Opciones frame = new Opciones();
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
	public Opciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¿Que desea hacer?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 11, 172, 28);
		contentPane.add(lblNewLabel);
		
		JButton botonCrearUsuario = new JButton("Cliente");
		botonCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CrearUsuario.main(null);
			}
		});
		botonCrearUsuario.setBounds(78, 156, 95, 44);
		contentPane.add(botonCrearUsuario);
		
		JButton btnNewButton = new JButton("Pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CrearPedido.main(null);
			}
		});
		btnNewButton.setBounds(252, 156, 95, 44);
		contentPane.add(btnNewButton);
		
		JButton botonPantallaPrincipal = new JButton("MENÚ PRINCIPAL");
		botonPantallaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PantallaPrincipal.main(null);
			}
		});
		botonPantallaPrincipal.setBounds(146, 70, 144, 33);
		contentPane.add(botonPantallaPrincipal);
	}
}
