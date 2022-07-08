package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Order;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class OrderDAO {

    public static void createOrder(Order orderToCreate)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(orderToCreate);
        tx.commit();
    }

    public static List<Order> findAllOrder()
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select o from Order o");

        findAllQuery.getResultList();

        return findAllQuery.getResultList();
    }

    public static Order findOrderById(Integer id)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order order = entityManager.find(Order.class, id);

        return order;
    }

    public static void deleteOrder(Order orderToDelete)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(orderToDelete);
        tx.commit();
    }

    public static void deleteOrderById(Integer id)
    {
        Order orderToDelete = findOrderById(id);

        deleteOrder(orderToDelete);
    }

    public static void updateOrder(Integer id, Order newOrderData)
    {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order orderToUpdate = findOrderById(id);

        orderToUpdate.setNotNullData(newOrderData);

        EntityTransaction tx = entityManager.getTransaction();;

        try
        {
            tx.begin();
            entityManager.merge(orderToUpdate);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }

    }
}

