import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Matching_Score {
	
	static int solution(String word, String[] pages) {
        int answer = 0, n = pages.length;
        
        String[] mylink = new String[n];
        int[] basic_score = new int[n];
        double[] link_score = new double[n]; // 한 페이지의 링크점수 
        double[] match_score = new double[n];
        ArrayList<String>[] atag = new ArrayList[n];
        
        for(int i = 0; i < n; i++) atag[i] = new ArrayList<String>(); //atag 배열 초기화 
        
        for(int i = 0; i < n; i++) {
        	String page = pages[i];
        	page = page.toLowerCase(); // 대소 상관없므로 다 lower로 바꿔주기!
        	word = word.toLowerCase();
        	
        	//자기자신의 url 찾기 
        	Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(\\S+)\"/>"); // (\S+) : 공백 제외 모든 문자열
        	Matcher matcher = pattern.matcher(page);
        	while(matcher.find()) {
        		mylink[i] = matcher.group(1);	// group(1) : (\\S+)로 구해진 값에 해당 (group(): pattern 전부 해당)
        	}
        	
        	//기본점수계산(find pattern), word를 찾은 후 앞뒤문자가 영어가 아닌 경우(한 단어인 경우)에만 cnt 증가
        	int cnt = 0, loc = page.indexOf(word);
        	while(loc != -1) {
        		char front = page.charAt(loc-1);
        		char back = page.charAt(loc+word.length());
        		if(!Character.isLowerCase(front) && !Character.isLowerCase(back)) {
        			cnt++;
        		}
        		loc = page.indexOf(word, loc+1); //방금전 찾은 word의 뒷부분부터 재탐색
        	}
        	basic_score[i] = cnt;
        	
        	//외부링크 atag배열에 저장 후, link score 계산 후 저장 
        	int numofOutgoingLinks = 0;
        	pattern = Pattern.compile("<a href=\"https://(\\S+)\">");
        	matcher = pattern.matcher(page);
        	while(matcher.find()) {
        		atag[i].add(matcher.group(1));
        		numofOutgoingLinks++;
        	}
        	link_score[i] = (double) basic_score[i] / numofOutgoingLinks ;
        }

        //매칭 점수 계산 (= 기본점수 + 연결된 페이지의 링크 점수의 합) 
        for(int i = 0; i < n; i++) {
        	for(String url : atag[i]) {
        		for(int j = 0; j < n; j++) {
        			if(url.equals(mylink[j])) {
        				match_score[j] += link_score[i];
        			}
        		}
        	}
        	match_score[i] += basic_score[i];
        }
   
        //find index of max matching score = answer
        double max = 0;
        for(int i = n-1; i >= 0; i--) {
        	if(max <= match_score[i]) {
        		max = match_score[i];
        		answer = i;
        	}
        }
        return answer;
    }
}
