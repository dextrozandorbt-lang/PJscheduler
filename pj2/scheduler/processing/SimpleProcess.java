/* SimpleProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;

/*Clase: SimpleProcess
  su Descripsion es que representa un proceso con base ID, su tiempo de servicio y Tipo de */

public abstract class SimpleProcess {
    protected int id;
    protected double serviceTime;
    protected String processType;

        /*Metodo: SimpleProcess
      Parametros: id,  serviceTime,  processType
      No Retrona nada 
      y representa un proceso de base ID y su tiempo de servicio y Tipo */

    public SimpleProcess(int id, double serviceTime, String processType) {
        this.id = id;
        this.serviceTime = serviceTime;
        this.processType = processType;
    }

        /*Metodo: getId
      No tiene Parametros
      retorna un int
      Devuelve la id del proceso */

    public int getId() {
        return id;
    }

        /*Metodo: getServTime
      No tiene parametros
      Retorna un double
      Devuelve el tiempo de servicio del proceso */

    public double getServiceTime() {
        return serviceTime;
    }

        /*Metodo: getProcessType
      No tiene parametros
      Retorna un String
      Y devuelve un Tipo de Proceso */

    public String getProcessType() {
        return processType;
    }

    /*Metodo: toString
      No tiene parametros
      Retorna un String
      Despliega todo */

    public String toString() {
        return "ID:" + id + "|" + serviceTime + "s|" + processType;
    }
}
