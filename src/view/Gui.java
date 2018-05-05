package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField tFCantidadEstaciones;
	private JTextField tFAltoPista;
	private JTextField tFAnchoPista;
	private JTextField tFCantidadViajes;
	private JTextField tFTiempoSimulacion;
	private JTextField tFHoraSegundos;
	private JTextField tFPistasEstacion;	

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
		setBounds(100, 100, 301, 386);
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
		
		ArrayList<JTextField> textFields = new ArrayList<>();
		
		tFCantidadEstaciones = new JTextField("6");
		tFCantidadEstaciones.setBounds(143, 8, 86, 20);
		contentPane.add(tFCantidadEstaciones);
		tFCantidadEstaciones.setColumns(10);
		textFields.add(tFCantidadEstaciones);
		
		tFAltoPista = new JTextField("500");
		tFAltoPista.setColumns(10);
		tFAltoPista.setBounds(143, 33, 86, 20);
		contentPane.add(tFAltoPista);
		textFields.add(tFAltoPista);
		
		tFAnchoPista = new JTextField("200");
		tFAnchoPista.setColumns(10);
		tFAnchoPista.setBounds(143, 58, 86, 20);
		contentPane.add(tFAnchoPista);
		textFields.add(tFAnchoPista);
		
		tFCantidadViajes = new JTextField("100");
		tFCantidadViajes.setColumns(10);
		tFCantidadViajes.setBounds(143, 83, 86, 20);
		contentPane.add(tFCantidadViajes);
		textFields.add(tFCantidadViajes);
		
		tFTiempoSimulacion = new JTextField("120");
		tFTiempoSimulacion.setColumns(10);
		tFTiempoSimulacion.setBounds(143, 108, 86, 20);
		contentPane.add(tFTiempoSimulacion);
		textFields.add(tFTiempoSimulacion);
		
		tFHoraSegundos = new JTextField("6");
		tFHoraSegundos.setColumns(10);
		tFHoraSegundos.setBounds(143, 133, 86, 20);
		contentPane.add(tFHoraSegundos);
		textFields.add(tFHoraSegundos);
		
		tFPistasEstacion = new JTextField("2");
		tFPistasEstacion.setColumns(10);
		tFPistasEstacion.setBounds(143, 158, 86, 20);
		contentPane.add(tFPistasEstacion);
		textFields.add(tFPistasEstacion);
		
		JRadioButton rdbtnBacktraking = new JRadioButton("Backtraking");
		rdbtnBacktraking.setBounds(10, 207, 140, 23);
		contentPane.add(rdbtnBacktraking);
		
		JRadioButton rdbtnDidiveYConquista = new JRadioButton("Didive y Conquista");
		rdbtnDidiveYConquista.setBounds(10, 233, 140, 23);
		contentPane.add(rdbtnDidiveYConquista);
		
		JRadioButton rdbtnProbabilistico = new JRadioButton("Probabilistico");
		rdbtnProbabilistico.setBounds(10, 259, 140, 23);
		contentPane.add(rdbtnProbabilistico);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnBacktraking);
		group.add(rdbtnDidiveYConquista);
		group.add(rdbtnProbabilistico);
		
		rdbtnBacktraking.setActionCommand("backtraking");
		rdbtnDidiveYConquista.setActionCommand("divideconquista");
		rdbtnProbabilistico.setActionCommand("probabilistico");
		
		JLabel lblNope = new JLabel("NOPE");
		lblNope.setEnabled(true);
		lblNope.setForeground(Color.RED);
		lblNope.setHorizontalAlignment(SwingConstants.CENTER);
		lblNope.setBounds(163, 186, 46, 14);
		lblNope.setVisible(false);
		contentPane.add(lblNope);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean allMarked = true;
				for(JTextField tf : textFields)
				{
					if(tf.getText().isEmpty())
					{
						allMarked = false;
					}
				}
				if(allMarked && Integer.parseInt(tFCantidadEstaciones.getText()) <= 30 && Integer.parseInt(tFAltoPista.getText()) <= 500 &&
						(rdbtnBacktraking.isSelected() || rdbtnDidiveYConquista.isSelected() || rdbtnProbabilistico.isSelected()))
				{	
					try
					{
						int cantidadEstaciones = Integer.parseInt(tFCantidadEstaciones.getText());
						int altoPista = Integer.parseInt(tFAltoPista.getText());
						int anchoPista = Integer.parseInt(tFAnchoPista.getText());
						int cantidadViajes = Integer.parseInt(tFCantidadViajes.getText());
						int tiempoSimulacion = Integer.parseInt(tFTiempoSimulacion.getText());
						int horaSegundos = Integer.parseInt(tFHoraSegundos.getText());
						int pistasEstacion = Integer.parseInt(tFPistasEstacion.getText());
						
						String selection = group.getSelection().getActionCommand();
						
						System.out.println(selection);
					}
					catch(Exception ex)
					{
						lblNope.setVisible(true);
					}					
				}
			}
		});
		btnSiguiente.setBounds(91, 313, 89, 23);
		contentPane.add(btnSiguiente);				
	}	
}
