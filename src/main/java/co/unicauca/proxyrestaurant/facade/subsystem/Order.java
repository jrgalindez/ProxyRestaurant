/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proxyrestaurant.facade.subsystem;

import co.unicauca.proxyrestaurant.facade.domain.State;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author YAQUE
 */
public class Order {
    public int despatch;
    private Customer customer;
    private LocalDate date;
    private State state;
    private ArrayList<Item> details;

    public Order(int despatch, Customer customer, LocalDate date, State state) {
        this.despatch = despatch;
        this.customer = customer;
        this.date = date;
        this.state = state;
        this.details = new ArrayList<>();
    }

    public void addDish(Dish dish, int amount){
        this.details.add(new Item(dish, amount));
    }
    
    public int calculateTotal(){
        int valor=0;
        for (int i = 0; i < this.details.size(); i++) {
            valor += this.details.get(i).getDish().getPrice()*this.details.get(i).getAmount();
        }
        
        return valor;
    }

    public ArrayList<Item> getDetails() {
        return details;
    }
    
    public int getDespatch() {
        return despatch;
    }

    public void setDespatch(int despatch) {
        this.despatch = despatch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
}
