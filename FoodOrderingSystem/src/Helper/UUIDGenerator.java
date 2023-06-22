package Helper;

public class UUIDGenerator {
	int startId;
	private static UUIDGenerator instance;
	public static UUIDGenerator getInstance() {
		if(instance == null) {
			instance = new UUIDGenerator();
		}
		return instance;
	}
	private UUIDGenerator() {
		startId = 1;
	}
	public int generateUUID() {
		return startId++;
	}
	
}
