import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	static int N,M;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//parent 찾는 함수
	static int getParent(int a) {
		if(parent[a] == a) return a;
		return parent[a] = getParent(parent[a]);
	}
	// 두 부모노드를 합치는 함수. 더 작은 수가 parent가 됌 
	static void union(int a, int b) {
		int x = getParent(a);
		int y = getParent(b);
		if(x < y) parent[y] = x;
		else parent[x] = y; 
	}
	// a-b가 연결되어 있는지 찾는 함수 
	static boolean find(int a, int b) {
		return getParent(a) == getParent(b);
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N];
		for(int i = 0; i < N; i++) parent[i] = i; //parent 테이블 초기화 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int connected = Integer.parseInt(st.nextToken());
				if(connected == 1) {
					if(!find(i,j)) union(i,j);  //연결 안되어있으면 합치기 
				}
			}
		}
		
		System.out.println( isAvailable() ? "YES" : "NO");
	}
	
	static boolean isAvailable() throws IOException {
		st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		for(int i = 1; i < M ; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(! find(prev - 1,next - 1)) return false;
		}
		return true;
	}

}
