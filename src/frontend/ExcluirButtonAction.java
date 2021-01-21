package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import backend.AutoPecaController;
import models.AutoPeca;

public class ExcluirButtonAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Frame frame = new Frame(500, 240, "Excluir Peça");
		
		frame.setResizable(false);
		
		JPanel panelForm = new JPanel();
		JPanel panelButtons = new JPanel();
		
		Button buttonExcluir = new Button("Excluir", 18, Color.GREEN);
		Button buttonCancelar = new Button("Cancelar", 18, Color.RED);
		
		//Formulario
		panelForm.setLayout(null);
		JLabel titulo = new JLabel("Excluir peça");
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setSize(300, 30); 
		titulo.setLocation(150, 25);
		
		panelForm.add(titulo);
		
		//Campo codigo
        JLabel codigoLabel = new JLabel("Código: "); 
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        codigoLabel.setSize(100, 20); 
        codigoLabel.setLocation(110, 100); 
        panelForm.add(codigoLabel); 
        
        NumberFormat longFormat = NumberFormat.getIntegerInstance();

        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
        numberFormatter.setAllowsInvalid(false); //this is the key!!
        numberFormatter.setMinimum(0l); //Optional

        JFormattedTextField codigoTextField = new JFormattedTextField(numberFormatter);
        
        codigoTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        codigoTextField.setSize(190, 20); 
        codigoTextField.setLocation(200, 100); 
        panelForm.add(codigoTextField);
        //---------------------------
        
		//Alterando tamanhos
		buttonExcluir.setPreferredSize(new Dimension(150, 40));
		buttonCancelar.setPreferredSize(new Dimension(150, 40));
		panelButtons.setPreferredSize(new Dimension(800, 60));
		
		panelButtons.add(buttonExcluir);
		panelButtons.add(buttonCancelar);
		
		//Button actions
		buttonExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(codigoTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um código.", "Código inválido", 1);
					return;
				}
				
				int codigo = Integer.parseInt(codigoTextField.getText());
				
				boolean sucesso = AutoPecaController.excluirPeca(codigo);
				
				if(sucesso) JOptionPane.showMessageDialog(null, "Peça excluída com sucesso.", "Sucesso", 1);
				else {
					JOptionPane.showMessageDialog(null, "Nenhuma peça encontrada com o código informado.", "Não encontrado", 1);
					return;
				}
				
				frame.dispose();
				PanelData.updateTable();
			}
		});
		
		buttonCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		frame.add(panelForm, BorderLayout.CENTER);
		frame.add(panelButtons, BorderLayout.SOUTH);
		
	}
}
