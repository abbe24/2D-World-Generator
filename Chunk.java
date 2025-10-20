import java.util.ArrayList;

public class Chunk {
	private Landform[][] chunkMap; //landform array
	private int biomeType; //0 1 2 3 - plains, forest, highlands, mountains
	private int diameter;
	private String biomeTypeStr;
	
	private int[] baseOddsPl = { 1,  4, 12}; //mountain, hill, forest
	private int[] frstFllPl  = { 0,  8, 12, 18, 20, 18,  5,  5,  4};
	private int[] hllFllPl   = { 0,  5,  7,  7,  4,  3,  3,  3,  3};
	private int[] mntFllPl   = { 0,  3,  6,  2,  2,  2,  2,  2,  2};
	
	private int[] baseOddsFr = { 2,  8, 50}; //mountain, hill, forest
	private int[] frstFllFr  = { 0, 30, 35, 45, 50, 50, 60, 65, 40};
	private int[] hllFllFr   = { 0,  5,  8, 12, 25, 20, 15, 10, 10};
	private int[] mntFllFr   = { 0,  3,  6,  2,  2,  2,  2,  2,  2};
	
	private int[] baseOddsHl = { 8, 40, 48}; //mountain, hill, forest
	private int[] frstFllHl  = { 0,  5, 10, 15,  5,  2,  2,  2,  2};
	private int[] hllFllHl   = { 0, 18, 20, 65, 45, 45, 45, 20, 15};
	private int[] mntFllHl   = { 0, 15, 25, 12,  5,  5,  5,  5,  5};
	
	private int[] baseOddsMt = {15, 25, 35}; //mountain, hill, forest
	private int[] frstFllMt  = { 0,  5, 10, 15,  5,  2,  2,  2,  2};
	private int[] hllFllMt   = { 0, 15, 25, 40, 25, 25, 25, 15, 10};
	private int[] mntFllMt   = { 0, 25, 45, 65, 40, 45, 40, 15, 10};
	
	public Chunk(int biomeType_i, int diameter_i) {
		this.biomeType = biomeType_i;
		this.diameter = diameter_i;
		this.chunkMap = new Landform[diameter][diameter];
		
		if(biomeType == 0) {
			this.biomeTypeStr = "plains";
		}
		else if(biomeType == 1) {
			this.biomeTypeStr = "forest";
		}
		else if(biomeType == 2) {
			this.biomeTypeStr = "highlands";
		}
		else if(biomeType == 3) {
			this.biomeTypeStr = "mountains";
		}
		else {
			System.out.println("ERROR: untriggered if-statement chain in Chunk constructor");
		}
	}
	
	public String getString() {
		return biomeTypeStr;
	}
	
