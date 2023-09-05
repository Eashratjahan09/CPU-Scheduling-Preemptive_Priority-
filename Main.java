import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 2, 2));
        processes.add(new Process("P2", 2, 1, 1));
        processes.add(new Process("P3", 1, 8, 4));
        processes.add(new Process("P4", 5, 4, 2));
        processes.add(new Process("P5", 4, 5, 3));

        PreemptivePriorityScheduler scheduler = new PreemptivePriorityScheduler(processes);
        scheduler.schedule();
    }
}