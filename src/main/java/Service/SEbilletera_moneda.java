/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dto.billeteraDTO;
import Dto.billetera_monedaDTO;
import Entity.billetera;
import Entity.billetera_moneda;
import Entity.moneda;
import Repository.REbilletera_moneda;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SEbilletera_moneda {
    
    private final billetera_monedaDTO billemonedadto;
    private final SEmoneda semoneda;
    private final SEbilletera sebilletera;
    private final REbilletera_moneda billeteraMonedaRepository;
    
    @Autowired
    public SEbilletera_moneda(REbilletera_moneda billeteraMonedaRepository, SEbilletera sebilletera, billetera_monedaDTO billemonedadto, SEmoneda semoneda ) {
        this.billeteraMonedaRepository = billeteraMonedaRepository;
        this.sebilletera = sebilletera;
        this.billemonedadto = billemonedadto;
        this.semoneda = semoneda;
    }
    
   public billetera_moneda crearBilleteraMoneda(billetera_monedaDTO billeteraMonedaDTO) {
       
        billeteraDTO billetera = sebilletera.obtenerBilleteraPorId(billeteraMonedaDTO.getBilleteraId());
        moneda moneda = semoneda.obtenerMonedaPorId(billeteraMonedaDTO.getMonedaId());

        billetera_moneda billeteraMoneda = new billetera_moneda();       
        billeteraMoneda.setBilletera(billetera);
        billeteraMoneda.setMoneda(moneda);

        return billeteraMonedaRepository.save(billeteraMoneda);
    }
   
   public billetera_moneda obtenerBilleteraMonedaPorId(int id) {
        Optional<billetera_moneda> optionalBilleteraMoneda = billeteraMonedaRepository.findById(id);
        return optionalBilleteraMoneda.orElse(null);
    }

    public List<billetera_moneda> obtenerBilleterasMonedasPorBilleteraId(int billeteraId) {
        return billeteraMonedaRepository.findByBilleteraId(billeteraId);
    }

    public void eliminarBilleteraMoneda(int id) {
        billeteraMonedaRepository.deleteById(id);
    }
    

    
}


