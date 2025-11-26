/* ProcessScheduler.java */
/**
 ** Hecho por: Michael Chang
 ** Carnet: 24000414
 ** Hecho por: Miguel Alvarado
 ** Carnet: 24001670
 ** Seccion: D
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import scheduler.ProcessGenerator;
import scheduler.Processor;
import scheduler.processing.SimpleProcess;
import scheduler.scheduling.policies.*;

public class ProcessScheduler {

    private static boolean running = true;
    private static Policy policy;
    private static Processor processor;
    private static Thread generatorThread;
    private static Thread processorThread;

    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Uso: java ProcessScheduler -politica rango_min-max arith io cond loop [quantum]");
            return;
        }

        try {
            String policyName = args[0].toLowerCase();
            String[] intervalParts = args[1].split("-");
            double minInterval = Double.parseDouble(intervalParts[0]);
            double maxInterval = Double.parseDouble(intervalParts[1]);
            double arithTime = Double.parseDouble(args[2]);
            double ioTime = Double.parseDouble(args[3]);
            double condTime = Double.parseDouble(args[4]);
            double loopTime = Double.parseDouble(args[5]);
            double quantum = (args.length > 6) ? Double.parseDouble(args[6]) : 0;

            if (policyName.equals("-fcfs")) policy = new FCFS();
            else if (policyName.equals("-lcfs")) policy = new LCFS();
            else if (policyName.equals("-rr")) policy = new RoundRobin(quantum);
            else if (policyName.equals("-pp")) policy = new PriorityPolicy();
            else return;

            ProcessGenerator generator = new ProcessGenerator(arithTime, ioTime, condTime, loopTime, minInterval, maxInterval);
            processor = new Processor(policy, quantum);

            processorThread = new Thread(processor);
            processorThread.start();

            generatorThread = new Thread(() -> {
                while (running) {
                    try {
                        double interval = generator.getNextArrivalInterval();
                        Thread.sleep((long) (interval * 1000));
                        if (!running) break;
                        SimpleProcess newProcess = generator.generateProcess();
                        synchronized (policy) {
                            policy.enqueue(newProcess);
                            System.out.println("[+] ID:" + newProcess.getId() + " " + policy.displayQueue());
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            generatorThread.start();

            System.out.println("Presione 'q' para detener\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("q")) break;
            }

            running = false;
            processor.stop();

            try {
                processorThread.join(2000);
                generatorThread.join(2000);
            } catch (InterruptedException e) {}

            System.out.println("\n==== RESUMEN ====");
            System.out.println("Política: " + policy.getPolicyName());
            System.out.println("Procesados: " + processor.getProcessedCount());
            System.out.println("En cola: " + policy.size());
            System.out.println("Promedio: " + String.format("%.2f", processor.getAverageServiceTime()) + "s");
            System.out.println("=================");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
