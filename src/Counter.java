public class Counter {
	private String name;
	private int count = 0;

	public Counter(String id){
		name = id;
	}

	public void increment(){
		count++;
	}

	public int tally(){
		return count;
	}

	public String toString() {
		return count + " " + name;
	}
}
