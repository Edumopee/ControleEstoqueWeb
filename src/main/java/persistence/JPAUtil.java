/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


/**
 *essa classe nos instaciamos o entitymanager e apontamos para o documento xml jpa
 * @author Eduardo
 */
public class JPAUtil {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("estoquePU");

    // Método para obter um novo EntityManager
    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    // Método para fechar a fábrica no encerramento da aplicação (não use nos DAOs)
    public static void close() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }
}
