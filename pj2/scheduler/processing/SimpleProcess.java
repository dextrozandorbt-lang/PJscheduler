/* SimpleProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;

public abstract class SimpleProcess {
    protected int id;
    protected double serviceTime;
    protected String processType;

    public SimpleProcess(int id, double serviceTime, String processType) {
        this.id = id;
        this.serviceTime = serviceTime;
        this.processType = processType;
    }

    public int getId() {
        return id;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public String getProcessType() {
        return processType;
    }

    public String toString() {
        return "ID:" + id + "|" + serviceTime + "s|" + processType;
    }
}
