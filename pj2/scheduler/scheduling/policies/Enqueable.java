/* Enqueable.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

 /** Enqueable es una lista de promesas que dicen
  *  qué debe saber hacer una estructura donde se 
  * guardan procesos (como una fila).**/

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

public interface Enqueable {

    void enqueue(SimpleProcess process);
    /*Poner un proceso en la fila */

    SimpleProcess dequeue();
    /*Sacar el proceso que toca */

    boolean isEmpty();
    /*Saber si la fila está vacía */

    int size();
    /*Saber cuántos hay en la fila */

    SimpleProcess peek();
    /*Ver quién sigue sin sacarlo */

    String displayQueue();
    /*Devolver un texto bonito que muestre la fila */
}
