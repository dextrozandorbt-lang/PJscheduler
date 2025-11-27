/* RRProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;

/*Clase: RRProcess
  Es un proceso usado en Round Robin, donde es el tiempo restante */

public class RRProcess extends SimpleProcess {
    private double remainingTime;

    /*Metodo: RRProcess
      Parametros: id,  servTime,  processType
      No retorna nada
      Su Funcón es crear un Proceso RR y establece el tiempo restante igual al servicio*/

    public RRProcess(int id, double serviceTime, String processType) {
        super(id, serviceTime, processType);
        this.remainingTime = serviceTime;
    }

    /*Metodo: getRemainingTime
      No tiene parametros
      retorna un double
      Su funcion es devolver el tiempo restante del proceso */

    public double getRemainingTime() {
        return remainingTime;
    }

       /*Metodo: setRemainingTime
      Parametro: resTime
      No retorna nada
      Su funcion es asignar un nuevo tiempo restante*/

    public void setRemainingTime(double remainingTime) {
        this.remainingTime = remainingTime;
    }

     /*Metodo: processQuantum
      Parametro: quantum
      No retorna nada
      Su funcion es reducir el tiempo restante según el quantum*/

    public void processQuantum(double quantum) {
        this.remainingTime -= quantum;
        if (this.remainingTime < 0) {
            this.remainingTime = 0;
        }
    }

        /*Metodo: isComplete
      No tiene parametro
      Retorna un boolean
      Su funcion es que indica que el proceso ya a terminado */

    public boolean isComplete() {
        return remainingTime <= 0;
    }
}
