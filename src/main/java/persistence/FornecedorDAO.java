/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

/**
 *
 * @author Eduardo
 */



import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

import model.Fornecedor;

/**
 * Data Access Object (DAO) para a entidade Fornecedor,
 * utilizando Java Persistence API (JPA) para comunicação com o banco de dados.
 * gerencia a conecão com a tabele fornecedor no BD e possui os metodos de conexão ou crud
 */
public class FornecedorDAO {

    /**
     * Salva ou atualiza um fornecedor no banco de dados.
     *
     * @param fornecedor O objeto Fornecedor a ser persistido.
     */
    public void save(Fornecedor fornecedor) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(fornecedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    /**
     * Busca todos os fornecedores no banco de dados.
     * @return Uma lista de objetos Fornecedor.
     */
    public List<Fornecedor> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Fornecedor> fornecedores = null;
        try {
            TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class);
            fornecedores = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return fornecedores;
    }

    /**
     * Busca um fornecedor pelo seu ID.
     * @param id O ID do fornecedor a ser buscado.
     * @return O objeto Fornecedor encontrado ou null se não existir.
     */
    public Fornecedor findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return fornecedor;
    }
}