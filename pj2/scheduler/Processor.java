/* Processor.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler;

import scheduler.processing.*;
import scheduler.scheduling.policies.*;

// Clase que ejecuta los procesos de la cola según la
// política de calendarización seleccionada.
public class Processor implements Runnable {
    private Policy policy;
    private boolean running;
    private double totalServiceTime;
    private int processedCount;
    private SimpleProcess currentProcess;
    private double quantum;
    private boolean isPaused;

    // Método: Processor 
    // Parámetros: Policy, double 
    // Retorna: void 
    // Inicializa el procesador con política y quantum.
    public Processor(Policy policy, double quantum) {
        this.policy = policy;
        this.quantum = quantum;
        this.running = false;
        this.totalServiceTime = 0;
        this.processedCount = 0;
        this.currentProcess = null;
        this.isPaused = false;
    }

    // Método: run 
    // Retorna: void 
    // Ejecuta el hilo principal que procesa los procesos de la cola.
    public void run() {
        running = true;
        while (running) {
            synchronized (this) {
                while (isPaused && running) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            if (!running) break;

            SimpleProcess processToHandle = null;
            synchronized (policy) {
                if (!policy.isEmpty()) {
                    processToHandle = policy.dequeue();
                }
            }

            if (processToHandle != null) {
                currentProcess = processToHandle;
                try {
                    if (processToHandle instanceof RRProcess) {
                        RRProcess rrProcess = (RRProcess) processToHandle;
                        double timeToProcess = Math.min(quantum, rrProcess.getRemainingTime());
                        long sleepTime = (long) (timeToProcess * 1000);
                        Thread.sleep(sleepTime);
                        rrProcess.processQuantum(timeToProcess);
                        totalServiceTime += timeToProcess;
                        
                        if (!rrProcess.isComplete()) {
                            synchronized (policy) {
                                policy.enqueue(rrProcess);
                            }
                        } else {
                            processedCount++;
                        }
                    } else {
                        long sleepTime = (long) (processToHandle.getServiceTime() * 1000);
                        Thread.sleep(sleepTime);
                        totalServiceTime += processToHandle.getServiceTime();
                        processedCount++;
                    }
                    currentProcess = null;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Método: stop
    // Retorna: void 
    // Detiene la ejecución del procesador.
    public void stop() {
        running = false;
    }

    // Método: pause 
    // Retorna: void 
    // Pausa la ejecución del procesador de forma sincronizada.
    public synchronized void pause() {
        isPaused = true;
    }

    // Método: resume 
    // Retorna: void 
    // Reanuda la ejecución del procesador pausado.
    public synchronized void resume() {
        isPaused = false;
        notifyAll();
    }

    // Método: isRunning 
    // Retorna: boolean 
    // Retorna true si el procesador está activo.
    public boolean isRunning() {
        return running;
    }

    // Método: getCurrentProcess
    // Parámetro: ninguno 
    // Retorna: SimpleProcess
    // Retorna el proceso que se está procesando actualmente.
    public SimpleProcess getCurrentProcess() {
        return currentProcess;
    }

    // Método: getProcessedCount
    // Retorna: int 
    // Retorna la cantidad de procesos completados.
    public int getProcessedCount() {
        return processedCount;
    }

    // Método: getTotalServiceTime
    // Retorna: double 
    // Retorna el tiempo total de servicio acumulado.
    public double getTotalServiceTime() {
        return totalServiceTime;
    }

    // Método: getAverageServiceTime
    // Parámetro: ninguno 
    // Retorna: double 
    // Retorna el tiempo promedio de servicio por proceso.
    public double getAverageServiceTime() {
        if (processedCount == 0) return 0;
        return totalServiceTime / processedCount;
    }
}
