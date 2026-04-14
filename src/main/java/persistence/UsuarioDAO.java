/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import model.Usuario;

/**
 * Data Access Object (DAO) para a entidade Fornecedor,
 * utilizando Java Persistence API (JPA) para comunicação com o banco de dados.
 * gerencia a conecão com a tabele usuario no BD e possui os metodos de conexão ou crud
 */
public class UsuarioDAO {

    public Usuario findByUsernameAndPassword(String usuario, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario user = null;
        try {
            // JPQL query to find a user by username and password
            String jpql = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("usuario", usuario);
            query.setParameter("senha", senha);
            user = query.getSingleResult();
        } catch (NoResultException e) {
            // If no result is found, return null
            return null;
        } finally {
            em.close();
        }
        return user;
    }
}
