import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Tcase  = Integer.parseInt(br.readLine());
		
		while(Tcase-- > 0) {
			String str = br.readLine();
			boolean isCorrect = true;
			
			for(int i = str.length() - 1; i > 0; i--) { 
				if(str.charAt(i-1) < str.charAt(i)) {
					bw.append(str.substring(0, i-1) + reSort(str.substring(i-1)) + "\n"); //reSort할 부분 찾기: 사전 순 더 앞에오는 알파벳이 있으면 거기서부터
					isCorrect = false;
					break;
				}
			}
			if(isCorrect) bw.append(str+"\n");  //맨끝인 경우 그냥 출력
		}
		
		bw.flush();
		bw.close();
	}

	static String reSort(String s) {
		List<Character> tmp = s.chars().mapToObj(e -> (char)e).sorted().collect(Collectors.toList()); // 스트링 -> char arraylist로 변환
		int idx = tmp.indexOf(s.charAt(0)); //제일 처음 알파베의 인덱스 저장 
		
		for(int i = idx; i < s.length() - 1; i++){  //맨앞 알파벳 다음으로 큰 알파벳이 맨 앞으로, 나머지는 오름차순 정렬 
			if(tmp.get(i) == tmp.get(i+1)) continue;
			
			char next = tmp.remove(i+1);
			Collections.sort(tmp);
			tmp.add(0,next);
			break;
		}
		return tmp.stream().map(String::valueOf).collect(Collectors.joining()); //char arraylist -> 스트링으로 변환
	}

}