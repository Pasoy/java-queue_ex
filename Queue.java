import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import utils.Utils;

public class Queue extends Utils {

	private ArrayList<Person> persons = new ArrayList<>();
	// String - name of party | Integer - number of votes
	private HashMap<String, Integer> votes = new HashMap<>();

	public static void main(String[] args) {
		Queue q = new Queue();

		// adding voters
		Person p1 = createPerson("Andreas Müller", 5, "APÖ");
		Person p2 = createPerson("Petra Maier", 67, "BPÖ");
		Person p3 = createPerson("Sybille Nemec", 23, "CPÖ");
		Person p4 = createPerson("Fatima Öztürk", 17, "APÖ");
		Person p5 = createPerson("Sepp Huber", 44, "BPÖ");
		Person p6 = createPerson("Michael Pospisil", 16, "APÖ");

		AddAndHasBeenAdded(q, p1, p2, p3, p4, p5, p6);


		// printing persons
		q.printPersons();

		clearLine();
		System.out.println(q.findPersonsYoungerThan(60));

		q.vote();
		
		clearLine();
		q.printVotes();
	}

	/*
	 * a person is added to the queue if he/she is older than (greater or equal)
	 * 16. if he/she is added true is returned, false otherwise.
	 */
	public boolean add(Person p) {
		if (p == null)
			throw new IllegalArgumentException("Person does not exist!");
		if (p.getAge() < 16) {
			return false;
		} else {
			persons.add(p);
			return true;
		}
	}

	/*
	 * in a loop on the list of persons, using an iterator, add the vote to the
	 * map and remove the person from the list after he/she has voted
	 */
	public void vote() {
		Iterator<Person> it = persons.iterator();
		Person voter = null;

		while (it.hasNext()) {
			voter = it.next();
			String v = voter.getVote();
			if (!(votes.containsKey(v))) {
				votes.put(v, 1);
			} else {
				votes.put(v, votes.get(v).intValue() + 1);
			}
			it.remove();
		}
	}

	/*
	 * prints the attributes of all persons in the queue
	 */
	public void printPersons() {
		persons.forEach(System.out::println);
	}

	/*
	 * prints a list of the parties with their votes
	 */
	public void printVotes() {
		for (HashMap.Entry<String, Integer> map : votes.entrySet()) {
			System.out.println(map.getKey() + ", Votes: " + map.getValue());
		}
	}

	/*
	 * returns a set of persons with age younger than the given age
	 */
	public HashSet<Person> findPersonsYoungerThan(int age) {
		HashSet<Person> res = new HashSet<>();
		for (Person p : persons) {
			if (p.getAge() < age) {
				res.add(p);
			}
		}
		return res;
	}

	/*
	 * returns overall number of votes in the map
	 */
	public int getSumOfVotes() {
		int total = 0;
		for (HashMap.Entry<String, Integer> map : votes.entrySet()) {
			total += map.getValue();
		}
		return total;
	}

	/*
	 * ----------------------------------
	 */

	/*
	 * method to check keys
	 */
	public int getVoteKeysSum() {
		int total = 0;
		for (HashMap.Entry<String, Integer> map : votes.entrySet()) {
			total = map.getValue();
		}
		return total + 1;
	}

	/*
	 * returns size of persons
	 */
	public int getNumberOfPersons() {
		if(persons.size() == 0) {
			return 0;
		}
		return persons.size() + 1;
	}

}
