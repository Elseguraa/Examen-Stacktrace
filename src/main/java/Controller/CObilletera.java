/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dto.billeteraDTO;
import Entity.billetera;
import Entity.moneda;
import Entity.usuario;
import Repository.REbilletera;
import Repository.REbilletera_moneda;
import Repository.REoperaciones;
import Repository.REusuario;
import Service.SEmoneda;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billetera")
public class CObilletera {
    
    private final REbilletera_moneda billeteraMonedaRepository;
    private final REbilletera billeteraRepository;
    private final REoperaciones operacionesRepository;
    private final SEmoneda monedaService;
    private final REusuario usuarioRepository;

    @Autowired
    public CObilletera(REbilletera_moneda billeteraMonedaRepository,
                               REbilletera billeteraRepository,
                               REoperaciones operacionesRepository,
                               SEmoneda monedaService,
                               REusuario usuarioRepository) {
        this.billeteraMonedaRepository = billeteraMonedaRepository;
        this.billeteraRepository = billeteraRepository;
        this.operacionesRepository = operacionesRepository;
        this.monedaService = monedaService;
        this.usuarioRepository = usuarioRepository;
    }

    public billetera crearBilletera(Double saldoInicial) {
    billetera billetera = new billetera();
    billetera.setSaldo(saldoInicial);
    billetera.s

    try {
        billetera = billeteraRepository.save(billetera);
        System.out.println("Billetera creada con éxito. ID de billetera: " + billetera.getId());
    } catch (Exception e) {
        System.out.println("Error al crear la billetera: " + e.getMessage());
    }

    return billetera;
}

    public float consultarSaldoBilletera(int billeteraId) {
        Billetera billetera = billeteraRepository.findById(billeteraId)
                .orElse(null);

        if (billetera != null) {
            List<BilleteraMoneda> billeteraMonedas = billeteraMonedaRepository.findByBilleteraId(billeteraId);
            float saldo = 0.0f;

            for (BilleteraMoneda billeteraMoneda : billeteraMonedas) {
                saldo += billeteraMoneda.getBalance();
            }

            return saldo;
        } else {
            return 0.0f;
        }
    }

    public float consultarSaldoTotalUsuario(int usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElse(null);

        if (usuario != null) {
            List<Billetera> billeteras = billeteraRepository.findByUserId(usuarioId);
            float saldoTotal = 0.0f;

            for (Billetera billetera : billeteras) {
                saldoTotal += consultarSaldoBilletera(billetera.getId());
            }

            return saldoTotal;
        } else {
            return 0.0f;
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
}