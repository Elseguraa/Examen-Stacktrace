/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "operaciones")
public class operaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private billetera billetera_origen;
    
    @ManyToOne
    private billetera billetera_destino;
    
    @ManyToOne
    private moneda moneda_origen;
    
    @ManyToOne
    private moneda moneda_destino;
    
    private float cantidad;
    private String tipo;
    private LocalDate Fecha;

    public operaciones() {
    }

    public operaciones(int id, billetera billetera_origen, billetera billetera_destino, moneda moneda_origen, moneda moneda_destino, float cantidad, String tipo, LocalDate Fecha) {
        this.id = id;
        this.billetera_origen = billetera_origen;
        this.billetera_destino = billetera_destino;
        this.moneda_origen = moneda_origen;
        this.moneda_destino = moneda_destino;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.Fecha = Fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public billetera getBilletera_origen() {
        return billetera_origen;
    }

    public void setBilletera_origen(billetera billetera_origen) {
        this.billetera_origen = billetera_origen;
    }

    public billetera getBilletera_destino() {
        return billetera_destino;
    }

    public void setBilletera_destino(billetera billetera_destino) {
        this.billetera_destino = billetera_destino;
    }

    public moneda getMoneda_origen() {
        return moneda_origen;
    }

    public void setMoneda_origen(moneda moneda_origen) {
        this.moneda_origen = moneda_origen;
    }

    public moneda getMoneda_destino() {
        return moneda_destino;
    }

    public void setMoneda_destino(moneda moneda_destino) {
        this.moneda_destino = moneda_destino;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
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
