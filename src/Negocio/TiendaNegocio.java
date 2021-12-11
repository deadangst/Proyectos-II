 
package Negocio;

import AccesoDatos.ITiendaData;
import AccesoDatos.TiendaData;
import Entidades.Excepciones.TiendaExcepcion;
import Entidades.Tienda;
import java.util.List;


public class TiendaNegocio {
    private final ITiendaData tiendaData;
    
    public TiendaNegocio(){
    tiendaData = new TiendaData();
    
    }
    
    public List<Tienda> consultarTodasLasVentas() throws TiendaExcepcion, Exception{
    return tiendaData.consultarTodasLasVentas();
    
    }
    
        public String insertar(Tienda tienda) throws TiendaExcepcion, Exception {
        return tiendaData.insertar(tienda);
    }
        
        public String eliminar(Tienda tienda) throws TiendaExcepcion, Exception {
        return tiendaData.eliminar(tienda);
    }    
        
            public String actualizar(Tienda tienda) throws TiendaExcepcion, Exception {
        return tiendaData.actualizar(tienda);
    }    
    
    
}
