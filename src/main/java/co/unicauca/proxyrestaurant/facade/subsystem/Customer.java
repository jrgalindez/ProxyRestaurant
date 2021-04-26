/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proxyrestaurant.facade.subsystem;

/**
 *
 * @author YAQUE
 */
public class Customer {
    private int id;
    private String name;
    private String address;
    private String movile;
    private String city;

    public Customer(int id, String name, String address, String movile, String city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.movile = movile;
        this.city = city;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMovile() {
        return movile;
    }

    public void setMovile(String movile) {
        this.movile = movile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
