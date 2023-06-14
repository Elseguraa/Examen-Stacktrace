/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dto.usuarioDTO;
import Entity.usuario;
import Repository.REusuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SEusuario {
    
    
    @Autowired
    private REusuario reusuario;
    
    
    @Autowired
    public SEusuario(REusuario reusuario) {
        this.reusuario = reusuario;
    }
    
    
    public usuario crearUsuario(usuarioDTO usuarioDTO) {
        // Convertir UsuarioDTO a entidad Usuario
        usuario usuar = new usuario();
        usuar.setDni(usuarioDTO.getDni());
        usuar.setSexo(usuarioDTO.getSexo());
        usuar.setNombre(usuarioDTO.getNombre());
        usuar.setApellido(usuarioDTO.getApellido());
        usuar.setEmail(usuarioDTO.getEmail());
        usuar.setNumero(usuarioDTO.getNumero());

        // Guardar el usuario en la base de datos
        return reusuario.save(usuar);
    }
    
    
    public usuario actualizarUsuario(int id, usuarioDTO usuarioDTO) {
        // Verificar si el usuario existe en la base de datos
        usuario usuarioExistente = obtenerUsuarioPorId(id);
        if (usuarioExistente == null) {
            // Manejar el caso de error o lanzar una excepción
            return null;
        }

        // Actualizar los datos del usuario existente con los datos del DTO
        usuarioExistente.setDni(usuarioDTO.getDni());
        usuarioExistente.setSexo(usuarioDTO.getSexo());
        usuarioExistente.setNombre(usuarioDTO.getNombre());
        usuarioExistente.setApellido(usuarioDTO.getApellido());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setNumero(usuarioDTO.getNumero());

        // Guardar los cambios en la base de datos
        return reusuario.save(usuarioExistente);
    }
    
    
    public usuario obtenerUsuarioPorId(int id) {
    // Obtener el usuario por su ID desde la base de datos
    usuario usuario = reusuario.findById(id);
    if (usuario != null) {
        return usuario;
    } else {
        return null;
    }
}




    public usuario obtenerUsuarioPorDni(String dni) {
        // Obtener el usuario por su DNI desde la base de datos
        return reusuario.findByDni(dni);
    }

    public List<usuario> obtenerUsuariosPorApellido(String apellido) {
        // Obtener los usuarios por su apellido desde la base de datos       
        return reusuario.findByLastName(apellido);
    }

    public usuario obtenerUsuarioPorEmail(String email) {
        // Obtener el usuario por su email desde la base de datos
        return reusuario.findByEmail(email);
    }

    public usuario obtenerUsuarioPorNumero(String numero) {
        // Obtener el usuario por su número desde la base de datos
        return reusuario.findByNumero(numero);
    }
    
        
        
    
    
}
