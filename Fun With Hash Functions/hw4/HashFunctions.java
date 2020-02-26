import java.util.Random;

public class HashFunctions {

	private int C;		// The largest possible key that can be hashed.
	private int size;	// The size of the hash table.

	public HashFunctions(int s) {
		C = s * s;
		size = s;
	}

	public int hash1(int k) {
		return k % size;
	}

	public int hash2(int k) {
		return k * size / C;
	}

	public int hash3(int k) {
		return (int) (2971L * k + 101923) % size;
	}

	public int hash4(int k) {
		Random rand = new Random(k);
		return rand.nextInt(size);
	}
}
