import org.example.models.Student;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Equal Object and same hashcode
public class StudentTest {
    @Test
    public void equalObjectTest(){
        Student student1 = new Student(1, "Robert", 15);
        Student student2 = new Student(1, "Robert", 15);

        assertEquals(student1, student2);
    }

    @Test
    public void equalObjectAndHashCodeTest(){
        Student student1 = new Student(1, "Robert", 15);
        Student student2 = new Student(1, "Robert", 15);

        assertEquals(student1, student2); //equal
        assertEquals(student1.hashCode(), student2.hashCode()); //equal
    }

    @Test
    public void equalObjectHashMapPut(){
        Student student1 = new Student(1, "Robert", 15);
        Student student2 = new Student(1, "Robert", 15);

        HashMap<Student, Integer> map = new HashMap<>();
        map.put(student1, 10);
        map.put(student2, 20);

        // Hashmap should contain only 1 key value pair since both student object hashcode is same
        assertEquals(map.size(), 1);

        // By definition, the put command replaces the previous value associated with the given key in the map
        // (conceptually like an array indexing operation for primitive types).
        assertEquals(map.get(student1), 20);

        // Both keys will return true for containsKey as Hashcode is same
        assertTrue(map.containsKey(student1));
        assertTrue(map.containsKey(student1));
    }
}
