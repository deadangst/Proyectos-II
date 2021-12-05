
package AccesoDatos;

import Entidades.Excepciones.HistoricoFacturasExcepcion;

import Entidades.HistoricoFacturas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HistoricoFacturasData implements IHistoricoFacturasData {

private String NumeroFactura() {
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cadena = "";
        int numero;
        int forma;
        forma = (int) (aleatorio.nextDouble() * alfa.length() - 1 + 0);
        numero = (int) (aleatorio.nextDouble() * 99 + 100);
        cadena = cadena + alfa.charAt(forma) + alfa.charAt(forma) + "-" + numero;
        return cadena;
    }

    @Override
    public String insertar(HistoricoFacturas facturas) throws HistoricoFacturasExcepcion, Exception {
        facturas.setCodigoFactura(NumeroFactura());
        String lineafactura = creaLineaFacturas(facturas);
        boolean inserta = UtilidadesArchivos.grabaArchivo(UtilidadesArchivos.ARCHIVO_HISTORICO, lineafactura);
        if (inserta) {
            return facturas.getCodigoFactura();
        }
        return "Error";
    }

    @Override
    public List<HistoricoFacturas> consultarTodasLasFacturas() throws HistoricoFacturasExcepcion, Exception {
        List<HistoricoFacturas> listaFacturas = new ArrayList<>();
        List<String> listaLineas = UtilidadesArchivos.arregloArchivo(UtilidadesArchivos.ARCHIVO_HISTORICO);
        for (String listaLinea : listaLineas) {
            HistoricoFacturas productoTemporal = mapeaLineaFacturas(listaLinea);
            listaFacturas.add(productoTemporal);
        }
        return listaFacturas;
    }

    private String creaLineaFacturas(HistoricoFacturas facturas) {
        StringBuilder lineaFacturas = new StringBuilder();
        lineaFacturas.append(facturas.getCodigoFactura()).append(UtilidadesArchivos.TOKEN);
        lineaFacturas.append(facturas.getUsuario()).append(UtilidadesArchivos.TOKEN);
        lineaFacturas.append(facturas.getTotal()).append(UtilidadesArchivos.TOKEN);
        lineaFacturas.append(facturas.getCostoEnvio()).append(UtilidadesArchivos.TOKEN);
        lineaFacturas.append(facturas.getIva()).append(UtilidadesArchivos.TOKEN);
        lineaFacturas.append(facturas.getTotalFinal()).append(UtilidadesArchivos.TOKEN);
        lineaFacturas.append(facturas.getHoraCompra()).append(UtilidadesArchivos.TOKEN);
        return lineaFacturas.toString();
    }

    private HistoricoFacturas mapeaLineaFacturas(String lineaLinea) {
        HistoricoFacturas facturas = new HistoricoFacturas();
        String[] datosFactura = lineaLinea.split(UtilidadesArchivos.TOKEN);
        facturas.setCodigoFactura(datosFactura[0]);
        facturas.setUsuario(datosFactura[1]);
        facturas.setTotal(Double.parseDouble(datosFactura[2]));
        facturas.setCostoEnvio(Double.parseDouble(datosFactura[3]));
        facturas.setIva(Double.parseDouble(datosFactura[4]));
        facturas.setTotalFinal(Double.parseDouble(datosFactura[5]));
        facturas.setHoraCompra(LocalDateTime.parse(datosFactura[6]));

        return facturas;
    }
    
}
