import elections.Person;
import elections.Queue;

public class Utils {
	
	public static Person createPerson(String name, int age, String vote) {
		return new Person(name, age, vote);
	}
	
	public static void AddAndHasBeenAdded(Queue q, Person... p) {
		for(Person r : p) {
			System.out.println(q.add(r));
		}
	}
	
	public static void addAll(Queue q, Person... p) {
		for(Person r : p) {
			q.add(r);
		}
	}
	
	public static void clearLine() {
		System.out.println();
	}

}
