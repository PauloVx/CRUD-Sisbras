package frontend;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelButtons extends JPanel {

	public PanelButtons() {
		setBackground(Color.LIGHT_GRAY);
		
		setLayout(new GridLayout(3, 1));
		
		Button criarButton     = new Button("Nova Pe�a",      18, Color.LIGHT_GRAY);
		Button atualizarButton = new Button("Atualizar Pe�a", 18, Color.LIGHT_GRAY);
		Button excluirButton   = new Button("Excluir Pe�a",   18, Color.LIGHT_GRAY);
		
		//Adicionando a��es dos buttons.
		criarButton.addActionListener(new CriarButtonAction());
		atualizarButton.addActionListener(new AtualizarButtonAction());
		excluirButton.addActionListener(new ExcluirButtonAction());
		
		this.add(criarButton);
		this.add(atualizarButton);
		this.add(excluirButton);
	}
}
