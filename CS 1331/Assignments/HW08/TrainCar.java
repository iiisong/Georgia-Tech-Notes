/**
 * Creates TrainCar.
 * @author iiisong
 * @version 1.0.0
 * @param <T> type of cargo
 */
public class TrainCar<T> {
    private T cargo;
    private TrainCar<T> nextCar;

    /**
     * Main TrainCar Constructor.
     *
     * @param cargo cargo of type T
     * @param nextCar next car connected
     * @throws IllegalArgumentException cargo cannot be null
     */
    public TrainCar(T cargo, TrainCar<T> nextCar) {
        if (cargo == null) {
            throw new IllegalArgumentException("cargo cannot be null");
        }

        this.cargo = cargo;
        this.nextCar = nextCar;
    }

    /**
     * Chain constructor.
     *
     * @param cargo cargo of type T
     */
    public TrainCar(T cargo) {
        this(cargo, null);
    }

    /**
     * cargo getter.
     *
     * @return cargo
     */
    public T getCargo() {
        return cargo;
    }

    /**
     * nextCar getter.
     *
     * @return nextCar
     */
    public TrainCar<T> getNextCar() {
        return nextCar;
    }

    /**
     * cargo getter.
     *
     * @param cargo new cargo
     */
    public void setCargo(T cargo) {
        this.cargo = cargo;
    }

    /**
     * nextCar getter.
     *
     * @param nextCar new nextCar
     */
    public void setNextCar(TrainCar<T> nextCar) {
        this.nextCar = nextCar;
    }
}
