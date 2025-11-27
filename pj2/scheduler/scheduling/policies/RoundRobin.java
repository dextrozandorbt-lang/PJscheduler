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

    // Método: RoundRobin
    // Parámetro: double quantum
    // Retorna: void
    // Inicializa la cola y el cuanto de tiempo.
    public RoundRobin(double quantum) {
        this.queue = new ConcurrentLinkedQueue<>();
        this.quantum = quantum;
    }

    // Método: getQuantum 
    // Parámetro: ninguno 
    // Retorna: double 
    // Retorna el valor del cuanto de tiempo.
    public double getQuantum() {
        return quantum;
    }

    // Método: getPolicyName 
    // Parámetro: ninguno 
    // Retorna: String 
    // Retorna "ROUND ROBIN".
    public String getPolicyName() {
        return "ROUND ROBIN";
    }

    // Método: enqueue
    // Parámetro: SimpleProcess 
    // Retorna: void 
    // Añade el proceso como RRProcess a la cola.
    public void enqueue(SimpleProcess process) {
        RRProcess rrProcess;
        if (process instanceof RRProcess) {
            rrProcess = (RRProcess) process;
        } else {
            rrProcess = new RRProcess(process.getId(), process.getServiceTime(), process.getProcessType());
        }
        queue.add(rrProcess);
    }

    // Método: dequeue 
    // Parámetro: ninguno 
    // Retorna: SimpleProcess 
    // Extrae y retorna el primer proceso de la cola.
    public SimpleProcess dequeue() {
        return queue.poll();
    }

    // Método: isEmpty 
    // Parámetro: ninguno 
    // Retorna: boolean 
    // Retorna true si la cola está vacía.
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Método: size 
    // Parámetro: ninguno 
    // Retorna: int 
    // Retorna la cantidad de procesos en la cola.
    public int size() {
        return queue.size();
    }

    // Método: peek
    // Parámetro: ninguno 
    // Retorna: SimpleProcess
    // Retorna el primer proceso sin extraerlo.
    public SimpleProcess peek() {
        return queue.peek();
    }

    // Método: displayQueue 
    // Parámetro: ninguno 
    // Retorna: String 
    // Retorna la cola con tiempo restante de cada proceso.
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
