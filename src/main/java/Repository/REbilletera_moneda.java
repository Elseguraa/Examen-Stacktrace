/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.billetera;
import Entity.billetera_moneda;
import Entity.moneda;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Lucas
 */
public interface REbilletera_moneda extends JpaRepository <billetera_moneda, Integer> {
    List<billetera_moneda> findByBilleteraId(int billeteraId);
    
    @Query("SELECT bm FROM billetera_moneda bm WHERE bm.billetera = :billetera AND bm.moneda = :moneda")
    Optional<billetera_moneda> findByBilleteraAndMoneda(@Param("billetera") billetera billetera, @Param("moneda") moneda moneda);

}
