/* Enqueable.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

public interface Enqueable {

    void enqueue(SimpleProcess process);

    SimpleProcess dequeue();

    boolean isEmpty();

    int size();

    SimpleProcess peek();

    String displayQueue();
}
