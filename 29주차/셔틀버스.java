import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int ans, start = 540, max = 540 + t*(n-1);
        int[] arr = new int[timetable.length];
        for(int i=0; i<timetable.length; i++){
            String[] time = timetable[i].split(":");
            arr[i] = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        }
        Arrays.sort(arr);
        
        int idx = 0, cur = start;
        boolean full = false;
        while(idx < timetable.length && cur <= max){
            if(arr[idx] > max) break;
            full = false;
            for(int i=0; i<m; i++){
                if(idx == timetable.length || arr[idx] > cur) break;
                if(i == m-1) full = true;
                idx++;
            }
            cur += t;
        }
        
        if(!full || cur < max) ans = max;
        else ans = arr[idx-1]-1;
        
        return toTime(ans);
    }
    
    public static String toTime(int num){
        StringBuilder res = new StringBuilder("");
        if(num/60<10) res.append("0");
        res.append(num/60);
        res.append(":");
        if(num%60<10) res.append("0");
        res.append(num%60);
        
        return res.toString();
    }
}
