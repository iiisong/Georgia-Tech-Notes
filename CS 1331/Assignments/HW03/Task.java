/**
* Creates Tasks.
*
* @author iiisong
* @version 1
*/
public final class Task {
    public final String name;
    public final int cpuCost;

    /**
     * Task Constructor.
     *
     * @param name name of task
     * @param cpuCost cpu cost of task
     */
    public Task(String name, int cpuCost) {
        this.name = name != null ? name : "GEN_TASK";
        this.cpuCost = cpuCost >= 0 ? cpuCost : 8;
    }


    /**
     * Overrides default equals.
     *
     * @param obj object to compare
     * @return equality of two objects
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Task)) {
            return false;
        }

        return name.equals(((Task) obj).name) && cpuCost == ((Task) obj).cpuCost;
    }


    /**
     * Overrides default string.
     *
     * @return String
     */
    public String toString() {
        return String.format("%s has CPU cost of %d", name, cpuCost);
    }
}
