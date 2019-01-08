public class Person {

	// vote = name of the party
	private String name, vote;
	private int age;
	
	/*
	 * Constrcutor for class: Person.java
	 */
	public Person(String name, int age, String vote) {
		setName(name);
		setAge(age);
		setVote(vote);
	}

	@Override
	public String toString() {
		return getName() + ", " + getAge() + ", " + getVote();
	}
	
	/*
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/*
	 * sets String name
	 */
	public void setName(String name) {
		if (name == null || name.length() < 1)
			throw new IllegalArgumentException("Name is not valid!");
		this.name = name;
	}
	
	/*
	 * @return vote
	 */
	public String getVote() {
		return vote;
	}
	
	/*
	 * sets String vote
	 */
	public void setVote(String vote) {
		if (vote == null || vote.length() <= 2)
			throw new IllegalArgumentException("Party (VOTE) name is not valid!");
		this.vote = vote;
	}
	
	/*
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/*
	 * sets int age
	 */
	public void setAge(int age) {
		if (age <= 0 || age > 150)
			throw new IllegalArgumentException("Year number is not valid!");
		this.age = age;
	}

}
