package org.example.dao;

import org.example.entity.Client;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClientDAO {

    public static void createClient(Client clientToCreate)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(clientToCreate);
        tx.commit();
    }

    public static List<Client> findAllClient()
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Client c");

        findAllQuery.getResultList();

        return findAllQuery.getResultList();
    }

    public static Client findClientById(Integer id)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client client = entityManager.find(Client.class, id);

        return client;
    }

    public static void deleteClient(Client clientToDelete)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(clientToDelete);
        tx.commit();
    }

    public static void deleteClientById(Integer id)
    {
       Client clientToDelete = findClientById(id);

       deleteClient(clientToDelete);
    }

    public static void updateClient(Integer id, Client newClientData)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client clientToUpdate = findClientById(id);

        clientToUpdate.setNotNullData(newClientData);

        EntityTransaction tx = entityManager.getTransaction();;

        try
        {
            tx.begin();
            entityManager.merge(clientToUpdate);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }

    }
}
