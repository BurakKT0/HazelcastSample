import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastSample {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        IMap<Integer, Person> personMap = hazelcastInstance.getMap("persons");
        for (int i = 0; i < 10000; i++) {
            Person person = new Person("Burak" + i, 30 + i);
            personMap.put(i, person);
        }
        Person retrievedPerson = personMap.get(0);
        System.out.println("Retrieved Person: " + retrievedPerson);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}


