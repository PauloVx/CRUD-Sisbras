package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import backend.AutoPecaController;
import models.AutoPeca;

public class CriarButtonAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame frame = new Frame(600, 540, "Cadastro de pe�a");
		
		frame.setResizable(false);
		
		JPanel panelForm = new JPanel();
		JPanel panelButtons = new JPanel();
		
		Button buttonCadastrar = new Button("Cadastrar", 18, Color.GREEN);
		Button buttonCancelar = new Button("Cancelar", 18, Color.RED);
		
		//Formulario
		panelForm.setLayout(null);
		JLabel titulo = new JLabel("Cadastro de pe�a");
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setSize(300, 30); 
		titulo.setLocation(170, 30);
		
		panelForm.add(titulo);
		
		//Campo nome
        JLabel nomeLabel = new JLabel("Nome: "); 
        nomeLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nomeLabel.setSize(100, 20); 
        nomeLabel.setLocation(130, 100); 
        panelForm.add(nomeLabel); 
  
        JTextField nomeTextField = new JTextField(); 
        nomeTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        nomeTextField.setSize(190, 20); 
        nomeTextField.setLocation(200, 100); 
        panelForm.add(nomeTextField);
        //---------------------------
        
        //Campo pre�o
        JLabel precoLabel = new JLabel("Pre�o: "); 
        precoLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        precoLabel.setSize(100, 20); 
        precoLabel.setLocation(130, 140); 
        panelForm.add(precoLabel); 
  
        JTextField precoTextField = new JTextField(); 
        precoTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        precoTextField.setSize(190, 20); 
        precoTextField.setLocation(200, 140); 
        panelForm.add(precoTextField);
        //----------------------------
        
        //Campo quantidade
        JLabel qtdLabel = new JLabel("Qtd: "); 
        qtdLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        qtdLabel.setSize(100, 20); 
        qtdLabel.setLocation(150, 180); 
        panelForm.add(qtdLabel); 
  
        JTextField qtdTextField = new JTextField(); 
        qtdTextField.setFont(new Font("Arial", Font.PLAIN, 15)); 
        qtdTextField.setSize(190, 20); 
        qtdTextField.setLocation(200, 180); 
        panelForm.add(qtdTextField);
        //----------------------------
        
        //Campo descri��o
        JLabel descricaoLabel = new JLabel("Descri��o: "); 
        descricaoLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        descricaoLabel.setSize(100, 20); 
        descricaoLabel.setLocation(90, 220); 
        panelForm.add(descricaoLabel); 
        
        JTextArea descricaoTextArea = new JTextArea(); 
        descricaoTextArea.setFont(new Font("Arial", Font.PLAIN, 15)); 
        descricaoTextArea.setSize(190, 140); 
        descricaoTextArea.setLocation(200, 220); 
        descricaoTextArea.setLineWrap(true); 
        panelForm.add(descricaoTextArea);
		
		//Alterando tamanhos
		buttonCadastrar.setPreferredSize(new Dimension(150, 40));
		buttonCancelar.setPreferredSize(new Dimension(150, 40));
		panelButtons.setPreferredSize(new Dimension(800, 60));
		
		panelButtons.add(buttonCadastrar);
		panelButtons.add(buttonCancelar);
		
		//Button actions
		buttonCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = nomeTextField.getText();
				float preco = Float.parseFloat(precoTextField.getText());
				int qtd = Integer.parseInt(qtdTextField.getText());
				String descricao = descricaoTextArea.getText();
				
				AutoPeca peca = new AutoPeca(nome, preco, descricao, qtd);
				
				AutoPecaController.inserirAutoPeca(peca);
				
				frame.dispose();
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
