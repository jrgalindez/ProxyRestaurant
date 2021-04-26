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
import co.unicauca.proxyrestaurant.proxy.OrderServiceLogger;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author YAQUE
 */
public class OrderFacade implements IOrderRepository {
    private Order order;
    
    @Override
    public void createOrder(Customer customer){
        this.order = new Order (0,customer, LocalDate.EPOCH, State.NEW);
    }
    @Override
    public void addDish(Dish dish, int amount){
        this.order.addDish(dish, amount);
    }
    @Override
    public void changeState(State state){
        this.order.setState(state);
    }
    @Override
    public void cancelOrder(){
        this.order.setState(State.CANCELLED);
    }
    @Override
    public int calculateTotal(){
        return this.order.calculateTotal();
    }
    @Override
    public Order getOrder(){
        return this.order;
    }
    @Override
    public int totalDishes(){
        return this.order.getDetails().size();
    }

    @Override
    public void save(IOrderRepository repo) {
        repo.createOrder(this.order.getCustomer());
        String message = "Pedido Guardado en la base de Datos";
        Logger logger = LoggerFactory.getLogger(OrderFacade.class);
        logger.info(message);
    }

}
