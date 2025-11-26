/* PPProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;

public class PPProcess extends SimpleProcess {
    private int priority;
    private long arrivalTime;

    public PPProcess(int id, double serviceTime, String processType, int priority, long arrivalTime) {
        super(id, serviceTime, processType);
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public int compareTo(PPProcess other) {
        if (this.priority != other.priority) {
            return this.priority - other.priority;
        }
        return (int)(this.arrivalTime - other.arrivalTime);
    }

    public String toString() {
        return "ID:" + id + "|" + serviceTime + "s|" + processType + "|P" + priority;
    }
}
