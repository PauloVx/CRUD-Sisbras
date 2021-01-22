package frontend;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.AutoPecaController;
import models.AutoPeca;

@SuppressWarnings("serial")
public class PanelData extends JPanel {
	
	private static String[] colunas = {"Cód", "Nome", "Preço", "Qtd", "Descrição"};
	
	private static DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	
	private static JTable table = new JTable(tableModel);

	//Mostra a tabela de peças
	public PanelData(Color color) {
		this.setBackground(color);
		
		this.setLayout(new GridLayout());
		
		for (AutoPeca peca : AutoPecaController.listarTodasAsPecas()) {
			   int cod = peca.getCodigo();
			   String nome = peca.getNome();
			   float preco = peca.getPreco();
			   int qtd = peca.getQtdEmEstoque();
			   String descricao = peca.getDescricao();

			   Object[] data = { cod, nome, preco + "R$", qtd + " Un", descricao };

			   tableModel.addRow(data);
		}
		
		
		//Desabilitando edição
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane barraRolagem = new JScrollPane(table);
		
		this.add(barraRolagem);
		
	}
	
	public static void updateTable() { 
		tableModel.setRowCount(0);
		for (AutoPeca peca : AutoPecaController.listarTodasAsPecas()) {
			int cod = peca.getCodigo();
			String nome = peca.getNome();
			float preco = peca.getPreco();
			int qtd = peca.getQtdEmEstoque();
			String descricao = peca.getDescricao();

			Object[] data = { cod, nome, preco + "R$", qtd + " Un", descricao };

			tableModel.addRow(data);
		}
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	} 
}
