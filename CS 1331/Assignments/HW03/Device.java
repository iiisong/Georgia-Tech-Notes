/**
* Creates Abstract Devices.
*
* @author iiisong
* @version 1
*/
public abstract class Device {
    private final int serialNumber;
    protected final int cpuCapacity;
    protected int cpuRemaining;
    protected Task[] tasks;

    /**
     * Main Device Constructor.
     *
     * @param serialNumber serial number of device
     * @param cpuCapacity cpu capacity
     * @param length number of task it can handle
     */
    public Device(int serialNumber, int cpuCapacity, int length) {
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        this.cpuRemaining = cpuCapacity;
        this.tasks = new Task[length];
    }

    /**
     * Chains to main constructor.
     *
     * @param serialNumber serial number
     * @param length number of tasks it can handle
     */
    public Device(int serialNumber, int length) {
        this(serialNumber, 512, length);
    }

    /**
     * Abstract task addable.
     *
     * @param task task
     * @return addable or not
     */
    public abstract boolean canAddTask(Task task);

    /**
     * adds task.
     *
     * @param task task
     * @return task added or not
     */
    public abstract boolean addTask(Task task);


    /**
     * Remove task from tasks.
     *
     * @param task tas to remove
     * @return whether removed task or not
     */
    public boolean processTask(Task task) {
        if (task == null) {
            return false;
        }

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && task.equals(tasks[i])) {
                tasks[i] = null;
                cpuRemaining += task.cpuCost;
                System.out.printf("Processed: %s\n", task.toString());
                return true;
            }
        }

        return false;
    }


    /**
     * Overrides default equals.
     *
     * @param obj object to compare
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Device)) {
            return false;
        }

        return serialNumber == ((Device) obj).serialNumber
                && cpuCapacity == ((Device) obj).cpuCapacity
                && cpuRemaining == ((Device) obj).cpuRemaining;
    }

    /**
     * Overrides default String.
     *
     * @return String
     */
    public String toString() {
        return String.format("Device with serial number %d has %d of %d CPU remaining.",
                                serialNumber, cpuCapacity, cpuRemaining);
    }
}
