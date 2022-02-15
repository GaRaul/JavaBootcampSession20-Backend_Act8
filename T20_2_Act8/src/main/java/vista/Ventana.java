package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

/**
 * autor: Abel, Edgar, Raul 
 * Fecha modificacion: 15/02/2022
 */

@SuppressWarnings("serial")
public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField tfCantidad;
	private JTextField areaResultado;

	/**
	 * Launch the application.
	 */
	public static void vista() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCantidad = new JLabel("Cantidad a convertir");
		lblCantidad.setBounds(54, 28, 119, 14);
		contentPane.add(lblCantidad);

		JLabel lblResultadoEtiqueta = new JLabel("Resultado");
		lblResultadoEtiqueta.setBounds(281, 28, 72, 14);
		contentPane.add(lblResultadoEtiqueta);

		tfCantidad = new JTextField();
		tfCantidad.setBounds(169, 25, 102, 20);
		contentPane.add(tfCantidad);
		tfCantidad.setColumns(10);

		JButton btnConvertir = new JButton("Euros a ptas");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					double cantidad = Double.valueOf(tfCantidad.getText());
					double resultado;
					if (btnConvertir.getText().equals("Euros a ptas")) {
						resultado = cantidad * 166.386;

					} else {
						resultado = cantidad / 166.386;

					}
			    
			        String pattern = "#.###";
			        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
			        String formattedDouble = decimalFormat.format(resultado);
			        
					areaResultado.setText(formattedDouble);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Introduce un valor valido");
				}
			}
		});

		btnConvertir.setBounds(54, 69, 151, 23);
		contentPane.add(btnConvertir);

		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnConvertir.getText().equals("Euros a ptas")) {
					btnConvertir.setText("Ptas a Euros");
				} else {
					btnConvertir.setText("Euros a ptas");
				}
			}
		});

		btnCambiar.setBounds(264, 69, 89, 23);
		contentPane.add(btnCambiar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCantidad.setText("");
				areaResultado.setText("");
			}
		});
		btnBorrar.setBounds(363, 69, 89, 23);
		contentPane.add(btnBorrar);
		
		areaResultado = new JTextField();
		areaResultado.setColumns(10);
		areaResultado.setBounds(340, 25, 112, 20);
		contentPane.add(areaResultado);
	}
}
