public class BellmanFord
{
    private int distances[];
    private int numberofvertices;
    public final int max = 999;
    int parent[];
 
    public BellmanFord(int numberofvertices){
        this.numberofvertices = numberofvertices;
        this.parent= new int[numberofvertices];
        distances = new int[numberofvertices];
    }
 
    public void ShortestPath(int vertex, int matrix[][]){
        for(int i = 0; i<numberofvertices; i++){
            distances[i] = max;
            parent[i] = 0;
            for(int j = 0; j<numberofvertices; j++){
                if(matrix[i][j]==0){
                    matrix[i][j]=max;
                }
            }
        }
        parent[vertex] = -1;

        distances[vertex] = 0;
        for (int i = 0; i < numberofvertices - 1; i++){
            for (int j = 0; j < numberofvertices; j++){
                for (int k = 0; k < numberofvertices; k++){
                    if (matrix[j][k] != max){
                        if (distances[k] > distances[j] + matrix[j][k]){
                            distances[k] = distances[j]+ matrix[j][k];
                            parent[k]=j;
                        }
                    }
                }
            }
        }
 
        for (int i = 0; i < numberofvertices; i++){
            for (int j = 0; j < numberofvertices; j++){
                if (matrix[i][j] != max){
                    if (distances[j] > distances[i]+ matrix[i][j])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
 
        for(int i = 0; i<numberofvertices; i++){
            int pos=i;
            System.out.printf("shortest path %d to %d\n",(vertex+1) ,(i+1));
            while(parent[pos]!=-1){
                System.out.printf("%d <--- ",(pos+1));
                if(pos==parent[pos]){
                    break;
                }
                pos=parent[pos];
            }
            System.out.printf("%d\nDistance = %d\n--------------------------------\n",(vertex+1),distances[i]);
        }

    }
 
    public static void main(String arg[]){
        int matrix[][] ={{0,9,7,0,6,8},
                        {0,0,-3,0,0,0},
                        {0,0,0,0,-3,0},
                        {0,0,-1,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,-2,0,0}};

        BellmanFord bellmanFord = new BellmanFord(6);
        bellmanFord.ShortestPath(0,matrix);
    }
}