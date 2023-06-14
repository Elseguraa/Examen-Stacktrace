/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dto.monedaDTO;
import Entity.moneda;
import Repository.REmoneda;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


 @Service
public class SEmoneda {

    public static moneda moneda;
   
    private final REmoneda monedaRepository;
    
    @Autowired
    public SEmoneda(REmoneda monedaRepository) {
        this.monedaRepository = monedaRepository;
    }
    
    public moneda crearMoneda(monedaDTO monedaDTO) {
        moneda moneda = new moneda();
        moneda.setNombre(monedaDTO.getNombre());
        moneda.setValor(monedaDTO.getValor());
        return monedaRepository.save(moneda);
    }
    
    public moneda actualizarMoneda(int id, monedaDTO monedaDTO) {
        moneda moneda = monedaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la moneda con el ID proporcionado"));
        moneda.setNombre(monedaDTO.getNombre());
        moneda.setValor(monedaDTO.getValor());
        return monedaRepository.save(moneda);
    }
    
    public void eliminarMoneda(int id) {
        moneda moneda = monedaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la moneda con el ID proporcionado"));
        monedaRepository.delete(moneda);
    }
    
    public moneda obtenerMonedaPorId(int id) {
        return monedaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la moneda con el ID proporcionado"));
    }
    
    public List<moneda> obtenerTodasLasMonedas() {
        return monedaRepository.findAll();
    }

    public Optional<moneda> findById(int id) {
        return monedaRepository.findById(id);
    }
    
    
    
}
