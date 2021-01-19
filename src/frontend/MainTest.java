package frontend;

import java.util.Scanner;

import backend.AutoPecaController;
import models.AutoPeca;

public class MainTest {
	public static void main(String[] args) {
		
		//Classe de teste, será deletada.
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Insira o codigo da peça a ser deletada: ");
		int codigo = input.nextInt();
		
		//Obter todas
		//for (AutoPeca peca : AutoPecaController.listarTodasAsPecas()) {
		//	System.out.println(peca.toString());
		//}
		
		//Obter uma
		//AutoPeca peca = AutoPecaController.listarUnicaPeca(codigo);
		//if(peca == null) System.out.println("Não foi encontrada nenhuma peca com o codigo.");
		//else System.out.println(peca.toString());
		
		//Deletar
		//AutoPecaController.excluirPeca(codigo);

		
		input.close();
		
		//Inserir
		//AutoPeca autoPeca = new AutoPeca(0, nome, preco, descricao, qtd);
		//AutoPecaController.inserirAutoPeca(autoPeca);
	}
}
