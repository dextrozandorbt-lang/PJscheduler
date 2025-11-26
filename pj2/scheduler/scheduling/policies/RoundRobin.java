/* RoundRobin.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.scheduling.policies;

import java.util.concurrent.ConcurrentLinkedQueue;
import scheduler.processing.RRProcess;
import scheduler.processing.SimpleProcess;

public class RoundRobin extends Policy {
    private ConcurrentLinkedQueue<RRProcess> queue;
    private double quantum;

    public RoundRobin(double quantum) {
        this.queue = new ConcurrentLinkedQueue<>();
        this.quantum = quantum;
    }

    public double getQuantum() {
        return quantum;
    }

    public String getPolicyName() {
        return "ROUND ROBIN";
    }

    public void enqueue(SimpleProcess process) {
        RRProcess rrProcess;
        if (process instanceof RRProcess) {
            rrProcess = (RRProcess) process;
        } else {
            rrProcess = new RRProcess(process.getId(), process.getServiceTime(), process.getProcessType());
        }
        queue.add(rrProcess);
    }

    public SimpleProcess dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public SimpleProcess peek() {
        return queue.peek();
    }

    public String displayQueue() {
        String result = "Queue RR [";
        boolean first = true;
        for (RRProcess p : queue) {
            if (!first) result += " -> ";
            result += p.getId() + "(" + p.getProcessType() + "|" + String.format("%.1f", p.getRemainingTime()) + "s)";
            first = false;
        }
        result += "]";
        return result;
    }
}
