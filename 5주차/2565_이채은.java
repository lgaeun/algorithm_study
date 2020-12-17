public class Main{
    private static int[][] array;
    private static int[] dp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = 0;
        array = new int[N][2];
        dp = new int[N];
        for(int i=0; i<N; i++){
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        
        Arrays.sort(array, Comparator.comparingInt(o1->o1[0]));

        for (int i = 0; i < N; i++) {
            if (dp[i] == 0) dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i][1] > array[j][1]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        
		int min = N-max;
        System.out.println(min);
        sc.close();
    }
    
}
