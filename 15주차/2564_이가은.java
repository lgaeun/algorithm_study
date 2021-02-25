import java.io.*;
import java.util.*;

public class Main {
	static class XY{
		int pos, x, y;
		XY (int pos, int offset){
			this.pos = pos;
			switch(pos) {
			case 1: this.x=offset; this.y=h; break;
			case 2: this.x=offset; this.y=0; break;
			case 3: this.x=0; this.y=h-offset; break;
			case 4: this.x=w; this.y=h-offset;
			}
		}
	}
	static int w,h;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		XY[] loc = new XY[n+1]; 
		
		for(int i = 0; i < n+1; i++) { // loc[n] = 동근 
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			loc[i] = new XY(dir, dist);
		}
		
		int ans = 0, dong = loc[n].pos;
		for(int i = 0; i < n; i++) {
			int shop = loc[i].pos;
			if((dong==1 && shop==2) || (dong==2 && shop==1) || (dong==3 && shop==4) || (dong==4 && shop==3)) { // 상점의 위치가 동근이 맞은편인 경우 
				if(dong == 1 ||dong == 2) 
					ans += h + Math.min(loc[i].x + loc[n].x, 2*w - loc[n].x - loc[i].x); //동근이가 북,남일때 
				else
					ans += w + Math.min(loc[i].y + loc[n].y, 2*h - loc[n].y - loc[i].y);  //동근이가 동,서 일때 
			}
			else   ans += Math.abs(loc[i].x - loc[n].x) + Math.abs(loc[i].y - loc[n].y);
		}
		System.out.println(ans);
	}
}
