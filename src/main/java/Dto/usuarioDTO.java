
package Dto;



public class usuarioDTO {
    
    private int id;
    private String dni;
    private String sexo;
    private String nombre;
    private String apellido;
    private String email;
    private String numero;

    public usuarioDTO() {
    }

    public usuarioDTO(int id,String dni, String sexo, String nombre, String apellido, String email, String numero) {
        this.dni = dni;
        this.sexo = sexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
