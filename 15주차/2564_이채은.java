import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int store = sc.nextInt();
        int[][] list = new int[store+1][3];
        for(int i=0; i<store+1; i++){
            list[i][2] = sc.nextInt();
            int pos = sc.nextInt();
            switch(list[i][2]){
                case 1:
                    list[i][0] = pos;
                    list[i][1] = N;
                    break;
                case 2:
                    list[i][0] = pos;
                    list[i][1] = 0;
                    break;
                case 3:
                    list[i][0] = 0;
                    list[i][1] = N-pos;
                    break;
                case 4:
                    list[i][0] = M;
                    list[i][1] = N-pos;
                    break;
            }
        }
        
        int dist = 0;
        int posX = list[store][0], posY = list[store][1], dir = list[store][2];
        for(int i=0; i<store; i++){
            int x = list[i][0], y = list[i][1], d = list[i][2];
            if ((dir == 1 && d == 2) || (dir == 2 && d == 1)) {
                dist += Math.min(posX + x + posY + y, M - posX + M - x + posY + y);
            } else if ((dir == 3 && d == 4) || (dir == 4 && d == 3)) {
                dist += Math.min(posX + x + posY + y, posX + x + N - posY + N - y);
            } else {
                dist += Math.abs(posX - x) + Math.abs(posY - y);
            }
        }
        System.out.println(dist);
        sc.close();
    }
}
