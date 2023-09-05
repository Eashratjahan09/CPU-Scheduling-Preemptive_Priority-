import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PreemptivePriorityScheduler {
    private List<Process> processes;
    private PriorityQueue<Process> readyQueue;
    private GlobalTimer timer;

    public PreemptivePriorityScheduler(List<Process> processes) {
        this.processes = processes;
        this.readyQueue = new PriorityQueue<>();
        this.timer = new GlobalTimer();
    }
    public void schedule() {
        while (!readyQueue.isEmpty() || !processes.isEmpty()) {
            // Check for processes whose arrival time is equal to or less than global time
            List<Process> arrivedProcesses = new ArrayList<>();
            for (Process process : processes) {
                if (process.getArrivalTime() <= timer.getTime()) {
                    arrivedProcesses.add(process);
                }
            }

            for (Process arrivedProcess : arrivedProcesses) {
                processes.remove(arrivedProcess);
                readyQueue.add(arrivedProcess);
            }
            timer.incrementTime();
            if (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.poll();
                System.out.println("Time " + timer.getTime() + ": Running process " + currentProcess.getName());

                if (currentProcess.getBurstTime() > 1) {
                    currentProcess = new Process(
                            currentProcess.getName(),
                            currentProcess.getArrivalTime(),
                            currentProcess.getBurstTime() - 1,
                            currentProcess.getPriority()
                    );
                    readyQueue.add(currentProcess);
                }


            } else {
                timer.incrementTime();
            }
        }
    }


}