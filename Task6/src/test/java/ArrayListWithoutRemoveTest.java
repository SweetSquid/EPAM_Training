import org.junit.Before;
import org.junit.Test;
import task2.ArrayListWithoutRemove;

import java.util.function.Predicate;

public class ArrayListWithoutRemoveTest {
    private ArrayListWithoutRemove<Integer> array = new ArrayListWithoutRemove<>();

    @Before
    public void init() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() {
        array.remove(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveAll() {
        array.removeAll(array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveRange() {
        array.removeRange(0,1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveIf() {
        array.removeIf( Predicate.isEqual(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRetainAll() {
        array.retainAll(array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testClear() {
        array.clear();
    }

}
