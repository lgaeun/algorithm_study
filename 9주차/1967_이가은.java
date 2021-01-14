import java.io.*;
import java.util.*;

class Node{
	public int node, w; // weight

	public Node(int node, int w) {
		this.node = node;
		this.w = w;
	}
}

public class Main {
	
	static boolean[] visited;
	static ArrayList<Node>[] tree;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		int depth = 0;
		for(int i = 1; i < n; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			tree[p].add(new Node(c,w));
			tree[c].add(new Node(p,w));
			
		}
		
		int max = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < tree[i].size(); j++)
				dfs(tree[i].get(j), 0);
		}
	
		
	}
	// 노드 번호, 트리의 지름 
	static void dfs(Node node, int length) {
		visited[node.node] = true;
		
		for(Node tmp : tree[node.node]){
    	    if(!visited[tmp.node]){
        		visited[tmp.node] = true;
        		dfs(tmp, );
        		visited[tmp.node] = false;
    	    }
    	}
	}

}

///////////////////////참고

//public static void main(String args[]) throws Exception {
//	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//	int i, parent, child, dist;
//	String line[];
//	n = Integer.parseInt(in.readLine());
//	tree = new LinkedList[n];
//	visit = new boolean[n];
//	for(i=0;i<n;i++) tree[i] = new LinkedList<>();
//	for(i=1;i<n;i++){
//	    line = in.readLine().split(" ");
//	    parent = Integer.parseInt(line[0])-1; //노드번호 인덱스로 취급해 -1함
//	    child = Integer.parseInt(line[1])-1; //상동
//	    dist = Integer.parseInt(line[2]);
//	    tree[parent].add(new Node(child, dist)); //부모->자식
//	    tree[child].add(new Node(parent, dist)); //자식->부모
//	}
//    //루트로 부터 최대거리 노드(maxDistNode) 탐색
//for(Node root : tree[0]){
//    visit[0] = true;
//    dfs(root, root.dist);
//    visit[0] = false;
//}
//maxDist = 0; //다음 탐색을 위해 0으로 초기화
////maxDistNode로 부터 최대거리 노드 탐색. maxDist에 최대 거리값이 담긴다.
//dfs(maxDistNode, 0);
//out.write(String.valueOf(maxDist));
//out.close();
//in.close();
//}
//
//private static void dfs(Node curNode, int dist){
///* 현재 노드 재탐색 방지(양방향 그래프이기 때문)
// * 만일 안해주면 1->2->3->2 와 같이 중복탐색하게 됨 */
//visit[curNode.num] = true;
//
//for(Node tmp : tree[curNode.num]){
//    if(!visit[tmp.num]){
//		visit[tmp.num] = true;
//		dfs(tmp, dist+tmp.dist);
//		visit[tmp.num] = false;
//    }
//}
//	if(dist > maxDist){
//    maxDistNode = curNode;
//    maxDist = dist;
//}
//	visit[curNode.num] = false;
//}
//}
//
//class Node{
//	int num, dist; //노드 번호, 거리
//	public Node(int num, int dist){
//	this.num = num;
//	this.dist = dist;
//	}
//}


