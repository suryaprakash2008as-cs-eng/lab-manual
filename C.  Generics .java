// Generic Data Container Example
import java.util.*;

class DataContainer<T> {
    private T value;

    public DataContainer(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void showType() {
        System.out.println("Type of stored item : " + value.getClass().getName());
    }
}

// Generic method to find maximum of three values
class GenericUtils {
    public static <T extends Comparable<T>> T findMax(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;
        return max;
    }
}

// Generic Key-Value Pair
class KeyValue<K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void display() {
        System.out.println(key + " = " + value);
    }
}

public class GenericDataContainerDemo {
    public static void main(String[] args) {
        // Generic class usage
        DataContainer<Integer> intBox = new DataContainer<>(100);
        System.out.println("Integer Box Value : " + intBox.getValue());
        intBox.showType();

        DataContainer<String> strBox = new DataContainer<>("Hello Generics");
        System.out.println("String Box Value : " + strBox.getValue());
        strBox.showType();

        // Generic Key-Value pairs
        System.out.println("\n---- Key-Value Pairs ----");
        KeyValue<String, Integer> kv1 = new KeyValue<>("Rahul", 88);
        kv1.display();

        KeyValue<Integer, String> kv2 = new KeyValue<>(101, "CSE");
        kv2.display();

        // Generic method with bounded type parameters
        System.out.println("\nMaximum Number : " + GenericUtils.findMax(45, 89, 67));
        System.out.println("Maximum (Alphabetical) : " + GenericUtils.findMax("Rahul", "Sneha", "Kiran"));
        System.out.println("Maximum Marks : " + GenericUtils.findMax(85.5, 92.3, 77.8));
    }
}
