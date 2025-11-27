/* IOProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;

// Representa el proceso IO (Input/Output) del programa y se representa con una marca "IO"

public class IOProcess extends SimpleProcess {

    //Este metodo tiene los Sigueintes Parametros
    /*la id (identificador del proceso) 
    El double serviceTime (Tiempo del servicio del proceso
    En resumen crea una Instancia de AritmeticProcess con un id y tiempo de servicio con una marca que es "IO"*/

    public IOProcess(int id, double serviceTime) {
        super(id, serviceTime, "IO");
    }
}
