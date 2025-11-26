/* RRProcess.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.processing;

public class RRProcess extends SimpleProcess {
    private double remainingTime;

    public RRProcess(int id, double serviceTime, String processType) {
        super(id, serviceTime, processType);
        this.remainingTime = serviceTime;
    }

    public double getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(double remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void processQuantum(double quantum) {
        this.remainingTime -= quantum;
        if (this.remainingTime < 0) {
            this.remainingTime = 0;
        }
    }

    public boolean isComplete() {
        return remainingTime <= 0;
    }
}
