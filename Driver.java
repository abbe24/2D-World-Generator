import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		//Chunk square = new Chunk(0);
		//square.genPlains();
		//square.genForest();
		//square.genHighlands();
		//square.genMountains();
		//printChunk8x8(square);
		Map theWorld1 = new Map(6,10);
		//Map theWorld2 = new Map(3,20);
		//Map theWorld3 = new Map(3,20);
		
		//Chunk aChunk = theWorld.getArray()[1][1];
		
		//Landform aLandform = aChunk.getArray()[0][0];
		//String aLandformStr = aLandform.getString();
		//System.out.println(aLandformStr);
		
		
		//System.out.println(theWorld.getArray()[1][1].getArray()[0][0].getString());
		
		//printChunk8x8(theWorld.getArray()[0][0]);
		System.out.println("start maps:");
		printMap4x4(theWorld1);
		System.out.println();
		//printMap4x4(theWorld2);
		//System.out.println();
		//printMap4x4(theWorld3);
		//System.out.println("end maps");
	}
	
	public static void printMap4x4(Map map) {
		//System.out.println()
		int mD = map.getDiameter();
		int cD = map.getDiameterChunk();
		for(int r1 = 0; r1 < mD; r1++) {
			for(int r2 = 0; r2 < cD; r2++) {
				for(int c1 = 0; c1 < mD; c1++) {
					
					Chunk aChunk = map.getArray()[r1][c1];
					
					for(int c2 = 0; c2 < cD; c2++) {
						
						Landform aLandform = aChunk.getArray()[r2][c2];
						System.out.print(aLandform.getString() + " ");
						
					}
				}
				
				System.out.println();
			}
		}
	}
	
	public static void printChunk8x8(Chunk square) {
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				Landform aLandform = square.getArray()[y][x];
				String aLandformStr = aLandform.getString();
				//System.out.print(square.getArray()[y][x].getString() + " ");
				System.out.print(aLandformStr + " ");
			}
			System.out.println();
		}
		System.out.println(square.getString());
	}
	
	

}
