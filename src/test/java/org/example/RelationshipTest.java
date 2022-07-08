package org.example;

import org.example.dao.ClientDAO;
import org.example.dao.OrderDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.ClientState;
import org.example.util.OrderState;
import org.junit.Test;

public class RelationshipTest {

    @Test
    public void ManyToOne()
    {
        Client bill = new Client();
        bill.setCompanyName("Microsoft");
        bill.setFirstName("Bill");
        bill.setLastName("Gates");
        bill.setEmail("bill@gates.com");
        bill.setPhone("0606060606");
        bill.setAddress("Hollywood");
        bill.setZipCode("1200");
        bill.setCity("Los Angeles");
        bill.setCountry("USA");
        bill.setState(ClientState.ACTIVE);

        ClientDAO.createClient(bill);

        /****************/

        Order billOrder1 = new Order();
        billOrder1.setTypePresta("Relationship");
        billOrder1.setDesignation("Apero");
        billOrder1.setClient(bill);
        billOrder1.setNbDays(1);
        billOrder1.setUnitPrice(0F);
        billOrder1.setState(OrderState.CANCELLED);

        OrderDAO.createOrder(billOrder1);

        /****************/

        OrderDAO.createOrder(new Order("Business","Aperoooo",bill,2,1F,OrderState.CONFIRMED));
    }
}
