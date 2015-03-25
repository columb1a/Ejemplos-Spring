package instrumentalist;

import interfaces.Instrument;
import interfaces.Performer;

public class Instrumentalist implements Performer {

	private String song;
	private Instrument instrument;
	private int age;

	public Instrumentalist() {
	}

	public void perform() {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSong() {
		return song;
	}

	public String screamSong() {
		return song;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
