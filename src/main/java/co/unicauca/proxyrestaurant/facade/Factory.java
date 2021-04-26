/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proxyrestaurant.facade;

/**
 *
 * @author YAQUE
 */
public class Factory {
    
    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IOrderFacade
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IOrderFacade
     */
    public IOrderRepository getRepository(String type) {

        IOrderRepository result = null;

        switch (type) {
            case "default":
                result = new OrderFacade();
                break;
        }

        return result;

    }
}
