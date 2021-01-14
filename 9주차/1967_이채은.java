import java.io.*;
import java.util.LinkedList;

public class Main{
	
	static class Node{
	    int num, d;
	    public Node(int num, int d){
	    	this.num = num;
	    	this.d = d;
	    }
	}
	
    public static boolean visit[];
    public static int n, max;
    public static Node maxNode;
    public static LinkedList<Node> tree[];
    
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	if(n==1) {
    		System.out.println("0");
    		return;
    	}
    	tree = new LinkedList[n+1];
    	visit = new boolean[n+1];
    	
    	for(int i=1; i<n+1; i++)
    		tree[i] = new LinkedList<>();
    	
    	for(int i=2; i<n+1; i++){
    	    String[] line = br.readLine().split(" ");
    	    int p = Integer.parseInt(line[0]);
    	    int c = Integer.parseInt(line[1]);
    	    int d = Integer.parseInt(line[2]);
    	    tree[p].add(new Node(c, d));
    	    tree[c].add(new Node(p, d));
    	}

    	for(Node root : tree[1]){
    	    visit[1] = true;
    	    search(root, root.d);
    	    visit[1] = false;
    	}
    	
    	max = 0;
    	search(maxNode, 0);
    	System.out.println(max);
    	br.close();
    }

    private static void search(Node curNode, int dis){
    	visit[curNode.num] = true;
    	
        for(Node tmp : tree[curNode.num]){
    	    if(!visit[tmp.num]){
        		visit[tmp.num] = true;
        		search(tmp, dis+tmp.d);
        		visit[tmp.num] = false;
    	    }
    	}
        
    	if(dis > max){
    	    maxNode = curNode;
    	    max = dis;
    	}
    	
    	visit[curNode.num] = false;
    }
    
}
