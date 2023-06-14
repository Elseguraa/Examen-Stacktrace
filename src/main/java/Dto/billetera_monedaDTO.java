/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author Lucas
 */
public class billetera_monedaDTO {
    
    private int billeteraId;
    private int monedaId;

    public billetera_monedaDTO() {
    }

    public billetera_monedaDTO(int billeteraId, int monedaId) {
        this.billeteraId = billeteraId;
        this.monedaId = monedaId;
    }

    public int getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public int getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(int monedaId) {
        this.monedaId = monedaId;
    }
    
    
            
}
