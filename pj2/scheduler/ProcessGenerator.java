/* ProcessGenerator.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

package scheduler;

import scheduler.processing.*;

// Clase generadora de procesos que crea
//  procesos aleatorios con tiempos de llegada e intervalos configurables.
public class ProcessGenerator {
    private int processCounter;
    private double arithmeticTime;
    private double ioTime;
    private double conditionalTime;
    private double loopTime;
    private double minArrivalInterval;
    private double maxArrivalInterval;

    // Método: ProcessGenerator
    // Parámetros: 7 doubles 
    // Retorna: void 
    // Inicializa los parámetros de generación de procesos.
    public ProcessGenerator(double arithTime, double ioTime, double condTime, double loopTime,
                           double minInterval, double maxInterval) {
        this.processCounter = 0;
        this.arithmeticTime = arithTime;
        this.ioTime = ioTime;
        this.conditionalTime = condTime;
        this.loopTime = loopTime;
        this.minArrivalInterval = minInterval;
        this.maxArrivalInterval = maxInterval;
    }

    // Método: generateProcess 
    // Retorna: SimpleProcess 
    // Genera y retorna un proceso aleatorio con ID único.
    public SimpleProcess generateProcess() {
        processCounter++;
        int type = (int) (Math.random() * 4);
        
        if (type == 0) return new ArithmeticProcess(processCounter, arithmeticTime);
        if (type == 1) return new IOProcess(processCounter, ioTime);
        if (type == 2) return new ConditionalProcess(processCounter, conditionalTime);
        return new LoopProcess(processCounter, loopTime);
    }

    // Método: getNextArrivalInterval 
    // Retorna: double 
    // Retorna un intervalo aleatorio entre min y max.
    public double getNextArrivalInterval() {
        return minArrivalInterval + (Math.random() * (maxArrivalInterval - minArrivalInterval));
    }

    // Método: getProcessCounter
    // Retorna: int 
    // Retorna el contador total de procesos generados.
    public int getProcessCounter() {
        return processCounter;
    }
}
