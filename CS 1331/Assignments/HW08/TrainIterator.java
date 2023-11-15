import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates TrainIterator.
 * @author iiisong
 * @version 1.0.0
 * @param <T> type of cargo
 */
public class TrainIterator<T> implements Iterator<T> {
    private TrainCar<T> nextCar;

    /**
     * TrainIterator constructor.
     *
     * @param train train
     * @throws IllegalArgumentException starting car cannot be null
     */
    public TrainIterator(Train<T> train) {
        if (train == null) {
            throw new IllegalArgumentException("car cannot be null");
        }

        nextCar = train.getEngine();
    }

    @Override
    public boolean hasNext() {
        return nextCar != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no next traincar");
        }

        T result = nextCar.getCargo();

        nextCar = nextCar.getNextCar();

        return result;
    }
}
