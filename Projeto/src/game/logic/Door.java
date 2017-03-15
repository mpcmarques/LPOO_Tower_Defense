package game.logic;
public class Door extends Cell {
	private boolean isOpen;
	private boolean isExit;

	///	Constructor
	Door(boolean isExit, int x, int y) {
		super("I", x, y);
		setOpen(false);
		setExit(isExit);
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	//	Opens the door
	public void openDoor(){
		this.setOpen(true);
		this.setLetter("S");
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}
}