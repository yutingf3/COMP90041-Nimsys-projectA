/* NimPlayer.java
 * This class controls the overall Nim game process
 * Author: Yuting Feng
 * Student ID:896336
 * Created on 22/3/18
 */
import java.util.Scanner;

public class Nimplayer {
	private String name;
	
	//player's name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//input the number of stones to remove
	public int removeStone(Scanner keyboard) {
		System.out.println(name + "'s"+" turn - remove how many?");
		return keyboard.nextInt();
	}

	public void win() {
		System.out.println(name + " wins!");
	}
}