	public void genPlains() {
		Landform[][] array = chunkMap;
		Landform trgt = new Landform(0);
		int[] adjLndfrms = new int[4];
		int[] blankArrayLen4 = {0, 0, 0, 0};
		int[] adjX = { 0, 1, 1, 1, 0,-1,-1,-1};
		int[] adjY = {-1,-1, 0, 1, 1, 1, 0,-1};
		int ran = 0;
		boolean outOfBounds = false;
		
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {

				ran = (int)(Math.random() * 100);
				if(ran < baseOddsPl[0]) {
					array[y][x] = new Landform(3);
				} 
				else if(ran < baseOddsPl[1]) {
					array[y][x] = new Landform(2);
				}
				else if(ran < baseOddsPl[2]) {
					array[y][x] = new Landform(1);
				}
				else {
					array[y][x] = new Landform(0);
				}
				
			}
		}
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {
				for(int z = 0; z < 8; z++) {
					if(x + adjX[z] < 0 || x + adjX[z] > 7 || y + adjY[z] < 0 || y + adjY[z] > 7) {
						outOfBounds = true;
					}
					if(!outOfBounds) {
						adjLndfrms[(array[y + adjY[z]][x + adjX[z]]).getType()] += 1;
					}
					outOfBounds = false;
				}
				
				ran = (int)(Math.random() * 100);
				if(ran < frstFllPl[adjLndfrms[1]]) {
					array[y][x] = new Landform(1);
				}
				ran = (int)(Math.random() * 100);
				if(ran < hllFllPl[adjLndfrms[2]]) {
					array[y][x] = new Landform(2);
				}
				ran = (int)(Math.random() * 100);
				if(ran < mntFllPl[adjLndfrms[3]]) {
					array[y][x] = new Landform(3);
				}
				adjLndfrms[0] = 0;
				adjLndfrms[1] = 0;
				adjLndfrms[2] = 0;
				adjLndfrms[3] = 0;
			}
		}
		this.chunkMap = array;
	}
	
	public void genForest() {
		Landform[][] array = chunkMap;
		Landform trgt = new Landform(0);
		int[] adjLndfrms = new int[4];
		int[] blankArrayLen4 = {0, 0, 0, 0};
		int[] adjX = { 0, 1, 1, 1, 0,-1,-1,-1};
		int[] adjY = {-1,-1, 0, 1, 1, 1, 0,-1};
		int ran = 0;
		boolean outOfBounds = false;
		
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {

				ran = (int)(Math.random() * 100);
				if(ran < baseOddsFr[0]) {
					array[y][x] = new Landform(3);
				} 
				else if(ran < baseOddsFr[1]) {
					array[y][x] = new Landform(2);
				}
				else if(ran < baseOddsFr[2]) {
					array[y][x] = new Landform(1);
				}
				else {
					array[y][x] = new Landform(0);
				}
				
			}
		}
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {
				for(int z = 0; z < 8; z++) {
					if(x + adjX[z] < 0 || x + adjX[z] > 7 || y + adjY[z] < 0 || y + adjY[z] > 7) {
						outOfBounds = true;
					}
					if(!outOfBounds) {
						adjLndfrms[(array[y + adjY[z]][x + adjX[z]]).getType()] += 1;
					}
					outOfBounds = false;
				}
				
				ran = (int)(Math.random() * 100);
				if(ran < frstFllFr[adjLndfrms[1]]) {
					array[y][x] = new Landform(1);
				}
				ran = (int)(Math.random() * 100);
				if(ran < hllFllFr[adjLndfrms[2]]) {
					array[y][x] = new Landform(2);
				}
				ran = (int)(Math.random() * 100);
				if(ran < mntFllFr[adjLndfrms[3]]) {
					array[y][x] = new Landform(3);
				}
				adjLndfrms[0] = 0;
				adjLndfrms[1] = 0;
				adjLndfrms[2] = 0;
				adjLndfrms[3] = 0;
			}
		}
		this.chunkMap = array;
	}
	
	public void genHighlands() {
		Landform[][] array = chunkMap;
		Landform trgt = new Landform(0);
		int[] adjLndfrms = new int[4];
		int[] blankArrayLen4 = {0, 0, 0, 0};
		int[] adjX = { 0, 1, 1, 1, 0,-1,-1,-1};
		int[] adjY = {-1,-1, 0, 1, 1, 1, 0,-1};
		int ran = 0;
		boolean outOfBounds = false;
		
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {

				ran = (int)(Math.random() * 100);
				if(ran < baseOddsHl[0]) {
					array[y][x] = new Landform(3);
				} 
				else if(ran < baseOddsHl[1]) {
					array[y][x] = new Landform(2);
				}
				else if(ran < baseOddsHl[2]) {
					array[y][x] = new Landform(1);
				}
				else {
					array[y][x] = new Landform(0);
				}
				
			}
		}
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {
				for(int z = 0; z < 8; z++) {
					if(x + adjX[z] < 0 || x + adjX[z] > 7 || y + adjY[z] < 0 || y + adjY[z] > 7) {
						outOfBounds = true;
					}
					if(!outOfBounds) {
						adjLndfrms[(array[y + adjY[z]][x + adjX[z]]).getType()] += 1;
					}
					outOfBounds = false;
				}
				
				ran = (int)(Math.random() * 100);
				if(ran < frstFllHl[adjLndfrms[1]]) {
					array[y][x] = new Landform(1);
				}
				ran = (int)(Math.random() * 100);
				if(ran < hllFllHl[adjLndfrms[2]]) {
					array[y][x] = new Landform(2);
				}
				ran = (int)(Math.random() * 100);
				if(ran < mntFllHl[adjLndfrms[3]]) {
					array[y][x] = new Landform(3);
				}
				adjLndfrms[0] = 0;
				adjLndfrms[1] = 0;
				adjLndfrms[2] = 0;
				adjLndfrms[3] = 0;
			}
		}
		this.chunkMap = array;
	}
	
	public void genMountains() {
		Landform[][] array = chunkMap;
		Landform trgt = new Landform(0);
		int[] adjLndfrms = new int[4];
		int[] blankArrayLen4 = {0, 0, 0, 0};
		int[] adjX = { 0, 1, 1, 1, 0,-1,-1,-1};
		int[] adjY = {-1,-1, 0, 1, 1, 1, 0,-1};
		int ran = 0;
		boolean outOfBounds = false;
		
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {

				ran = (int)(Math.random() * 100);
				if(ran < baseOddsMt[0]) {
					array[y][x] = new Landform(3);
				} 
				else if(ran < baseOddsMt[1]) {
					array[y][x] = new Landform(2);
				}
				else if(ran < baseOddsMt[2]) {
					array[y][x] = new Landform(1);
				}
				else {
					array[y][x] = new Landform(0);
				}
				
			}
		}
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {
				for(int z = 0; z < 8; z++) {
					if(x + adjX[z] < 0 || x + adjX[z] > 7 || y + adjY[z] < 0 || y + adjY[z] > 7) {
						outOfBounds = true;
					}
					if(!outOfBounds) {
						adjLndfrms[(array[y + adjY[z]][x + adjX[z]]).getType()] += 1;
					}
					outOfBounds = false;
				}
				
				ran = (int)(Math.random() * 100);
				if(ran < frstFllMt[adjLndfrms[1]]) {
					array[y][x] = new Landform(1);
				}
				ran = (int)(Math.random() * 100);
				if(ran < hllFllMt[adjLndfrms[2]]) {
					array[y][x] = new Landform(2);
				}
				ran = (int)(Math.random() * 100);
				if(ran < mntFllMt[adjLndfrms[3]]) {
					array[y][x] = new Landform(3);
				}
				adjLndfrms[0] = 0;
				adjLndfrms[1] = 0;
				adjLndfrms[2] = 0;
				adjLndfrms[3] = 0;
			}
		}
		this.chunkMap = array;
	}
	
	public Landform[][] getArray(){
		return chunkMap;
	}
}
