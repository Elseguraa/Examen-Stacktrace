/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

import java.time.LocalDate;

/**
 *
 * @author Lucas
 */
public class operacionesDTO {
    
    private String billetera_origen;
    private String billetera_destino;
    private String moneda_origen;
    private String moneda_destino;
    private String tipo;
    private LocalDate Fecha;

    public operacionesDTO() {
    }

    public operacionesDTO(String billetera_origen, String billetera_destino, String moneda_origen, String moneda_destino, String tipo, LocalDate Fecha) {
        this.billetera_origen = billetera_origen;
        this.billetera_destino = billetera_destino;
        this.moneda_origen = moneda_origen;
        this.moneda_destino = moneda_destino;
        this.tipo = tipo;
        this.Fecha = Fecha;
    }

    public String getBilletera_origen() {
        return billetera_origen;
    }

    public void setBilletera_origen(String billetera_origen) {
        this.billetera_origen = billetera_origen;
    }

    public String getBilletera_destino() {
        return billetera_destino;
    }

    public void setBilletera_destino(String billetera_destino) {
        this.billetera_destino = billetera_destino;
    }

    public String getMoneda_origen() {
        return moneda_origen;
    }

    public void setMoneda_origen(String moneda_origen) {
        this.moneda_origen = moneda_origen;
    }

    public String getMoneda_destino() {
        return moneda_destino;
    }

    public void setMoneda_destino(String moneda_destino) {
        this.moneda_destino = moneda_destino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
