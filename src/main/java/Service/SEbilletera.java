/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dto.billeteraDTO;
import Dto.monedaDTO;
import Entity.billetera;
import Entity.billetera_moneda;
import Entity.moneda;
import Entity.usuario;
import Repository.REbilletera;
import Repository.REbilletera_moneda;
import Repository.REmoneda;
import Repository.REoperaciones;
import Repository.REusuario;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;


@Service
public class SEbilletera {
    
    private final REbilletera_moneda billeteraymonedaRepository;
    private final REbilletera billeteraRepository;
    private final REoperaciones operacionRepository;
    private final REmoneda divisaService;
    private final REusuario reusuario;

    public SEbilletera(REbilletera billeteraRepository, REoperaciones operacionRepository, REmoneda divisaService,REusuario reusuario, REbilletera_moneda billeteraymonedaRepository) {
        this.billeteraRepository = billeteraRepository;
        this.operacionRepository = operacionRepository;
        this.divisaService = divisaService;
        this.reusuario = reusuario;
        this.billeteraymonedaRepository = billeteraymonedaRepository;
        
    }

   public billetera crearBilletera(billeteraDTO billeteraDTO) {
       
       usuario usuario = reusuario.findById(billeteraDTO.getUsuarioid());
       
       if (usuario == null) {
        throw new NoSuchElementException("No se encontró ningún usuario con el ID proporcionado");
    }
                  
        billetera billetera = new billetera();
        billetera.setUsuario(usuario);

        return billeteraRepository.save(billetera);

    }
   
   
    public billeteraDTO obtenerBilleteraPorId(int id) {
    billetera billetera = billeteraRepository.findById(id);
    if (billetera == null) {
        // Retornar un valor predeterminado o lanzar una excepción si es necesario
        return null;
    }

    billeteraDTO billeteraDTO = new billeteraDTO();
    billeteraDTO.setId(billetera.getId());
    billeteraDTO.setUsuarioid(billetera.getUsuario().getId());

    
    return billeteraDTO;
}
    
    
    public float consultarSaldoBilletera(int billeteraId) {
    billetera billetera = billeteraRepository.findById(billeteraId);

    if (billetera != null) {
        List<billetera_moneda> billeteraMonedas = billeteraymonedaRepository.findByBilleteraId(billeteraId);
        float saldo = 0.0f;

        for (billetera_moneda billeteraMoneda : billeteraMonedas) {
            saldo += billeteraMoneda.getBalance();
        }

        return saldo;
    } else {
        // Manejar el caso en el que la billetera no existe
        // Puedes lanzar una excepción, devolver un valor predeterminado o realizar alguna otra acción
        return 0.0f; // Ejemplo: devolver un saldo de 0.0 si la billetera no existe
    }
    
}
    
    
    public float consultarSaldoTotalUsuario(int usuarioId) {
    usuario usuario = reusuario.findById(usuarioId);

    if (usuario != null) {
        List<billetera> billeteras = billeteraRepository.findByUserId(usuarioId);
        float saldoTotal = 0.0f;

        for (billetera billetera : billeteras) {
            saldoTotal += consultarSaldoBilletera(billetera.getId());
        }

        return saldoTotal;
    } else {
        // Manejar el caso en el que el usuario no existe
        // Puedes lanzar una excepción, devolver un valor predeterminado o realizar alguna otra acción
        return 0.0f; // Ejemplo: devolver un saldo total de 0.0 si el usuario no existe
    }
    }
    
   
    public void intercambiarDivisas(billetera billeteraOrigen, billetera billeteraDestino, moneda monedaOrigen, moneda monedaDestino, float cantidad) {
        // Obtener los saldos de las monedas en las respectivas billeteras
        float saldoOrigen = obtenerSaldoMoneda(billeteraOrigen, monedaOrigen);
        float saldoDestino = obtenerSaldoMoneda(billeteraDestino, monedaDestino);
        
        // Verificar si hay suficiente saldo en la billetera de origen para realizar el intercambio
        if (saldoOrigen >= cantidad) {
            // Actualizar los saldos de las monedas en las billeteras
            actualizarSaldoMoneda(billeteraOrigen, monedaOrigen, saldoOrigen - cantidad);
            actualizarSaldoMoneda(billeteraDestino, monedaDestino, saldoDestino + cantidad);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente en la billetera de origen");
        }
    }
    
    public void depositarDivisas(billetera billetera, moneda moneda, float cantidad) {
        // Obtener el saldo actual de la moneda en la billetera
        float saldo = obtenerSaldoMoneda(billetera, moneda);
        
        // Actualizar el saldo de la moneda en la billetera
        actualizarSaldoMoneda(billetera, moneda, saldo + cantidad);
    }
    
    private float obtenerSaldoMoneda(billetera billetera, moneda moneda) {
        billetera_moneda billeteraMoneda = billeteraymonedaRepository.findByBilleteraAndMoneda(billetera, moneda)
                .orElseThrow(() -> new IllegalArgumentException("La billetera no tiene la moneda especificada"));
        
        return billeteraMoneda.getBalance();
    }
    
   private void actualizarSaldoMoneda(billetera billetera, moneda moneda, float nuevoSaldo) {
        billetera_moneda billeteraMoneda = billeteraymonedaRepository.findByBilleteraAndMoneda(billetera, moneda)
                .orElseThrow(() -> new IllegalArgumentException("La billetera no tiene la moneda especificada"));
        
        billeteraMoneda.setBalance(nuevoSaldo);
        billeteraymonedaRepository.save(billeteraMoneda);
    }
   
   private billetera convertToEntity(billeteraDTO billeteraDTO) {
    billetera billetera = new billetera();
    billetera.setId(billeteraDTO.getId());
    // Asignar otros valores necesarios
    
    return billetera;
}

private billeteraDTO convertToDTO(billetera billetera) {
    billeteraDTO billeteraDTO = new billeteraDTO();
    billeteraDTO.setId(billetera.getId());
    // Asignar otros valores necesarios
    
    return billeteraDTO;
}

private moneda convertToEntity(monedaDTO monedaDTO) {
    moneda moneda = new moneda();
    moneda.setId(monedaDTO.getId());
    // Asignar otros atributos de moneda según corresponda
    return moneda;
}
    
    
}















