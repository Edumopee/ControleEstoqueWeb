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
    
    // método que calcula o valor total do estoque
public double calcularValorTotalEstoque(Produto p) {
    if (p.getEstoque() < 0) {
        throw new IllegalArgumentException("Estoque não pode ser negativo");
    }
    return p.getValor() * p.getEstoque();
}

// Método para o teste unitário (UC de Testes)
public double calcularValorTotalEstoque(double valor, int quantidade) {
    if (quantidade < 0) {
        throw new IllegalArgumentException("Quantidade não pode ser negativa");
    }
    return valor * quantidade;
}
}