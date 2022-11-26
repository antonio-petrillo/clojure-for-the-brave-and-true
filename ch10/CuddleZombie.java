public class CuddleZombie {
	private int cudgeLevel;
	private int percentDeteriorated;

	public CuddleZombie(int cudgeLevel, int percentDeteriorated) {
		this.cudgeLevel = cudgeLevel;
		this.percentDeteriorated = percentDeteriorated;
	}

	public int getCudgeLevel() {
		return cudgeLevel;
	}

	public int getPercentDeteriorated() {
		return percentDeteriorated;
	}

	public void setCudgeLevel(int cudgeLevel) {
		this.cudgeLevel = cudgeLevel;
	}

	public void setPercentDeteriorated(int percentDeteriorated) {
		this.percentDeteriorated = percentDeteriorated;
	}

	public static void main(String[] args) {
		var fred = new CuddleZombie(2, 3);
		System.out.println(fred.getCudgeLevel());
		System.out.println(fred.getPercentDeteriorated());

		fred.setCudgeLevel(1);
		fred.setPercentDeteriorated(1);
		System.out.println(fred.getCudgeLevel());
		System.out.println(fred.getPercentDeteriorated());
	}
}
