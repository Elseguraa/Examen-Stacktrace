/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Entity.billetera;
import Entity.moneda;
import Entity.operaciones;
import Repository.REoperaciones;
import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class SEoperaciones {
    
    private final REoperaciones reOperaciones;
    private final SEbilletera billeteraService;

    public SEoperaciones(REoperaciones reOperaciones, SEbilletera billeteraService) {
        this.reOperaciones = reOperaciones;
        this.billeteraService = billeteraService;
    }
    
    public operaciones crearOperacion(billetera billeteraOrigen, billetera billeteraDestino, moneda monedaOrigen, moneda monedaDestino, float cantidad, String tipo) {
        operaciones operacion = new operaciones();
        operacion.setBilletera_origen(billeteraOrigen);
        operacion.setBilletera_destino(billeteraDestino);
        operacion.setBilletera_origen(billeteraOrigen);
        operacion.setBilletera_destino(billeteraDestino);
        operacion.setCantidad(cantidad);
        operacion.setTipo(tipo);
        operacion.setFecha(LocalDate.now());
        
        // Realizar las operaciones correspondientes en las billeteras
        if (tipo.equals("intercambio")) {
            // Realizar intercambio de divisas entre las billeteras
            billeteraService.intercambiarDivisas(billeteraOrigen, billeteraDestino, monedaOrigen, monedaDestino, cantidad);
            
        } else if (tipo.equals("deposito")) {
            // Realizar depósito de divisas en la billetera de destino
            billeteraService.depositarDivisas(billeteraDestino, monedaDestino, cantidad);
        }
        
        // Guardar la operación en la base de datos
        return reOperaciones.save(operacion);
    }
    
}
