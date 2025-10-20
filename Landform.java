import java.util.ArrayList;

public class Landform {
	private int lfType;	  //0 1 2 3
	private String lfStr; //. f h M - plain, forest, hill, mountain
	private String[] lfStrArray = {".", "f", "h", "M"}; 
	
	public Landform(int type_i) {
		this.lfType = type_i;
		this.lfStr = lfStrArray[type_i];
	}
	
	public int getType() {
		return lfType;
	}
	
	public String getString() {
		return lfStr;
	}
}
