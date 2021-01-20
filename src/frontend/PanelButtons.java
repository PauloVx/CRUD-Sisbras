package frontend;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelButtons extends JPanel {

	public PanelButtons() {
		setBackground(Color.LIGHT_GRAY);
		
		setLayout(new GridLayout(4, 1));
		
		Button listarButton    = new Button("Listar Peças",   18, Color.LIGHT_GRAY);
		Button criarButton     = new Button("Nova Peça",      18, Color.LIGHT_GRAY);
		Button atualizarButton = new Button("Atualizar Peça", 18, Color.LIGHT_GRAY);
		Button excluirButton   = new Button("Excluir Peça",   18, Color.LIGHT_GRAY);
		
		//Adicionando ações dos buttons.
		listarButton.addActionListener(new ListarButtonAction());
		criarButton.addActionListener(new CriarButtonAction());
		atualizarButton.addActionListener(new AtualizarButtonAction());
		excluirButton.addActionListener(new ExcluirButtonAction());
		
		this.add(listarButton);
		this.add(criarButton);
		this.add(atualizarButton);
		this.add(excluirButton);
	}
}
