/**
* Creates Laptop Devices.
*
* @author iiisong
* @version 1
*/
public class Laptop extends Device {
    private boolean overclockable;

    /**
     * Construct Laptop device.
     *
     * @param serialNumber serial number
     * @param cpuCapacity cpu capacity
     * @param length number of tasks it can handle
     * @param overclockable can overclock or not
     */
    public Laptop(int serialNumber, int cpuCapacity, int length, boolean overclockable) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = overclockable;
    }

    /**
     * Chain constructor.
     *
     * @param serialNumber serial number
     * @param cpuCapacity cpu capacity
     * @param length number of tasks it can handle
     */
    public Laptop(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = false;
    }


    /**
     * number of slots required.
     *
     * @param cpuRemaining cpu needed
     * @return int number of buffer slots needed
     */
    public int bufferSlotsRequired(int cpuRemaining) {
        if (tasks.length <= 4) {
            return 0;
        }

        if (cpuRemaining < 128) {
            return 2;
        }

        return 1;
    }


    /**
     * task addable.
     *
     * @param task task
     * @return boolean addable or not
     */
    public boolean canAddTask(Task task) {
        boolean needOverclock = false;

        if (task.cpuCost > cpuRemaining) {
            if (!overclockable) {
                return false;
            }

            if (task.cpuCost > cpuRemaining + cpuCapacity / 4) {
                needOverclock = true;
                return false;
            }
        }

        int slots = 0;

        for (Task t : tasks) {
            if (t == null) {
                slots++;
            }

            if (!needOverclock && slots > bufferSlotsRequired(cpuRemaining - task.cpuCost)) {
                return true;
            }

            if (needOverclock && slots > bufferSlotsRequired(cpuRemaining + cpuCapacity / 4 - task.cpuCost)) {
                return true;
            }
        }

        return false;
    }


    /**
     * adds task to tasks.
     *
     * @param task task
     * @return boolean added task?
     */
    public boolean addTask(Task task) {
        if (!canAddTask(task)) {
            return false;
        }

        if (task.cpuCost > cpuRemaining) {
            overclockable = !overclockable;
            cpuRemaining += cpuCapacity / 4;
        }

        cpuRemaining -= task.cpuCost;

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                break;
            }
        }

        return true;
    }


    /**
     * Overrides default equals.
     *
     * @param obj object to compare
     * @return boolean whether or not equal
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Device)) {
            return false;
        }

        return super.equals(obj)
                && overclockable == ((Laptop) obj).overclockable;
    }


    /**
     * Overrides default toString.
     *
     * @return String
     */
    public String toString() {
        return super.toString()
                + String.format(" This laptop %s have overclocking.",
                                overclockable ? "does" : "does not");
    }
}
