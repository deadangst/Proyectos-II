
package Negocio;

import java.util.List;
import AccesoDatos.HistoricoFacturasData;
import AccesoDatos.IHistoricoFacturasData;
import Entidades.Excepciones.HistoricoFacturasExcepcion;
import Entidades.HistoricoFacturas;


public class HistoricoFacturasNegocio {
    private final IHistoricoFacturasData facturasData;
    
    public HistoricoFacturasNegocio(){
    facturasData = new HistoricoFacturasData();
    
    }
    
    public List<HistoricoFacturas> consultarTodasLasFacturas() throws HistoricoFacturasExcepcion, Exception{    
    return facturasData.consultarTodasLasFacturas();
    }
    
    public String insertar(HistoricoFacturas facturas) throws HistoricoFacturasExcepcion, Exception{
    return facturasData.insertar(facturas);
    }
}
