/* ArithmeticProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;
// la clase ArithmeticProcess es un proceso pues aritmetico que hereda de SimpleProcess y se identifica con la marca "A"

public class ArithmeticProcess extends SimpleProcess {
        // Este metodo tiene de Parametros:
    // la id (identificador del proceso)
    // double serviceTime (Tiempo de servicio que tiene el proceso)
    // En resumen crea una Instancia de AritmeticProcess con un id y tiempo de servicio con una marca que


    public ArithmeticProcess(int id, double serviceTime) {
        super(id, serviceTime, "A");
    }
}
