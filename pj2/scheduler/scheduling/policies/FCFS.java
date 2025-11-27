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

/**La clase FCFS es una política que organiza procesos como una fila del supermercado:
El primero que llega, es el primero que será atendido.
Guarda los procesos en una cola normal, donde todos esperan su turno **/

public class FCFS extends Policy {
    private ConcurrentLinkedQueue<SimpleProcess> queue;

    public FCFS() {
        this.queue = new ConcurrentLinkedQueue<>();
    }

    public String getPolicyName() {
        return "FIRST COME FIRST SERVED";
    }

    /*Meter un proceso a la fila */
    public void enqueue(SimpleProcess process) {
        queue.add(process);
    }

    /*Sacar al que va primero */
    public SimpleProcess dequeue() {
        return queue.poll();
    }

    /*Ver cuántos hay */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /*Ver si esta vacío o no */
    public int size() {
        return queue.size();
    }

    /*Ver quién sigue */
    public SimpleProcess peek() {
        return queue.peek();
    }

    /*Mostrar la fila completa */
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
