import java.io.*;
import java.util.*;
public class Main {

	static ArrayList<Pair> chicken = new ArrayList<>();
	static ArrayList<Pair> house = new ArrayList<>();
	static boolean[] selected;
	static int n, m, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1)
					house.add(new Pair(i,j));
				if(temp == 2)
					chicken.add(new Pair(i,j));
			}
		}
		selected = new boolean[chicken.size()];
		
		choose(0,0);
		System.out.print(min);

	}
	static void choose(int idx, int cnt) {	//치킨집 M개 선택 
		if(cnt == m) {  //m개 치킨집 골랐으면 치킨거리 계산 
			calc();
			return;
		}
		for(int i = idx; i < chicken.size(); i++) {
				selected[i] = true;
				choose(i+1, cnt+1);
				selected[i] = false;
			
		      	/*맨 처음에 작성했던 코드 - 에러는 없지만 중복이 많아서 실행시간 아주 길었음
			* selected = ArrayList
			*/
			//choose(i+1,cnt);
			//selected.add(chicken.get(idx));
			//choose(i+1, cnt+1);
			//selected.remove(cnt);
		}
	}
	static void calc() {	//선택된 치킨집과의 치킨거리 계산
		
		int distTotal = 0;
		for(int i = 0; i < house.size(); i++) {
			Pair home = house.get(i);
			int curmin = Integer.MAX_VALUE; // 해당 집에서 골라진 치킨집들과의 치킨거리 중 최소 
			for(int j = 0; j < selected.length; j++) {
				if(!selected[j]) continue;
				Pair chi = chicken.get(j);
				int curdist = Math.abs(home.x - chi.x) + Math.abs(home.y - chi.y);
				if(curdist < curmin)
					curmin = curdist;
			}
			distTotal += curmin;
		}
		if(distTotal < min) min = distTotal; //이 선택된 치킨집들과의 치킨거리가 최소라면, 최소 갱신 
	}

}
class Pair {
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
