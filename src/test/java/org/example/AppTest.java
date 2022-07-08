package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.dao.ClientDAO;
import org.example.dao.OrderDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.ClientState;
import org.example.util.OrderState;
import org.junit.Test;

import java.util.List;

public class AppTest
{
    @Test
    public void createClient()
    {
        Client jean = new Client();
        jean.setFirstName("Jean");
        jean.setLastName("Dujardin");
        jean.setAddress("12 rue de la paix");
        jean.setCity("Paris");
        jean.setZipCode("75000");
        jean.setCountry("Paris");
        jean.setCompanyName("Microsoft");
        jean.setEmail("jean@mc.fr");
        jean.setPhone("0606060606");
        jean.setState(ClientState.ACTIVE);
        ClientDAO.createClient(jean);
    }

    @Test
    public void findAllClient()
    {
        List<Client> clients = ClientDAO.findAllClient();
    }

    @Test
    public void deleteClientById()
    {
        ClientDAO.deleteClientById(5);
    }

    @Test
    public void updateClient() {
        Client newClientData = new Client();
        newClientData.setFirstName("Jean-Paul");
        newClientData.setLastName("Belmondo");

        ClientDAO.updateClient(7, newClientData);

        assertEquals("Jean-Paul", newClientData.getFirstName());
        assertEquals("Belmondo", newClientData.getLastName());
    }

    @Test
    public void createOrder()
    {
        Client client = ClientDAO.findClientById(7);

        Order order = new Order();
        order.setTypePresta("Formation");
        order.setDesignation("Magic");
        order.setNbDays(5);
        order.setUnitPrice(20.0F);
        order.setState(OrderState.CONFIRMED);
        order.setClient(client);

        OrderDAO.createOrder(order);
    }

    @Test
    public void updateOrder() {
        Order newOrderData = new Order();
        newOrderData.setUnitPrice(2000F);

        OrderDAO.updateOrder(21, newOrderData);
    }
}
