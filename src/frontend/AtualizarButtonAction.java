package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AtualizarButtonAction implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
Frame frame = new Frame(600, 540, "Atualizar Peça");
		
		frame.setResizable(false);
		
		JPanel panelForm = new JPanel();
		JPanel panelButtons = new JPanel();
		
		Button buttonAtualizar = new Button("Atualizar", 18, Color.GREEN);
		Button buttonCancelar = new Button("Cancelar", 18, Color.RED);
		Button buttonProcurar = new Button("Procurar", 18, Color.ORANGE);
		
		//Formulario
		panelForm.setLayout(null);
		JLabel titulo = new JLabel("Atualizar Peça");
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setSize(300, 30); 
		titulo.setLocation(170, 30);
		
		panelForm.add(titulo);
		
		//Campo codigo
        JLabel codigoLabel = new JLabel("Código: "); 
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        codigoLabel.setSize(100, 20); 
        codigoLabel.setLocation(120, 100); 
        panelForm.add(codigoLabel); 
        
        NumberFormat longFormat = NumberFormat.getIntegerInstance();

        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Long.class);
        numberFormatter.setAllowsInvalid(false);

        JFormattedTextField codigoTextField = new JFormattedTextField(numberFormatter);
        
        codigoTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        codigoTextField.setSize(190, 20); 
        codigoTextField.setLocation(200, 100); 
        panelForm.add(codigoTextField);
        //---------------------------
		
		//Campo nome
        JLabel nomeLabel = new JLabel("Nome: "); 
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nomeLabel.setSize(100, 20); 
        nomeLabel.setLocation(130, 140); 
        panelForm.add(nomeLabel); 
  
        JTextField nomeTextField = new JTextField(); 
        nomeTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        nomeTextField.setSize(190, 20); 
        nomeTextField.setLocation(200, 140); 
        panelForm.add(nomeTextField);
        //---------------------------
        
        //Campo preço
        JLabel precoLabel = new JLabel("Preço: "); 
        precoLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        precoLabel.setSize(100, 20); 
        precoLabel.setLocation(130, 180); 
        panelForm.add(precoLabel); 
  
        JTextField precoTextField = new JTextField(); 
        precoTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        precoTextField.setSize(190, 20); 
        precoTextField.setLocation(200, 180); 
        panelForm.add(precoTextField);
        //----------------------------
        
        //Campo quantidade
        JLabel qtdLabel = new JLabel("Qtd: "); 
        qtdLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        qtdLabel.setSize(100, 20); 
        qtdLabel.setLocation(150, 220); 
        panelForm.add(qtdLabel); 
  
        JTextField qtdTextField = new JTextField(); 
        qtdTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        qtdTextField.setSize(190, 20); 
        qtdTextField.setLocation(200, 220); 
        panelForm.add(qtdTextField);
        //----------------------------
        
        //Campo descrição
        JLabel descricaoLabel = new JLabel("Descrição: "); 
        descricaoLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        descricaoLabel.setSize(100, 20); 
        descricaoLabel.setLocation(95, 260); 
        panelForm.add(descricaoLabel); 
        
        JTextArea descricaoTextArea = new JTextArea(); 
        descricaoTextArea.setFont(new Font("Arial", Font.PLAIN, 15)); 
        descricaoTextArea.setSize(190, 140); 
        descricaoTextArea.setLocation(200, 260); 
        descricaoTextArea.setLineWrap(true); 
        panelForm.add(descricaoTextArea);
		
		//Alterando tamanhos
		buttonAtualizar.setPreferredSize(new Dimension(150, 40));
		buttonCancelar.setPreferredSize(new Dimension(150, 40));
		buttonProcurar.setPreferredSize(new Dimension(150, 40));
		panelButtons.setPreferredSize(new Dimension(800, 60));
		
		panelButtons.add(buttonAtualizar);
		panelButtons.add(buttonProcurar);
		panelButtons.add(buttonCancelar);
		
		//Button actions
		buttonAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(nomeTextField.getText().isEmpty() ||
						precoTextField.getText().isEmpty() ||
						qtdTextField.getText().isEmpty() ||
						descricaoTextArea.getText().isEmpty()
					) {
						JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Erro", 1);
						return;
					}
				
				int codigo = Integer.parseInt(codigoTextField.getText());
				String nome = nomeTextField.getText();
				float preco = Float.parseFloat(precoTextField.getText());
				int qtd = Integer.parseInt(qtdTextField.getText());
				String descricao = descricaoTextArea.getText();
				
				AutoPeca peca = new AutoPeca(codigo, nome, preco, descricao, qtd);
				
				AutoPecaController.atualizarPeca(codigo, peca);
				
				JOptionPane.showMessageDialog(null, "Peça Atualizada com sucesso", "Sucesso", 1);
				
				frame.dispose();
				PanelData.updateTable();
			}
		});
		
		buttonProcurar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(codigoTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um código.", "Código inválido", 1);
					return;
				}
				
				
				int codigo = Integer.parseInt(codigoTextField.getText());
				
				AutoPeca pecaAntiga = AutoPecaController.listarUnicaPeca(codigo);
				
				if(pecaAntiga == null) {
					JOptionPane.showMessageDialog(null, "Nenhuma peça encontrada com o código informado.", "Não encontrado", 1);
					return;
				}
				
				nomeTextField.setText(pecaAntiga.getNome());
				precoTextField.setText(pecaAntiga.getPreco() + "");
				qtdTextField.setText(pecaAntiga.getQtdEmEstoque() + "");
				descricaoTextArea.setText(pecaAntiga.getDescricao());
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
