package at.fhv.msc.java;

public class Hole {
	
	private String _cheeseSlice;
	
	public Hole() {
		_cheeseSlice = "+-----------------+," +
                	   "|    **           |," +
                	   "|   *  *     *    |," +
                	   "|   ***     * *   |," +
                	   "|            *    |," +
                	   "|  *     **       |," +
                	   "+-----------------+,"; 
	}
    
    public String get_cheeseSlice() { return _cheeseSlice; }

	public void set_cheeseSlice(String _cheeseSlice) { _cheeseSlice = _cheeseSlice; }

	//Hauptmethode: Suche nach '*'. Ausgabe der Menge an Löcher und des größten Lochs in einem res-Array.

	public static int[] checkCheeseQuality(Hole probe) {
        int[] res = new int[2];
        String[] rows = probe.get_cheeseSlice().split(",");
        int rowLen = rows.length;
        int colLen = rows[0].length();
        boolean[][] visited = new boolean[rowLen][colLen];
        int largest = 0;
        
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].length(); j++) {
                if (rows[i].charAt(j) == '*' && visited[i][j] == false) {
                	res[0] += 1;
                    int size = checkSurrounding(i, j, rows, rowLen, colLen, visited);
                    if (size > largest) {
                    	largest = size;
                    }
                }
            }
        }
        
        res[1] = largest;
        
        return res;
    }
    
    //Implementierung eines DFS-Algorhitmus ("Depth-First-Search").
    
    private static int checkSurrounding(int i, int j, String[] rows, int rowLen, int colLen, boolean[][] visited) {
        int size = 0;
        
        if (i >= rowLen || j >= colLen || rows[i].charAt(j) != '*' || visited[i][j] == true) {
            return size;
        }
        
        visited[i][j] = true;
        
        size += checkSurrounding(i+1, j+1, rows, rowLen, colLen, visited);
        size += checkSurrounding(i-1, j-1, rows, rowLen, colLen, visited);
        size += checkSurrounding(i+1, j-1, rows, rowLen, colLen, visited);
        size += checkSurrounding(i-1, j+1, rows, rowLen, colLen, visited);
        size += checkSurrounding(i+1, j  , rows, rowLen, colLen, visited);
        size += checkSurrounding(i-1, j  , rows, rowLen, colLen, visited);
        size += checkSurrounding(i  , j+1, rows, rowLen, colLen, visited);
        size += checkSurrounding(i  , j-1, rows, rowLen, colLen, visited);

        return size + 1;
    }
    
    public static void main(String[] args) {
        Hole probe = new Hole();
        
        int[] result = checkCheeseQuality(probe);
        
        System.out.println("Anzahl Löcher: " + result[0]);
        System.out.println("GRößtes Loch: " + result[1]);
    }
}