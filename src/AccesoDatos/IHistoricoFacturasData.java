/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.*;
import Entidades.Excepciones.*;
import java.util.List;

public interface IHistoricoFacturasData {

    String insertar(HistoricoFacturas facturas) throws HistoricoFacturasExcepcion, Exception;

    List<HistoricoFacturas> consultarTodasLasFacturas() throws HistoricoFacturasExcepcion, Exception;
}
