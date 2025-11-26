/* FCFS.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.scheduling.policies;

import java.util.concurrent.ConcurrentLinkedQueue;
import scheduler.processing.SimpleProcess;

public class FCFS extends Policy {
    private ConcurrentLinkedQueue<SimpleProcess> queue;

    public FCFS() {
        this.queue = new ConcurrentLinkedQueue<>();
    }

    public String getPolicyName() {
        return "FIRST COME FIRST SERVED";
    }

    public void enqueue(SimpleProcess process) {
        queue.add(process);
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
        String result = "Queue [";
        boolean first = true;
        for (SimpleProcess p : queue) {
            if (!first) result += " -> ";
            result += p.getId() + "(" + p.getProcessType() + ")";
            first = false;
        }
        result += "]";
        return result;
    }
}
