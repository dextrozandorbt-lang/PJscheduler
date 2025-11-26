/* Policy.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

public abstract class Policy implements Enqueable {

    public abstract String getPolicyName();

    public abstract void enqueue(SimpleProcess process);

    public abstract SimpleProcess dequeue();

    public abstract boolean isEmpty();

    public abstract int size();

    public abstract SimpleProcess peek();

    public abstract String displayQueue();
}
