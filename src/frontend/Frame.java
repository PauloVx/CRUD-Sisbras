package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	//Tela inicial.
	public Frame(String titulo, boolean visivel) {
		
		this.organizarLayout();
		
		this.setTitle(titulo);
		
		this.setExtendedState(MAXIMIZED_BOTH); 
		this.setVisible(visivel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
	}
	
	//Outras telas.
	public Frame(int x, int y, String titulo) {
		
		this.setLayout(new BorderLayout());
		
		this.setTitle(titulo);
		this.setVisible(true);
		this.setSize(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
	}

	private void organizarLayout() {
		this.setLayout(new BorderLayout());
		
		PanelButtons panelButtons = new PanelButtons();
		PanelData panelData = new PanelData(Color.WHITE);
		
		panelButtons.setPreferredSize(new Dimension(160, 540));
		
		this.add(panelButtons, BorderLayout.WEST);
		this.add(panelData, BorderLayout.CENTER);
		
	}
	
}
