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

public class Processor implements Runnable {
    private Policy policy;
    private boolean running;
    private double totalServiceTime;
    private int processedCount;
    private SimpleProcess currentProcess;
    private double quantum;
    private boolean isPaused;

    public Processor(Policy policy, double quantum) {
        this.policy = policy;
        this.quantum = quantum;
        this.running = false;
        this.totalServiceTime = 0;
        this.processedCount = 0;
        this.currentProcess = null;
        this.isPaused = false;
    }

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

    public void stop() {
        running = false;
    }

    public synchronized void pause() {
        isPaused = true;
    }

    public synchronized void resume() {
        isPaused = false;
        notifyAll();
    }

    public boolean isRunning() {
        return running;
    }

    public SimpleProcess getCurrentProcess() {
        return currentProcess;
    }

    public int getProcessedCount() {
        return processedCount;
    }

    public double getTotalServiceTime() {
        return totalServiceTime;
    }

    public double getAverageServiceTime() {
        if (processedCount == 0) return 0;
        return totalServiceTime / processedCount;
    }
}
