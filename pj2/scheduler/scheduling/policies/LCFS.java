/* LCFS.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.scheduling.policies;

import java.util.Stack;
import scheduler.processing.SimpleProcess;

/** La clase LCFS funciona como una pila de platos:
El último plato que pones encima es el primero que tomas.
Aquí pasa lo mismo:
el último proceso en llegar es el primero que será atendido.**/

public class LCFS extends Policy {
    private Stack<SimpleProcess> stack;

    public LCFS() {
        this.stack = new Stack<>();
    }

    public String getPolicyName() {
        return "LAST COME FIRST SERVED";
    }

    public void enqueue(SimpleProcess process) {
        stack.push(process);
    }

    public SimpleProcess dequeue() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public SimpleProcess peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public String displayQueue() {
        String result = "Stack [";
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (i < stack.size() - 1) result += " <- ";
            SimpleProcess p = stack.get(i);
            result += p.getId() + "(" + p.getProcessType() + ")";
        }
        result += "]";
        return result;
    }
}
