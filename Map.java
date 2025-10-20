import java.util.ArrayList;

public class Map {
	private int diameter;
	private int diameterChunk;
	private int r;
	private int[][] skeletonArray;
	private Chunk[][] world;
	private int[] ring1odds = {5, 15, 50, 100};//5, 15, 50, 100   //0-pl, 1-fr, 2-hi, 3-mt
	private int[] adjX = { 0, 1, 1, 1, 0,-1,-1,-1};
	private int[] adjY = {-1,-1, 0, 1, 1, 1, 0,-1};
	
	public Map(int diameter_i, int diameterChunk_i) {
		this.diameter = diameter_i;
		this.diameterChunk = diameterChunk_i;
		this.r = diameter/2;
		this.world = new Chunk[diameter][diameter];
		this.skeletonArray = new int[diameter][diameter];

		/*
		
		
		for(int r = 0; r < diameter; r++) {
			for(int c = 0; c < diameter; c++) {
				int ran = (int)(Math.random() * 100);
				if(ran < ring1odds[0]) {
					skeletonArray[r][c] = 3;
				}
				else if(ran < ring1odds[1]) {
					skeletonArray[r][c] = 2;
				}
				else if(ran < ring1odds[2]) {
					skeletonArray[r][c] = 1;
				}
				else if(ran < ring1odds[3]) {
					skeletonArray[r][c] = 0;
				}
				else {
					System.out.println("ERROR IF CHAIN NOT FIRED");
				}
			}
		}

		boolean outOfBounds = false;
		int adjMts = 0;
		int oddsToFill
		
		for(int y = 0; y < diameter; y++) {	//r=y, c=x
			for(int x = 0; x < diameter; x++) {
				for(int z = 0; z < 8; z++) {
					if(x + adjX[z] < 0 || x + adjX[z] > 7 || y + adjY[z] < 0 || y + adjY[z] > 7) {
						outOfBounds = true;
					}
					if(!outOfBounds) {
						if(skeletonArray[y + adjY[z]][x + adjX[z]] == 3) {
							adjMts++;
						}
					}
					outOfBounds = false;
				}
				
				int ran = (int)(Math.random() * 100);
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
		
		*/

		Chunk[][] worldBuilder = world;
		//worldBuilder[r][r] = new Chunk(0);
		
		
		
		//for(int i = 0; i < 8; i++) {
		//	int ran = (int)(Math.random() * 100);
		//	if(ran < 5) {
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]] = new Chunk(3);
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]].genMountains();
		//	}
		//	else if(ran < 15) {
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]] = new Chunk(2);
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]].genHighlands();
		//	}
		//	else if(ran < 50) {
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]] = new Chunk(1);
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]].genForest();
		//	}
		//	else if(ran < 100) {
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]] = new Chunk(0);
		//		worldBuilder[r + adjYr1[i]][r + adjXr1[i]].genPlains();
		//	}
		//}
		//this.world = worldBuilder;
		
		
		for(int r = 0; r < diameter; r++) {
			for(int c = 0; c < diameter; c++) {
				int ran = (int)(Math.random() * 100);
				if(ran < 5) {
					worldBuilder[r][c] = new Chunk(3, diameterChunk);
					worldBuilder[r][c].genMountains();
				}
				else if(ran < 15) {
					worldBuilder[r][c] = new Chunk(2, diameterChunk);
					worldBuilder[r][c].genHighlands();
				}
				else if(ran < 50) {
					worldBuilder[r][c] = new Chunk(1, diameterChunk);
					worldBuilder[r][c].genForest();
				}
				else if(ran < 100) {
					worldBuilder[r][c] = new Chunk(0, diameterChunk);
					worldBuilder[r][c].genPlains();
				}
				else {
					System.out.println("ERROR: #ran not triggered in worldBuilder");
				}
			}
		}
		this.world = worldBuilder;
		
		
		
	}
	
	public void printMap() {
		Chunk thisChunk = new Chunk(0, diameterChunk);
		Landform thisLandform = new Landform(0);
		for(int r1 = 0; r1 < diameter; r1++) {
			
			for(int r2 = 0; r2 < 8; r2++) {
			
				for(int c1 = 0; c1 < diameter; c1++) {
					thisChunk = world[r1][c1];
				
					for(int c2 = 0; c2 < 8; c2++) {
						thisLandform = thisChunk.getArray()[r2][c2];
						System.out.print(thisLandform.getString() + " ");
					}
					System.out.print("  ");
					//System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public Chunk[][] getArray(){
		return world;
	}
	
	public int getDiameter() {
		return diameter;
	}
	
	public int getDiameterChunk() {
		return diameterChunk;
	}
}
