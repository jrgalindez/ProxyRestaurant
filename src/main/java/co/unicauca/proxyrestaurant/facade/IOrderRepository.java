/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proxyrestaurant.facade;

import co.unicauca.proxyrestaurant.facade.domain.State;
import co.unicauca.proxyrestaurant.facade.subsystem.Customer;
import co.unicauca.proxyrestaurant.facade.subsystem.Dish;
import co.unicauca.proxyrestaurant.facade.subsystem.Order;

/**
 *
 * @author YAQUE
 */
public interface IOrderRepository {

    void addDish(Dish dish, int amount);

    int calculateTotal();

    void cancelOrder();

    void changeState(State state);

    void createOrder(Customer customer);

    Order getOrder();

    int totalDishes();
    
    void save(IOrderRepository repo);
    
}
