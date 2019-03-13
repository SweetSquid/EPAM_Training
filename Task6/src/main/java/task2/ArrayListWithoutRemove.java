package task2;


import java.util.*;
import java.util.function.Predicate;

public class ArrayListWithoutRemove<E> extends ArrayList<E> {


    private E[] values;


    public static void main(String[] args) {
        ArrayListWithoutRemove<Integer> test = new ArrayListWithoutRemove<>();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(Arrays.toString(test.toArray()));
    }

    public ArrayListWithoutRemove() {
        super();
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public E get(int index) {
        return values[index];
    }
    

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("You can't delete anything");
    }

    @Override
    public void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("You can't delete anything");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("You can't delete anything");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("You can't delete anything");
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException("You can't delete anything");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("You can't delete anything");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("You can't delete anything");
    }

}
