package Graph;  
  
/* 
 *Dijkstra algorithme，find the shortest path 
 */  
  
public class Dijkstra {  
  
    public static final int M = -1;  
    static int[][] map = {  
        { 0,  7,  9,  M,  M, 14 },   
        { 7,  0,  10, 15, M, M },  
        { 9,  10, 0,  11, M, 2 },   
        { M,  15, 11, 0,  6, M },  
        { M,  M,  M,  6,  0, 9 },   
        { 14, M,  2,  M,  9, 0 }  
    };  
    static int n =map.length;       //number of the nodes 
    static int[] shortest = new int[n];  //conserve the 
    static boolean[] visited = new boolean[n]; //true means find out
      
    public static void main(String[] args) {  
        int orig = 0; // origin
        int[] shortPath = dijkstra_alg(orig);  
          
        if(shortPath == null){  
            return;  
        }  
          
        for(int i=0; i< shortPath.length; i++){  
            System.out.println("从" + (orig + 1) + "出发到" + (i + 1) + "的最短距离为："+ shortPath[i]);  
            }  
    }  
  
    private static int[] dijkstra_alg(int orig) {  
    
        shortest[orig] = 0;  
        visited[orig] = true;  
        for(int count = 0; count != n-1; count ++)  
        {  
            //选出一个距离初始顶点最近的为标记顶点  
            int k = M;  
            int min = M;  
            for(int i =0; i< n ; i++)//遍历每一个顶点  
            {  
                if( !visited[i] && map[orig][i] != M) //如果该顶点未被遍历过且与orig相连  
                {  
                    if(min == -1 || min > map[orig][i]) //找到与orig最近的点  
                    {  
                        min = map[orig][i];  
                        k = i;  
                    }  
                }  
            }  
            //正确的图生成的矩阵不可能出现K== M的情况  
            if(k == M)  
            {  
                System.out.println("the input map matrix is wrong!");  
                return null;  
            }  
            shortest[k] = min;  
            visited[k] = true;  
            //以k为中心点，更新oirg到未访问点的距离  
            for (int i = 0; i < n; i++)  
            {  
                if (!visited[i] && map[k][i] != M)  
                {  
                    int callen = min + map[k][i];  
                    if (map[orig][i] == M || map[orig][i] > callen)  
                    {  
                        map[orig][i] = callen;  
                    }  
                }  
            }  
        }  
          
        return shortest;  
    }  
}  