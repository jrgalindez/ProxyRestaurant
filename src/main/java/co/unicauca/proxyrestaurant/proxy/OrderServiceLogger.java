/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proxyrestaurant.proxy;

import co.unicauca.proxyrestaurant.facade.IOrderRepository;
import co.unicauca.proxyrestaurant.facade.OrderFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author joser
 */
public class OrderServiceLogger implements IOrderService {

    private OrderFacade orderFacade;

    public OrderServiceLogger(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @Override
    public void save(IOrderRepository repo) {
        repo.createOrder(this.orderFacade.getOrder().getCustomer());
        String message = "Pedido Guardado en la base de Datos";
        Logger logger = LoggerFactory.getLogger(OrderServiceLogger.class);
        logger.info(message);
    }
}
