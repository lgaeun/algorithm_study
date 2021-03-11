import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] tree = new char[26][2]; //i번째('A')의 left, right 자식 순으로 입력 받음
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void preorder(char root) throws IOException {
		if(root == '.') return; //leaf니까 탐색 끝 
		else {
			bw.write(root);
			preorder(tree[root-'A'][0]);
			preorder(tree[root-'A'][1]);
		}
	}
	static void inorder(char root) throws IOException {
		if(root == '.') return;  //leaf니까 탐색 끝 
		else {
			inorder(tree[root-'A'][0]);
			bw.write(root);
			inorder(tree[root-'A'][1]);
		}
	}
	static void postorder(char root) throws IOException {
		if(root == '.') return;   //leaf니까 탐색 끝 
		else {
			postorder(tree[root-'A'][0]);
			postorder(tree[root-'A'][1]);
			bw.write(root);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			tree[s.charAt(0)-'A'][0] = s.charAt(2); //left 자식
			tree[s.charAt(0)-'A'][1] = s.charAt(4); //right 자식 
		}
		
		preorder('A');  bw.write("\n");
		inorder('A');   bw.write("\n");
		postorder('A'); bw.write("\n");
		bw.flush();
		bw.close();
	}
}
