#include <stdio.h>

int minimum(int a, int b){
    int m = (a<b)? a:b;
    return m;
}

int main(){
    int N, m;
	int value[3] = {0, }, min[3] = {0, }, RGB[3] = {0, };
    scanf("%d", &N);
    
    for(int i=0; i<N; i++){
        scanf("%d %d %d", RGB, RGB+1, RGB+2);
        value[0] = minimum(RGB[0]+min[1], RGB[0]+min[2]);
        value[1] = minimum(RGB[1]+min[0], RGB[1]+min[2]);
        value[2] = minimum(RGB[2]+min[0], RGB[2]+min[1]);
		for(int j=0; j<3; j++)
			min[j] = value[j];
    }
    
    m = (value[0]<value[1])? value[0]:value[1];
    if(m>value[2]) m = value[2];
    printf("%d", m);
    
    return 0;
}
