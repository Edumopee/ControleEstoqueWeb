package test;

import model.Fornecedor;
import model.Produto;
import service.ProdutoService;
import persistence.FornecedorDAO;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Iniciando testes do sistema refatorado...");

        try {
            // 1. Criar um fornecedor de teste
            Fornecedor f = new Fornecedor();
            f.setNome("Fornecedor Teste SOLID");
            
            // ADICIONE ESTAS DUAS LINHAS ABAIXO:
            f.setContato("15 99999-0000"); // Preenche o campo obrigatório
            f.setEndereco("Sorocaba, SP"); // Preenche o campo obrigatório
            
            new FornecedorDAO().save(f);

            // 2. Usar o SERVICE para salvar um produto
            Produto p = new Produto();
            p.setNome("Teclado Mecânico");
            p.setDescricao("Teclado RGB Switch Blue"); // Boa prática preencher também
            p.setValor(250.0);
            p.setEstoque(10);
            p.setFornecedor(f);

            ProdutoService service = new ProdutoService();
            service.salvarProduto(p);

            System.out.println("\n--------------------------------------------");
            System.out.println("Sucesso! Produto e Fornecedor integrados e salvos.");
            System.out.println("--------------------------------------------");
            
        } catch (Exception e) {
            // O printStackTrace ajuda a ver exatamente qual coluna deu erro se falhar de novo
            System.err.println("Erro no teste: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}