import org.example.models.Person;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

// Not Equal Object but same hashcode
public class PersonTest {
    @Test
    public void notEqualObjectAndSameHashCodeTest() {
        Person person1 = new Person(1, "Robert", 15);
        Person person2 = new Person(2, "James", 20);

        assertNotEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    public void notEqualObjectAndSameHashCodeHashMapTst(){
        Person person1 = new Person(1, "Robert", 15);
        Person person2 = new Person(2, "James", 20);

        assertNotEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(person1, 10);
        map.put(person2, 20);

        // Here 2 keys are inserted because HashMap call equals() method to check key equality and objects are not same.
        // But behind the scene it calls hashcode() method to find the bucket where the entry should be placed.
        // As all person object is returning same hashcode, they will be placed in same bucket and performance will be
        // decreased
        assertEquals(map.size(), 2);
        assertEquals(map.get(person1), 10);
        assertEquals(map.get(person2), 20);
    }
}
