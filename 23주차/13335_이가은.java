import java.io.*;
import java.util.*;

public class _13335 {
	static class Node{
		int idx, time;
		Node(int idx, int time){
			this.idx = idx;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken()); //다리 길이 
		int maxWeight = Integer.parseInt(st.nextToken()); //최대 하중 
		
		int[] truck = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) truck[i] = Integer.parseInt(st.nextToken());
		
		int idx=0, time=0, weight=0;
		Queue<Node> q = new LinkedList<>(); //다리 
		
		while(!q.isEmpty() || idx < N) { //모든 트럭이 다리를 다 지나갈 때 까지 반복 
			if(!q.isEmpty() && time - q.peek().time == len) { //시간다되면 그 트럭은 다리에서 내리기 
				weight -= truck[q.poll().idx];
			}
			if(idx < N && weight + truck[idx] <= maxWeight) { // 트럭 더 올릴 수 있으면 올리기  
				q.add(new Node(idx, time));
				weight += truck[idx++];
			}
			time++;
		}
		System.out.println(time);
	}

}
