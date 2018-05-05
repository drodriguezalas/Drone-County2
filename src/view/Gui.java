package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidadDeEstaciones = new JLabel("Cantidad de estaciones:");
		lblCantidadDeEstaciones.setBounds(10, 11, 123, 14);
		contentPane.add(lblCantidadDeEstaciones);
		
		JLabel lblAltoDePista = new JLabel("Alto de pista:");
		lblAltoDePista.setBounds(10, 36, 123, 14);
		contentPane.add(lblAltoDePista);
		
		JLabel lblAnchoDePista = new JLabel("Ancho de pista:");
		lblAnchoDePista.setBounds(10, 61, 123, 14);
		contentPane.add(lblAnchoDePista);
		
		JLabel lblCantidadDeViajes = new JLabel("Cantidad de viajes:");
		lblCantidadDeViajes.setBounds(10, 86, 123, 14);
		contentPane.add(lblCantidadDeViajes);
		
		JLabel lblTiempoDeSimulacin = new JLabel("Tiempo de simulaci\u00F3n:");
		lblTiempoDeSimulacin.setBounds(10, 111, 123, 14);
		contentPane.add(lblTiempoDeSimulacin);
		
		JLabel lblHoraEn = new JLabel("1 hora en segundos:");
		lblHoraEn.setBounds(10, 136, 123, 14);
		contentPane.add(lblHoraEn);
		
		JLabel lblPistasPorEstacin = new JLabel("Pistas por estaci\u00F3n:");
		lblPistasPorEstacin.setBounds(10, 161, 123, 14);
		contentPane.add(lblPistasPorEstacin);
		
		JLabel lblAlgoritmoAUtilizar = new JLabel("Algoritmo a utilizar:");
		lblAlgoritmoAUtilizar.setBounds(10, 186, 123, 14);
		contentPane.add(lblAlgoritmoAUtilizar);
		
		textField = new JTextField();
		textField.setBounds(143, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 33, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 58, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 83, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(143, 108, 86, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(143, 133, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(143, 158, 86, 20);
		contentPane.add(textField_6);
		
		JButton btnBacktraking = new JButton("Backtraking");
		btnBacktraking.setBounds(10, 211, 123, 23);
		contentPane.add(btnBacktraking);
		
		JButton btnDivideConquer = new JButton("Divide y venceras");
		btnDivideConquer.setBounds(10, 245, 123, 23);
		contentPane.add(btnDivideConquer);
		
		JButton btnProbabilistic = new JButton("Probabilista");
		btnProbabilistic.setBounds(10, 279, 123, 23);
		contentPane.add(btnProbabilistic);
	}
}
