package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import backend.AutoPecaController;
import models.AutoPeca;

public class AtualizarButtonAction implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
Frame frame = new Frame(600, 540, "Atualizar Pe�a");
		
		frame.setResizable(false);
		
		JPanel panelForm = new JPanel();
		JPanel panelButtons = new JPanel();
		
		Button buttonAtualizar = new Button("Atualizar", 18, Color.GREEN);
		Button buttonCancelar = new Button("Cancelar", 18, Color.RED);
		Button buttonProcurar = new Button("Procurar", 18, Color.ORANGE);
		
		//Formulario
		panelForm.setLayout(null);
		JLabel titulo = new JLabel("Atualizar Pe�a");
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setSize(300, 30); 
		titulo.setLocation(170, 30);
		
		panelForm.add(titulo);
		
		//Campo codigo
        JLabel codigoLabel = new JLabel("C�digo: "); 
        codigoLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        codigoLabel.setSize(100, 20); 
        codigoLabel.setLocation(120, 100); 
        panelForm.add(codigoLabel); 
        
        JTextField codigoTextField = new JTextField();
        
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
        
        //Campo pre�o
        JLabel precoLabel = new JLabel("Pre�o: "); 
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
        
        //Campo descri��o
        JLabel descricaoLabel = new JLabel("Descri��o: "); 
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
			int codigo;
			String nome;
			float preco;
			int qtd;
			String descricao;
			
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
				
				//Valida��o
				try {
					codigo = Integer.parseInt(codigoTextField.getText());
					preco = Float.parseFloat(precoTextField.getText());
					qtd = Integer.parseInt(qtdTextField.getText());
				}
				catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Por favor, verifique os campos.", "Valor Inv�lido para um dos Campos", 1);
					return;
				}
				
				nome = nomeTextField.getText();
				descricao = descricaoTextArea.getText();
				
				AutoPeca peca = new AutoPeca(codigo, nome, preco, descricao, qtd);
				
				AutoPecaController.atualizarPeca(codigo, peca);
				
				JOptionPane.showMessageDialog(null, "Pe�a Atualizada com sucesso", "Sucesso", 1);
				
				frame.dispose();
				PanelData.updateTable();
			}
		});
		
		buttonProcurar.addActionListener(new ActionListener() {
			int codigo;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(codigoTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um c�digo.", "C�digo inv�lido", 1);
					return;
				}
				
				//Valida��o
				try {
					codigo = Integer.parseInt(codigoTextField.getText());
				}
				catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Por favor, informe um c�digo v�lido.", "C�digo Inv�lido", 1);
					return;
				}
				
				AutoPeca pecaAntiga = AutoPecaController.listarUnicaPeca(codigo);
				
				if(pecaAntiga == null) {
					JOptionPane.showMessageDialog(null, "Nenhuma pe�a encontrada com o c�digo informado.", "N�o encontrado", 1);
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
