/* 크루스칼 알고리즘 + Union-Find 이용*/

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	
	public int[] node = new int[2]; //연결 된 두 노드 
	public int dist; //간선의 가중치 
	
	public Edge(int a , int b, int dist) {
		node[0] = a;
		node[1] = b;
		this.dist = dist;
	}

	@Override
	public int compareTo(Edge e) {	//edge.dist의 오름차순으로 정렬
		return this.dist <= e.dist ? -1 : 1;
	}
	
}

public class Main {
	
	//부모 노드를 찾는 함수 
	static int getParent(int parent[], int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent,parent[x]);
	}
	//두 부모노드를 합치는 함수 
	static void unionParent(int parent[], int x, int y) {
		int a = getParent(parent, x);
		int b = getParent(parent, y);
		if (a < b) parent[b] = a;
		else parent[a] = b;	//더 작은 수가 parent가 된다 
	}
	//같은 부모를 가지는지 확인(같은 그래프에 속해 있는지)
	static boolean find(int parent[], int x, int y) {
		int a = getParent(parent, x);
		int b = getParent(parent, y);
		return a == b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i = 0; i < e; i++) { //입력 
			st = new StringTokenizer(br.readLine());
			int n[] = new int[3]; 
			for(int j = 0; j < 3; j++) {
				n[j] = Integer.parseInt(st.nextToken());
			}
			pq.add(new Edge(n[0],n[1],n[2]));
		}
		
		//사이클 테이블 초기화. 자기자신이 부모인 상태 
		int[] set = new int [v];
		for(int i = 0; i < v; i++)
			set[i] = i;
		
		int sum = 0; // 최소 스패닝 트리의 가중치의 합
		for(int i = 0; i < e; i++) { //모든간선에 대해, 사이클이 생기지 않을 때만(동일한 부모를 가르키지 않을 때)만 선택 
			Edge curV = pq.poll();
			if(!find(set, curV.node[0] - 1, curV.node[1] - 1)) {
				sum += curV.dist;
				unionParent(set, curV.node[0] - 1, curV.node[1] - 1);
			}
		}
		System.out.print(sum);
	}
}