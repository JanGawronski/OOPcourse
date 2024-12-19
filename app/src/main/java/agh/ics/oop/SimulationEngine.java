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
        for (Simulation simulation : simulations)
            simulation.run();
    }

    public void runAsync() {
        for (Simulation simulation : simulations) {
            Thread thread = new Thread(simulation);
            threads.add(thread);
            thread.start();
        }
    }

    public void runAsyncInThreadPool() {
        for (Simulation simulation : simulations)
            threadPool.submit(simulation);
        threadPool.shutdown();
    }

    public void awaitSimulationsEnd() throws InterruptedException{
        for (Thread thread : threads)
            thread.join();
        threads.clear();

        if (!threadPool.awaitTermination(10, TimeUnit.SECONDS))
            threadPool.shutdownNow();
    }
}
