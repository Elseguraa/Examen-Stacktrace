/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Dto.billeteraDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "billetera_moneda")
public class billetera_moneda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_billetera")
    private billetera billetera;
    
    @ManyToOne
    @JoinColumn(name = "id_moneda")
    private moneda moneda;
    
    private float balance;

    public billetera_moneda() {
    }

    public billetera_moneda(int id, billetera billetera, moneda moneda, float balance) {
        this.id = id;
        this.billetera = billetera;
        this.moneda = moneda;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(billetera billetera) {
        this.billetera = billetera;
    }

    public moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(moneda moneda) {
        this.moneda = moneda;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setBilletera(billeteraDTO billetera) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
