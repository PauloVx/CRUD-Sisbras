package frontend;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import backend.AutoPecaController;
import models.AutoPeca;

@SuppressWarnings("serial")
public class PanelData extends JPanel {

	//Mostra a tabela de peças
	public PanelData(Color color) {
		this.setBackground(color);
		
		this.setLayout(new GridLayout());
		
		String[] colunas = {"Cód", "Nome", "Preço", "Qtd", "Descrição"};
		
		DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
		
		for (AutoPeca peca : AutoPecaController.listarTodasAsPecas()) {
			   int cod = peca.getCodigo();
			   String nome = peca.getNome();
			   float preco = peca.getPreco();
			   int qtd = peca.getQtdEmEstoque();
			   String descricao = peca.getDescricao();

			   Object[] data = { cod, nome, preco + "R$", qtd + " Un", descricao };

			   tableModel.addRow(data);
		}
		
		
		JTable table = new JTable(tableModel);
		
		//Desabilitando edição
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane barraRolagem = new JScrollPane(table);
		
		this.add(barraRolagem);
		
	}
}
