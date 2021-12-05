/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import AccesoDatos.*;
import Entidades.Excepciones.*;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TipoUsuatioNegocio {

    private final ITipoUsuarioData tpUsuarioData;

    public TipoUsuatioNegocio(ITipoUsuarioData tpUsuarioData) {
        this.tpUsuarioData = tpUsuarioData;
    }

    public TipoUsuatioNegocio() {
        tpUsuarioData = new TipoUsuarioData();
    }

    public Boolean Validar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception {
        return tpUsuarioData.Validar(tpUsuario);
    }

    public String Ingresar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception {
        return tpUsuarioData.Ingresar(tpUsuario);
    }

    public String actualizar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception {
        return tpUsuarioData.actualizar(tpUsuario);
    }

    public String eliminar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception {
        return tpUsuarioData.eliminar(tpUsuario);
    }

    public TipoUsuario consultar(String tpUsuario) throws TipoUsuarioExcepcion, Exception {
        return tpUsuarioData.consultar(tpUsuario);
    }

    public TipoUsuario consultarTpUsuario(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception {
        return tpUsuarioData.consultarTpUsuario(tpUsuario);
    }

    public List<TipoUsuario> consultarTodosLosTipoUsuario() throws TipoUsuarioExcepcion, Exception {
        return tpUsuarioData.consultarTodosLosTipoUsuario();
    }

}
