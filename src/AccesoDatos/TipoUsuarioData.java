/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Excepciones.TipoUsuarioExcepcion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class TipoUsuarioData implements ITipoUsuarioData{

  

    public  TipoUsuario consultarTipoUsuario(TipoUsuario tpUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  List<TipoUsuario> consultarTodosLosTipoUsuario() throws TipoUsuarioExcepcion, Exception{
          List<TipoUsuario> listaTipoUsuario = new ArrayList<>();
        List<String> listaLineas = UtilidadesArchivos.arregloArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA);
        for (String listaLinea : listaLineas) {
            TipoUsuario TpUsuarioTemporal = mapearLineaTipoUsuario(listaLinea);
            listaTipoUsuario.add(TpUsuarioTemporal);
        }
        return listaTipoUsuario;
        
    }

    private TipoUsuario mapearLineaTipoUsuario(String ListaLInea) {
        TipoUsuario tpUsuario = new TipoUsuario();
        String[] TipoUsuarioEncontrado = ListaLInea.split(UtilidadesArchivos.TOKEN);
        tpUsuario.setAdministrador(TipoUsuarioEncontrado[0]);
        tpUsuario.setCliente(TipoUsuarioEncontrado[1]);
        tpUsuario.setEmpleado(TipoUsuarioEncontrado[2]);
        tpUsuario.setGerente(TipoUsuarioEncontrado[3]);
        
        
        return tpUsuario;

    }
    public Boolean Validar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception{
    
        try{
            String lineaTpUsuario = UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, tpUsuario.getAdministrador());
        
        
        }catch (Exception e){
        }
        
        try{
          String lineaTpUsuario =UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, tpUsuario.getCliente());
        
        }catch(Exception e){
        
        }
        
          try{
          String lineaTpUsuario =UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, tpUsuario.getEmpleado());
        
        }catch(Exception e){
        
        }
            try{
          String lineaTpUsuario =UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, tpUsuario.getAdministrador());
        
        }catch(Exception e){
        
        }
        return null;
    
    }
   

    public String eliminar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception {
        boolean eliminar = UtilidadesArchivos.eliminar(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, tpUsuario.getGerente());
        
        if (eliminar) {
            return tpUsuario.getAdministrador();
        }
            if(eliminar){
            return tpUsuario.getGerente();
            }
            if(eliminar){
            return tpUsuario.getEmpleado();
            }
            if(eliminar){
            return tpUsuario.getCliente();
            }
        
        return "Error";

    }




    public List<TipoUsuario> consultarTodosLostiposUsuario() throws TipoUsuarioExcepcion, Exception {
        List<TipoUsuario> listaTipoUsuario = new ArrayList<>();
        List<String> listaLineas = UtilidadesArchivos.arregloArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA);
        for (String listaLinea : listaLineas) {
            TipoUsuario TpUsuarioTemporal = mapearLineaTipoUsuario(listaLinea);
            listaTipoUsuario.add(TpUsuarioTemporal);
        }

        return listaTipoUsuario;
    }

    @Override
    public TipoUsuario consultarTpUsuario(TipoUsuario tipoUsuario) throws TipoUsuarioExcepcion, Exception {
        String tipoUsuarioLinea = UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, tipoUsuario.getAdministrador());
        if (tipoUsuarioLinea != null) {
            TipoUsuario tipoUsuarioEncontrado = mapearLineaTipoUsuario(tipoUsuarioLinea);
            return tipoUsuarioEncontrado;
        }
        return null;
    }

    @Override
  public String Ingresar(TipoUsuario tpUsuario) throws Exception{
         tpUsuario.setAdministrador(tpUsuario.getAdministrador());
        String lineatpUsuario = creaLineaUsuario(tpUsuario);
        boolean inserta = UtilidadesArchivos.grabaArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, lineatpUsuario);
        if (inserta) {
            return tpUsuario.getAdministrador();
        }
        return "Error";
       

   }


    private String creaLineaUsuario(TipoUsuario tpUsuario) {
        StringBuilder lineaTpUsuario = new StringBuilder();
        lineaTpUsuario.append(tpUsuario.getNombres()).append(UtilidadesArchivos.TOKEN);
        lineaTpUsuario.append(tpUsuario.getApellido()).append(UtilidadesArchivos.TOKEN);
        lineaTpUsuario.append(tpUsuario.getIdentificacion()).append(UtilidadesArchivos.TOKEN);
        lineaTpUsuario.append(tpUsuario.getPassword()).append(UtilidadesArchivos.TOKEN);
        

        return lineaTpUsuario.toString();
    }

    @Override
    public String actualizar(TipoUsuario tpUsuario) throws TipoUsuarioExcepcion, Exception {
        String lineaTipoUsuario = creaLineaUsuario(tpUsuario);
        boolean actualizar = false;
        actualizar = UtilidadesArchivos.actualizar(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, tpUsuario.getGerente(), lineaTipoUsuario);
        if (actualizar) {
            return tpUsuario.getGerente();
        }
         if (actualizar) {
            return tpUsuario.getAdministrador();
        }
            if(actualizar){
            return tpUsuario.getGerente();
            }
            if(actualizar){
            return tpUsuario.getEmpleado();
            }
            if(actualizar){
            return tpUsuario.getCliente();
            }
        
        return "Error";

  }

    @Override
    public TipoUsuario consultar(String tpUsuario) throws TipoUsuarioExcepcion, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
