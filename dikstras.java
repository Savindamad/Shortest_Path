class dikstras{
	dikstras(int matrix[][], int vertex, int numberOfvertexes){
		node nodeMetrix[][] = new node[numberOfvertexes][numberOfvertexes];

		int c=vertex;
		int minDistance=999;
		int minIndex;
		int flag=0;
		int parent[] = new int[numberOfvertexes];
		for(int i = 0; i<numberOfvertexes; i++){
			parent[i]=0;
		}

		node newNd = new node(vertex,0);
		nodeMetrix[0][vertex]=newNd;

		for(int i=0; i<numberOfvertexes; i++){
			parent[c]=1;
			for(int j = 0; j<numberOfvertexes; j++){
				if(j==vertex){
				}
				else if(matrix[c][j]>0 && i==0){
					node newNode = new node(c,matrix[c][j]);
					nodeMetrix[i][j]=newNode;
				}
				else if(matrix[c][j]>0){
					if(nodeMetrix[i-1][j]!=null){
						if(matrix[c][j]+nodeMetrix[i][vertex].distance<nodeMetrix[i-1][j].distance){
							node newNode = new node(nodeMetrix[c][vertex].vertex,matrix[c][j]+nodeMetrix[i][vertex].distance);
							nodeMetrix[i][j]=newNode;
						}
						else{
							nodeMetrix[i][j]=nodeMetrix[i-1][j];
						}
					}
					else{
						node newNode = new node(nodeMetrix[i][vertex].vertex,matrix[c][j]+nodeMetrix[i][vertex].distance);
						nodeMetrix[i][j]=newNode;
					}
					
				}
				else if(i>0 && nodeMetrix[i-1][j]!=null){
					nodeMetrix[i][j]=nodeMetrix[i-1][j];
				}

			}	

			for(int j = 0; j<numberOfvertexes; j++){
				if(nodeMetrix[i][j]!=null && j!=vertex){
					if(minDistance>nodeMetrix[i][j].distance && parent[j]==0){
						minDistance=nodeMetrix[i][j].distance;
						c=j;
						flag=1;
					}
				}

			}
			node newNode = new node(c,minDistance);
			if(i!=numberOfvertexes-1){
				nodeMetrix[i+1][vertex]=newNode;
			}
			minDistance=999;
		}
		
		System.out.println("----------------------------------------");
		for(int i = 0; i<numberOfvertexes; i++){
			int pos = i;
			if(i!=vertex){
				System.out.printf("Shortest path %c to %c\n",(char)(vertex+65), (char)(i+65));
				while(pos!=vertex){
					if(nodeMetrix[numberOfvertexes-1][i]!=null){
						System.out.printf("%c <--- ",(char)(pos+65));
						pos=nodeMetrix[numberOfvertexes-1][pos].vertex;
					}
					else{
						System.out.println("No path\n----------------------------------------");
						break;
					}	
				}
				if(nodeMetrix[numberOfvertexes-1][i]!=null){
					System.out.printf("%c\nDistance=%d\n----------------------------------------\n",(char)(vertex+65),nodeMetrix[numberOfvertexes-1][i].distance);
				}
			}
			
		}
	}

	public static void main(String args[]){
		int metrix[][]={{0,2,0,0,0,8,9,0},
						{0,0,1,0,0,0,0,0},
						{0,0,0,5,0,4,0,0},
						{0,0,1,0,2,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,2,0},
						{2,0,0,0,0,0,0,0},
						{0,5,0,0,0,0,3,0}};
		dikstras diks = new dikstras(metrix,0,8);
	}
}
class node{
	int vertex;
	int distance;
	node(int vertex,int distance){
		this.vertex= vertex;
		this.distance= distance;
	}
}