import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import elections.Person;
import elections.Queue;
import elections.utils.Utils;

public class QueueTest extends Utils {

	private Queue q;
	private Person p1, p2, p3, p4, p5, p6;

	@Before
	public void setUp() throws Exception {
		q = new Queue();

		// adding voters
		p1 = createPerson("Andreas M�ller", 5, "AP�");
		p2 = createPerson("Petra Maier", 67, "BP�");
		p3 = createPerson("Sybille Nemec", 23, "CP�");
		p4 = createPerson("Fatima �zt�rk", 17, "AP�");
		p5 = createPerson("Sepp Huber", 44, "BP�");
		p6 = createPerson("Michael Pospisil", 16, "AP�");

		addAll(q, p1, p2, p3, p4, p5, p6);

		q.vote();
	}

	@Test
	public void testGetSumOfVotes() {
		assertEquals(5, q.getSumOfVotes());
	}

	/*
	 * check if the list of persons has no elements after the method has been
	 * called and the map of votes has 3 keys
	 */
	@Test
	public void testVote() {
		assertEquals(0, q.getNumberOfPersons());
		assertEquals(3, q.getVoteKeysSum());
	}

}
