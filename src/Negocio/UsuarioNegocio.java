/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import AccesoDatos.IUsuariosData;
import AccesoDatos.UsuariosData;
import Entidades.Excepciones.UsuariosExcepciones;
import Entidades.Usuarios;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioNegocio {
    private final IUsuariosData usuarioData;
    public UsuarioNegocio(){
    usuarioData = new UsuariosData();
    }
 public UsuarioNegocio(IUsuariosData usuarioData) {
        this.usuarioData = usuarioData;
    }
    
    public List<Usuarios> consultarTodosLosUusarios() throws UsuariosExcepciones, Exception {
       return usuarioData.consultarTodosLosUsuarios();
   }

    public Usuarios consultarUsuarios(Usuarios usuarios) throws UsuariosExcepciones, Exception {
        return usuarioData.consultarUsuarios(usuarios);
    }
    
    public String insertar (Usuarios usuarios) throws UsuariosExcepciones, Exception{
        return usuarioData.insertar(usuarios);
    }
    
    public String actualizar (Usuarios usuarios) throws UsuariosExcepciones, Exception{
        return  usuarioData.actualizar(usuarios);
    }
    
    public String eliminar (Usuarios usuarios) throws UsuariosExcepciones, Exception{
        return usuarioData.eliminar(usuarios);
    }

   
}
