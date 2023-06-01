
/**
* Creates CellPhones Devices.
*
* @author iiisong
* @version 1
*/
public class CellPhone extends Device {
    private int tasksCompleted = 0;

    /**
     * Construct Cellphone.
     *
     * @param serialNumber serial number of cellphone
     * @param cpuCapacity cpu capacity
     * @param length number of tasks it can handle
     */
    public CellPhone(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
    }

    /**
     * Chain constructor.
     *
     * @param serialNumber serial number
     * @param cpuCapacity cpu capacity
     */
    public CellPhone(int serialNumber, int cpuCapacity) {
        super(serialNumber, cpuCapacity, 10);
    }

    /**
     * Check task addable.
     *
     * @param task to add
     * @return whether or not can add
     */
    public boolean canAddTask(Task task) {
        if (cpuRemaining < task.cpuCost) {
            return false;
        }

        for (Task t : tasks) {
            if (t == null) {
                return true;
            }
        }

        return false;
    }


    /**
     * add task to tasks.
     *
     * @param task to add
     * @return added or not
     */
    public boolean addTask(Task task) {
        if (!canAddTask(task)) {
            return false;
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
     * Removes task from tasks.
     *
     * @param task to remove
     * @return whether task removed
     */
    public boolean processTask(Task task) {
        if (task == null) {
            return false;
        }

        if (super.processTask(task)) {
            tasksCompleted += 1;
            return true;
        }

        return false;
    }


    /**
     * Overries default equals.
     *
     * @param obj object to compare
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Device)) {
            return false;
        }

        return super.equals(obj)
                && tasksCompleted == ((CellPhone) obj).tasksCompleted;
    }


    /**
     * Override default toString.
     *
     * @return String
     */
    public String toString() {
        return super.toString().substring(0, super.toString().length())
                + String.format(" It has completed %d tasks.", tasksCompleted);
    }
}
