package models;

public class AutoPeca {
	private int codigo;
	private String nome;
	private float preco;
	private String descricao;
	private int qtdEmEstoque;
	
	public AutoPeca(int codigo, String nome, float preco, String descricao, int qtdEmEstoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.qtdEmEstoque = qtdEmEstoque;
	}
	
	public AutoPeca(String nome, float preco, String descricao, int qtdEmEstoque) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public int getCodigo() { return codigo;	}

	public String getNome() { return nome; }

	public float getPreco() { return preco;	}

	public String getDescricao() { return descricao; }
	
	public int getQtdEmEstoque() { return qtdEmEstoque;	}
	
	@Override
	public String toString() {
		return "Cod: " + this.codigo + " " +
				"Nome: " + this.nome + " " +
				"Preço: " + this.preco + "R$ " +
				"Descrição: " + this.descricao + " " +
				"Qtd em estoque: " + this.qtdEmEstoque + " Unidades";
	}
	
}
