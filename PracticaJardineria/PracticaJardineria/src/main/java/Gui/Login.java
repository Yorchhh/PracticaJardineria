package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Builder.ClienteDaoBuilder;
import Builder.PedidoDaoBuilder;
import Dao.ClienteDao;
import Dao.PedidoDao;
import Excepciones.DuplicityException;
import Excepciones.EmailException;
import Excepciones.IdException;
import Excepciones.SurnamePhoneException;
import Excepciones.codigoPedidoDuplicityException;
import Excepciones.codigoPedidoException;
import Excepciones.dniException;
import Excepciones.fechaEsperadaException;
import Excepciones.fechaException;
import Excepciones.idClientePedidoException;
import Excepciones.nieException;
import Model.Cliente;
import Model.Pedido;
import Model.tipoDocumento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Login extends JFrame {
	static List<Cliente> clientes = new ArrayList<Cliente>();
	static ClienteDao clienteDao = new ClienteDao(clientes);
	static List<Pedido> pedidos = new ArrayList<Pedido>();
	static PedidoDao pedidoDao = new PedidoDao(pedidos);

	private JPanel contentPane;
	private JTextField textoUsuario;
	private JPasswordField textContraseña;

	/**
	 * Launch the application.
	 * @throws idClientePedidoException 
	 * @throws codigoPedidoException 
	 * @throws fechaEsperadaException 
	 * @throws fechaException 
	 */
	public static void main(String[] args) throws fechaException, fechaEsperadaException, codigoPedidoException, idClientePedidoException {
		Cliente c1,c2;
		
		try {
			
			c1 = ClienteDaoBuilder.build(1, "Jorge", "Martinez", "68616676",null, null, "jmaritnez@gmail.com", "jmartinez", "73017762N", tipoDocumento.DNI);
			clienteDao.guardar(c1);
			c2=ClienteDaoBuilder.build(2, "Alfonso", "Perez", "652478965", "Pedrola", "140001", "aperez@gmail.com", "apez", "F2578942N", tipoDocumento.NIE);
			clienteDao.guardar(c2);
		} catch (IdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DuplicityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SurnamePhoneException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (dniException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (nieException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Pedido p1,p2;
		try {
			p1=PedidoDaoBuilder.build(1, new Date(120,11,2), new Date(120,11,4), 1, new Date(120,11,2));
			pedidoDao.guardar(p1);
			p2= PedidoDaoBuilder.build(2, new Date(120,11,2), new Date(120,11,3), 2, new Date(120,11,2));
			pedidoDao.guardar(p2);
			
		} catch (codigoPedidoDuplicityException e) {
			// TODO: handle exception
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(50, 70, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(50, 140, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esValido=false;
				for (Cliente cliente : clientes) {
					if(cliente.getNombreCliente().equals(textoUsuario.getText()) && cliente.getContraseña().equals(textContraseña.getText())) {
						esValido=true;
						dispose();//Se cierra la ventana al introducir datos
						Opciones.main(null);
					}
					if(esValido==false){
						
						
					}
				}
			}
		});
		btnNewButton.setBounds(317, 109, 89, 23);
		contentPane.add(btnNewButton);
		
		textoUsuario = new JTextField();
		textoUsuario.setBounds(141, 67, 99, 20);
		contentPane.add(textoUsuario);
		textoUsuario.setColumns(10);
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(141, 136, 99, 23);
		contentPane.add(textContraseña);
		
		JCheckBox verContraseña = new JCheckBox("Ver");
		verContraseña.setBounds(50, 161, 99, 49);
		contentPane.add(verContraseña);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
