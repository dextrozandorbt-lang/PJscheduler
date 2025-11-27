/* PPProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;

// Es una clase de Prioridad de procesos y tiempo de llegada de las Politicas de ejecucion


public class PPProcess extends SimpleProcess {
    private int priority;
    private long arrivalTime;

        /*Metodo: PPProcess 
      Parametros: id,  serviceTime,  processType,  priority,  LlegadTime 
      No retorna nada y su Funcion es que crea un proceso con prioridad y tiempo de llegada
      */

    public PPProcess(int id, double serviceTime, String processType, int priority, long arrivalTime) {
        super(id, serviceTime, processType);
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    /*Metodo: getPriority 
      Parametros no tiene
      Retorna un int y Devuelve la prioridad del Proceso*/

    public int getPriority() {
        return priority;
    }

    /*Metodo: getLlegadTime
      Parametros no tiene
      Retorna un long y Devuelve el tiempo de llegada del Proceso */

    public long getArrivalTime() {
        return arrivalTime;
    }
        /*Metodo: compareTo
      parametros son PPProcess otro
      Retorna un int
      Su función es comparar procesos por prioridad y luego su tiempo de llegada
       */

    public int compareTo(PPProcess other) {
        if (this.priority != other.priority) {
            return this.priority - other.priority;
        }
        return (int)(this.arrivalTime - other.arrivalTime);
    }

    /*Metodo: toString
      No tiene parametros
      Retorna un String 
      Su funcion pues es que Devuelve una representacion del proceso,
      una version diferente en ves de poner ("ID: %d | servicio...") */

    public String toString() {
        return "ID:" + id + "|" + serviceTime + "s|" + processType + "|P" + priority;
    }
}
