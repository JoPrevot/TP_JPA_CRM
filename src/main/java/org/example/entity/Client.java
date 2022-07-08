package org.example.entity;

import org.example.util.ClientState;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    private String email;
    private String phone;
    private String address;

    @Column(name = "zipCode")
    private String zipCode;

    private String city;
    private String country;
    private ClientState state;

    public Client()
    {
    }

    public Client(Integer id, String companyName, String firstName, String lastName, String email, String phone, String address, String zipCode, String city, String country, ClientState state) {
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ClientState getState() {
        return state;
    }

    public void setState(ClientState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state=" + state +
                '}';
    }
    public void setNotNullData(Client newClientData) {
        if (newClientData.getCompanyName() != null) {
            this.setCompanyName(newClientData.getCompanyName());
        }
        if (newClientData.getFirstName() != null) {
            this.setFirstName(newClientData.getFirstName());
        }
        if (newClientData.getLastName() != null) {
            this.setLastName(newClientData.getLastName());
        }
        if (newClientData.getEmail() != null) {
            this.setEmail(newClientData.getEmail());
        }
        if (newClientData.getPhone() != null) {
            this.setPhone(newClientData.getPhone());
        }
        if (newClientData.getAddress() != null) {
            this.setAddress(newClientData.getAddress());
        }
        if (newClientData.getZipCode() != null) {
            this.setZipCode(newClientData.getZipCode());
        }
        if (newClientData.getCity() != null) {
            this.setCity(newClientData.getCity());
        }
        if (newClientData.getCountry() != null) {
            this.setCountry(newClientData.getCountry());
        }
        if (newClientData.getState() != null) {
            this.setState(newClientData.getState());
        }
    }
}
