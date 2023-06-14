/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

import java.util.List;

/**
 *
 * @author Lucas
 */
public class billeteraDTO {
    
    private int id;
    private int usuarioid;
    private List <monedaDTO> monedas;

    public billeteraDTO() {
    }

    public billeteraDTO(int id, int usuarioid, List<monedaDTO> monedas) {
        this.id = id;
        this.usuarioid = usuarioid;
        this.monedas = monedas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public List<monedaDTO> getMonedas() {
        return monedas;
    }

    public void setMonedas(List<monedaDTO> monedas) {
        this.monedas = monedas;
    }

    


    
    
}
