package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	public Frame(int x, int y, String titulo) {
		
		organizarLayout();
		
		setTitle(titulo);
		setVisible(true);
		setSize(x, y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void organizarLayout() {
		this.setLayout(new BorderLayout());
		
		PanelButtons panelButtons = new PanelButtons();
		PanelData panelData = new PanelData();
		
		panelButtons.setPreferredSize(new Dimension(160, 540));
		
		this.add(panelButtons, BorderLayout.WEST);
		this.add(panelData, BorderLayout.CENTER);
		
	}
}
