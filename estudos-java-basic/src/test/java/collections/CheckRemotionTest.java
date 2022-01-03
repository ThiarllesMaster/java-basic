package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckRemotionTest {

    @Test
    public void testIfExistsDelete() {
        Predicate<String>  tiago = parameter -> parameter.equals("Tiago");
        List<String> list = new ArrayList<>();
        list.add("Tiago");
        list.add("Daísa");

        list.removeIf(n -> n.equals("Daísa"));

        assertEquals(list.size(), 1);
    }

    @Test
    public void removeAllCollectionInsideCollection() {
        List<String> words = new ArrayList<>();
        words.add("A");
        words.add("B");

        List<String> words2 = new ArrayList<>();
        words2.add("A");


        Set<String> list = new HashSet<>(words);

        assertTrue(!list.isEmpty());

        list.retainAll(words2);

        System.out.println(list);

    }
}
