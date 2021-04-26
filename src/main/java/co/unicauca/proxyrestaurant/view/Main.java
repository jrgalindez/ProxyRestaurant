/*
Integrantes:

JOSE RICARDO GALINDEZ LOPEZ


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proxyrestaurant.view;

import co.unicauca.proxyrestaurant.facade.Factory;
import co.unicauca.proxyrestaurant.facade.OrderFacade;
import co.unicauca.proxyrestaurant.facade.domain.State;
import co.unicauca.proxyrestaurant.facade.subsystem.Customer;
import co.unicauca.proxyrestaurant.facade.subsystem.Dish;
import co.unicauca.proxyrestaurant.facade.IOrderRepository;
import co.unicauca.proxyrestaurant.proxy.IOrderService;
import co.unicauca.proxyrestaurant.proxy.OrderServiceLogger;
import co.unicauca.proxyrestaurant.proxy.ProxyClient;

/**
 * Cliente que llama a los servicios de la facada
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Main {

    public static void main(String[] args) {

//Usado para el Taller de Facade
        System.out.println("\n Usando unicamente Facade \n");

        
        OrderFacade facade = new OrderFacade();
        facade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 Barrio Caldas", "3115677899", "Popayán"));
        facade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
        facade.addDish(new Dish(2, "Hamburguesa sencilla", 4000), 3);
        facade.addDish(new Dish(3, "Jugo hit", 1000), 2);
        System.out.println("Pedido creado");
        facade.changeState(State.CONFIRMED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        facade.changeState(State.DISPACHED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        facade.changeState(State.FINALIZED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        System.out.println("El valor total del pedido es: " + facade.calculateTotal());
        System.out.println("Total de platos pedidos: " + facade.totalDishes());
        IOrderRepository repo = Factory.getInstance().getRepository("default");
        facade.save(repo);
        System.out.println("Pedido grabado con éxito en la base de datos");
//*/
        
//Usado para el Taller de Proxy
        System.out.println("\n Usando Proxy \n");

        //El sujeto real.
        OrderFacade orderFacade = new OrderFacade();
        //El objeto proxy. Se le pasa el objeto real por el constructor (inyección)
        IOrderService orderProxy = new OrderServiceLogger(orderFacade);
        //Se opera normal el sujeto real
        orderFacade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 Barrio Caldas", "3115677899", "Popayán"));
        orderFacade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
        orderFacade.addDish(new Dish(2, "Hamburguesa sencilla", 4000), 3);
        orderFacade.addDish(new Dish(3, "Jugo hit", 1000), 2);
        System.out.println("Pedido creado");
        orderFacade.changeState(State.CONFIRMED);
        System.out.println("Se cambio el estado a " + orderFacade.getOrder().getState());
        orderFacade.changeState(State.DISPACHED);
        System.out.println("Se cambio el estado a " + orderFacade.getOrder().getState());
        orderFacade.changeState(State.FINALIZED);
        System.out.println("Se cambio el estado a " + orderFacade.getOrder().getState());
        System.out.println("El valor total del pedido es: " + orderFacade.calculateTotal());
        System.out.println("Total de platos pedidos: " + orderFacade.totalDishes());
        //Ahora ejecutamos el cliente proxy, y le pasamos el sujeto que debe utilizar.
        ProxyClient client = new ProxyClient(orderProxy);
        client.createOrder();
    }
}
