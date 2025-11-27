/* PriorityPolicy.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.scheduling.policies;

import java.util.PriorityQueue;
import scheduler.processing.SimpleProcess;
import scheduler.processing.PPProcess;

public class PriorityPolicy extends Policy {
    private PriorityQueue<PPProcess> queue;

    // Método: PriorityPolicy
    // Retorna: void
    // Inicializa la cola de prioridad con comparador personalizado.
    public PriorityPolicy() {
        this.queue = new PriorityQueue<PPProcess>((p1, p2) -> {
            if (p1.getPriority() != p2.getPriority()) {
                return p1.getPriority() - p2.getPriority();
            }
            return (int)(p1.getArrivalTime() - p2.getArrivalTime());
        });
    }

    // Método: getPolicyName
    // Retorna: String
    // Retorna "PRIORITY POLICY".
    public String getPolicyName() {
        return "PRIORITY POLICY";
    }

    // Método: enqueue
    //  Parámetro: SimpleProcess
    // Retorna: void
    // Añade el proceso con prioridad aleatoria a la cola.
    public void enqueue(SimpleProcess process) {
        int priority = (int)(Math.random() * 3) + 1;
        long arrivalTime = System.currentTimeMillis();
        PPProcess ppProcess = new PPProcess(process.getId(), process.getServiceTime(), process.getProcessType(), priority, arrivalTime);
        queue.add(ppProcess);
    }

    // Método: dequeue
    // Retorna: SimpleProcess
    // Extrae el proceso con mayor prioridad.
    public SimpleProcess dequeue() {
        return queue.poll();
    }

    // Método: isEmpty
    // Retorna: boolean
    // Retorna true si la cola está vacía.
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Método: size
    // Retorna: int
    // Retorna la cantidad de procesos en la cola.
    public int size() {
        return queue.size();
    }

    // Método: peek
    // Retorna: SimpleProcess 
    // Retorna el proceso con mayor prioridad sin extraerlo.
    public SimpleProcess peek() {
        return queue.peek();
    }

    // Método: displayQueue
    // Retorna: String 
    // Retorna la cola con prioridad de cada proceso.
    public String displayQueue() {
        String result = "Queue Priority [";
        Object[] processes = queue.toArray();
        for (int i = 0; i < processes.length; i++) {
            if (i > 0) result += " -> ";
            PPProcess p = (PPProcess) processes[i];
            result += p.getId() + "(" + p.getProcessType() + "|P" + p.getPriority() + ")";
        }
        result += "]";
        return result;
    }
}
