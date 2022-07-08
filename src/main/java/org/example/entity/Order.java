package org.example.entity;

import org.example.util.OrderState;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "typePresta")
    private String typePresta;

    private String designation;

    @Column(name = "nbDays")
    private Integer nbDays;

    @Column(name = "unitPrice")
    private Float unitPrice;

    private OrderState state;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    public Order()
    {
    }

    public Order(Integer id, String typePresta, String designation, Integer nbDays, Float unitPrice, OrderState state) {
        this.id = id;
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public Order(String typePresta, String designation, Client client, Integer nbDays, Float unitPrice, OrderState state) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.client = client;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setNotNullData(Order newOrderData) {
        if (newOrderData.getTypePresta() != null) {
            this.setTypePresta(newOrderData.getTypePresta());
        }
        if (newOrderData.getDesignation() != null) {
            this.setDesignation(newOrderData.getDesignation());
        }
        if (newOrderData.getNbDays() != null) {
            this.setNbDays(newOrderData.getNbDays());
        }
        if (newOrderData.getUnitPrice() != null) {
            this.setUnitPrice(newOrderData.getUnitPrice());
        }
        if (newOrderData.getState() != null) {
            this.setState(newOrderData.getState());
        }
    }
}
