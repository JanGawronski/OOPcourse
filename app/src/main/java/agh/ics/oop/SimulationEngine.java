package agh.ics.oop;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class SimulationEngine {
    private final List<Simulation> simulations;
    private final List<Thread> threads = new ArrayList<>();
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        for (Simulation simulation : simulations) {
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
        awaitSimulationsEnd();
    }

    public void runAsyncInThreadPool() {
        for (Simulation simulation : simulations)
            threadPool.submit(simulation);
        awaitSimulationsEnd();
    }

    public void awaitSimulationsEnd() {
        try {
            for (Thread thread : threads)
                thread.join();
            threads.clear();

            threadPool.shutdown();
            if (!threadPool.awaitTermination(10, TimeUnit.SECONDS))
                threadPool.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
