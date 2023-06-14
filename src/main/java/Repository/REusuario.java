/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;


import Entity.usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lucas
 */
public interface REusuario extends JpaRepository<usuario, Integer> {
    usuario findByDni (String dni);
    usuario findById(int id);
    
    List <usuario> findByLastName(String lastnombre);
    
     usuario findByEmail(String email);
     usuario findByNumero(String numero);
    
}
