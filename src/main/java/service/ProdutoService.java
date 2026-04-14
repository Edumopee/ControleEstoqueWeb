package service;

import model.Produto;
import persistence.ProdutoDAO;
import java.util.List;

public class ProdutoService {
    private ProdutoDAO dao = new ProdutoDAO();

    public void salvarProduto(Produto p) {
        // APLICANDO SRP (Responsabilidade Única): 
        // O Service valida, o DAO salva.
        if (p.getNome() == null || p.getNome().isEmpty()) {
            throw new RuntimeException("O nome do produto é obrigatório.");
        }
        if (p.getValor() <= 0) {
            throw new RuntimeException("O valor deve ser maior que zero.");
        }
        
        dao.salvar(p);
    }

    public List<Produto> listarEstoqueCritico(int limite) {
        // Lógica de negócio: o que o sistema considera "estoque crítico"
        return dao.findByEstoqueAbaixo(limite);
    }
}