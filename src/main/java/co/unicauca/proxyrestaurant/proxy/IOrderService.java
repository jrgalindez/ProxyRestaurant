/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proxyrestaurant.proxy;

import co.unicauca.proxyrestaurant.facade.IOrderRepository;

/**
 *
 * @author joser
 */
public interface IOrderService {

    void save(IOrderRepository repo);

}
