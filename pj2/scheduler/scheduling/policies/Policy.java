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

// Clase abstracta que define la estructura base para
//  las políticas de calendarización de procesos.
public abstract class Policy implements Enqueable {

    // Método: getPolicyName
    //  Parámetro: ninguno 
    //  Retorna: String 
    //  Retorna el nombre de la política de calendarización.
    public abstract String getPolicyName();

    // Método: enqueue 
    // Parámetro: SimpleProcess 
    // Retorna: void 
    // Añade un proceso a la política según sus reglas.
    public abstract void enqueue(SimpleProcess process);

    // Método: dequeue 
    // Parámetro: ninguno 
    // Retorna: SimpleProcess
    // Extrae el siguiente proceso según la política.
    public abstract SimpleProcess dequeue();

    // Método: isEmpty
    // Retorna: boolean 
    // Verifica si no hay procesos en la política.
    public abstract boolean isEmpty();

    // Método: size
    // Retorna: int
    // Retorna el número de procesos en la política.
    public abstract int size();

    // Método: peek 
    // Retorna: SimpleProcess
    // Retorna el próximo proceso sin extraerlo.
    public abstract SimpleProcess peek();

}
