/**
* Testing Driver.
*
* @author iiisong
* @version 1
*/
public class Driver {

    /**
     * main.
     *
     * @param args inputs
     */
    public static void main(String[] args) {
        Task t1 = new Task("fee", 1);
        Task t2 = new Task("fi", 2);
        Task t3 = new Task("fi", 2);

        System.out.println(t1.equals(t2));
        System.out.println(t3.equals(t2));

        CellPhone c1 = new CellPhone(1234, 5, 6);
        CellPhone c2 = new CellPhone(1111, 3, 4);

        System.out.println("add t1: " + c1.addTask(t1));
        System.out.println("add t2: " + c1.addTask(t2));
        System.out.println("process t2: " + c1.processTask(t2)); // should print true
        System.out.println("process t2: " + c1.processTask(t2)); // should print true

        CellPhone a = new CellPhone(0, 0);
        System.out.println(a instanceof Device);
    }
}
