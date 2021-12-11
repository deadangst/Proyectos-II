/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Excepciones.UsuariosExcepciones;
import Entidades.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class UsuariosData implements IUsuariosData {

    @Override
    public String insertar(Usuarios usuarios) throws UsuariosExcepciones, Exception {

        String lineaUsuario = crearLineaUsuario(usuarios);
        boolean insertar = UtilidadesArchivos.grabaArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, lineaUsuario);
        if (insertar) {
            return usuarios.getUsuario();
        }
        return "Error";
    }

    @Override
    public String eliminar(Usuarios usuarios) throws UsuariosExcepciones, Exception {
        boolean eliminar = UtilidadesArchivos.eliminar(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, usuarios.getIdentificacion());
        if (eliminar) {
            return usuarios.getUsuario();
        }
        return "Error";
    }

    @Override
    public String actualizar(Usuarios usuarios) throws UsuariosExcepciones, Exception {
        String lineaUsuario = crearLineaUsuario(usuarios);
        boolean actualizar = false;
        actualizar = UtilidadesArchivos.actualizar(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, usuarios.getIdentificacion(), lineaUsuario);
        if (actualizar) {
            return usuarios.getUsuario();
        }
        return "Error";
    }

    @Override
    public Usuarios consultar(String usuarios) throws UsuariosExcepciones, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuarios> consultarTodosLosUsuarios() throws UsuariosExcepciones, Exception {
        List<Usuarios> listaUsuarioses = new ArrayList<>();
        List<String> listalineas = UtilidadesArchivos.arregloArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA);
        for (String listalinea : listalineas) {
            Usuarios usuarioTemporal = mapearUsuarios(listalinea);
            listaUsuarioses.add(usuarioTemporal);
        }
        return listaUsuarioses;
    }

    @Override
    public Usuarios consultarUsuarios(Usuarios usuarios) throws UsuariosExcepciones, Exception {
        String UsuarioLinea = UtilidadesArchivos.buscarEnArchivo(UtilidadesArchivos.ARCHIVO_USUARIOSTIENDA, usuarios.getIdentificacion());
        if (UsuarioLinea != null) {
            Usuarios UsuarioEncontrado = mapearUsuarios(UsuarioLinea);
            return UsuarioEncontrado;
        }
        return null;
    }

    private Usuarios mapearUsuarios(String lineaLinea) {
        Usuarios usuarios = new Usuarios();
        String[] datosUsuario = lineaLinea.split(UtilidadesArchivos.TOKEN);
        usuarios.setNombre(datosUsuario[0]);
        usuarios.setApellido(datosUsuario[1]);
        usuarios.setIdentificacion(datosUsuario[2]);
        usuarios.setNumeroTelefonico(Integer.parseInt(datosUsuario[3]));
        usuarios.setTipoUsuario(datosUsuario[4]);
        usuarios.setCorreoElectronico(datosUsuario[5]);
        usuarios.setUsuario(datosUsuario[6]);
        usuarios.setPassword(datosUsuario[7]);
        usuarios.setPais(datosUsuario[8]);
        usuarios.setCiudad(datosUsuario[9]);
        usuarios.setProvincia(datosUsuario[10]);
        usuarios.setCalle(datosUsuario[11]);

        return usuarios;
    }

    private String crearLineaUsuario(Usuarios usuarios) {
        StringBuilder lineaUsuario = new StringBuilder();

        lineaUsuario.append(usuarios.getNombre()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getApellido()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getIdentificacion()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getNumeroTelefonico()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getTipoUsuario()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getCorreoElectronico()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getUsuario()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getPassword()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getPais()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getCiudad()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getProvincia()).append(UtilidadesArchivos.TOKEN);
        lineaUsuario.append(usuarios.getCalle()).append(UtilidadesArchivos.TOKEN);
        
        return lineaUsuario.toString();

    }
}
