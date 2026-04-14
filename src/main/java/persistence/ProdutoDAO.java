package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import model.Produto;




/**
 * Data Access Object (DAO) para a entidade Fornecedor,
 * utilizando Java Persistence API (JPA) para comunicação com o banco de dados.
 * gerencia a conecão com a tabele produto no BD e possui os metodos de conexão ou crud
 */
public class ProdutoDAO {

    public void salvar(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao salvar o produto", e);
        } finally {
            em.close();
        }
    }
    
    public void update(Produto produto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao atualizar o produto", e);
        } finally {
            em.close();
        }
    }
    
    public void atualizarEstoque(Long id, int novoEstoque) {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin(); // Inicia a transação
    try {
        // Busca a entidade pelo ID
        Produto produto = em.find(Produto.class, id);

        if (produto != null) {
            // Atualiza apenas o estoque
            produto.setEstoque(novoEstoque);
            
            em.getTransaction().commit(); // Confirma as alterações
        } else {
            em.getTransaction().rollback();
            throw new RuntimeException("Produto com ID " + id + " não encontrado para atualização.");
        }
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        throw new RuntimeException("Erro ao atualizar o estoque do produto.", e);
    } finally {
        em.close();
    }
}

    public List<Produto> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Usamos JOIN FETCH para carregar os produtos e seus fornecedores em uma única consulta
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p JOIN FETCH p.fornecedor", Produto.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Produto> findByEstoqueAbaixo(int quantidade) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p WHERE p.quantidadeEstoque < :quantidade", Produto.class);
            query.setParameter("quantidade", quantidade);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public Produto findById(Long id) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        return em.find(Produto.class, id);
    } finally {
        em.close();
    }
}
}