import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates Train.
 * @author iiisong
 * @version 1.0.0
 * @param <T> type of cargo
 */
public class Train<T> implements List<T> {
    private TrainCar<T> engine;
    private int size;

    /**
     * Chain Constructor Train.
     */
    public Train() {
        engine = null;
        size = 0;
    }

    /**
     * Main Constructor Train.
     *
     * @param cargoArray array of cargo
     */
    public Train(T[] cargoArray) {
        if (cargoArray == null) {
            throw new IllegalArgumentException("cargoArray cannot be null");
        }

        size = 0;
        for (T cargo : cargoArray) {
            if (cargo == null) {
                throw new IllegalArgumentException("cargo cannot be null");
            }
            add(cargo); // keep adding to end
        }
    }

    /**
     * Get start of LinkedList.
     *
     * @return head (engine)
     */
    public TrainCar<T> getEngine() {
        return engine;
    }

    /**
     * Converts LinkedList of traincars to array of cargo.
     *
     * @return array of cargo
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[size];

        Iterator<T> itr = iterator();
        int i = 0;

        while (itr.hasNext()) {
            result[i] = itr.next();
            i += 1;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== TRAIN %d =====\nisEmpty: %s\nsize: %d\nengine: %s\nCHOO CHOO: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (engine == null ? "null" : engine.getCargo())));

        T[] cargo = toArray();

        if (cargo == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < cargo.length - 1; ++i) {
                sb.append(String.format("%s, ", cargo[i])); // append all but last value
            }
            if (cargo.length > 0) {
                sb.append(String.format("%s", cargo[cargo.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        size += 1;

        if (engine == null) {
            engine = new TrainCar<T>(element);
            return;
        }

        TrainCar<T> car = engine;

        while (car.getNextCar() != null) {
            car = car.getNextCar();
        }

        car.setNextCar(new TrainCar<T>(element));
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index > size) {
            throw new IndexOutOfBoundsException("index cannot be greater than train size + 1");
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException("index cannot be less than 0");
        }

        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        if (index == 0) {
            size += 1;

            if (engine == null) {
                engine = new TrainCar<T>(element);
                return;
            }

            engine = new TrainCar<T>(element, engine);
            return;
        }

        TrainCar<T> car = engine;
        for (int i = 0; i + 1 < index; i++) {
            car = car.getNextCar();
        }

        car.setNextCar(new TrainCar<T>(element, car.getNextCar()));
        size += 1;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (engine == null) {
            throw new NoSuchElementException("no car in list");
        }

        T result = engine.getCargo();
        engine = engine.getNextCar();

        size -= 1;

        return result;
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (engine == null) {
            throw new NoSuchElementException("no car in list");
        }

        if (index >= size) {
            throw new IndexOutOfBoundsException("index cannot be greater than train size");
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException("index cannot be less than 0");
        }

        if (index == 0) {
            return remove();
        }

        TrainCar<T> car = engine;
        for (int i = 0; i + 1 < index; i++) {
            car = car.getNextCar();
        }

        T result = car.getNextCar().getCargo();
        car.setNextCar(car.getNextCar().getNextCar());

        size -= 1;

        return result;
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (engine == null) {
            throw new NoSuchElementException("no car in list");
        }

        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        T result = null;
        TrainCar<T> car = engine;

        if (engine.getCargo().equals(element)) {
            result = engine.getCargo();
            remove();
            return result;
        }

        while (car.getNextCar() != null) {
            if (car.getNextCar().getCargo().equals(element)) {
                result = car.getNextCar().getCargo();
                car.setNextCar(car.getNextCar().getNextCar());
                break;
            }

            car = car.getNextCar();
        }

        if (result == null) {
            throw new NoSuchElementException("no such element in list");
        }

        size -= 1;

        return result;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index cannot be greater than train size");
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException("index cannot be less than 0");
        }

        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }


        TrainCar<T> car = engine;
        for (int i = 0; i < index; i++) {
            car = car.getNextCar();
        }

        T result = car.getCargo();
        car.setCargo(element);

        return result;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException("index cannot be greater than train size + 1");
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException("index cannot be less than 0");
        }

        Iterator<T> itr = iterator();

        for (int i = 0; i < index; i++) {
            itr.next();
        }

        return itr.next();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        Iterator<T> itr = iterator();

        while (itr.hasNext()) {
            if (element.equals(itr.next())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        engine = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return engine == null;
    }

    @Override
    public int size() {
        int i = 0;

        Iterator<T> itr = iterator();

        while (itr.hasNext()) {
            itr.next();
            i += 1;
        }

        return i;
    }

    @Override
    public Iterator<T> iterator() {
        return new TrainIterator<T>(this);
    }

    /**
     * Driver tester method.
     *
     * @param args console input
     */
    public static void main(String[] args) {
        Integer[] cargo = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Train<Integer> tr = new Train<Integer>(cargo);
        assert tr.get(3) == 3;
        assert tr.get(8) == 8;
        assert tr.contains(6);
        assert !tr.contains(9);
        assert tr.size() == 9;
        assert !tr.isEmpty();
        tr.remove(5);
        assert tr.contains(7);
        assert !tr.contains(5);
        assert tr.get(5) == 6;
    }
}
