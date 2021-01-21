package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton {
	
	public Button(String texto, int tamanhoFonte, Color cor) {
		this.setText(texto);
		this.setOpaque(true);
		this.setBackground(cor);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.setFont(new Font("sans-seriff", Font.BOLD, tamanhoFonte));
	}
}
