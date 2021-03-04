#include <stdio.h>

char[500000] stack;
int cnt = 0;
int top = 0;

void push(char e){
    cnt++;
    stack[top++] = e;
}

int peek(){
    return stack[top];
}

int pop(){
    cnt--;
    return stack[top--];
}

int main(){
    int N, K;
    char str[500000];
    scanf("%d %d", &N, &K);
    scanf("%s", &str);
    for(int i=0; i<N; i++){
        if(cnt==N-K) break;
        if(cnt==0)
            push(str[i]);
        else if(peek()<str[i]){
            pop();
            push(str[i]);
        }
        else
            push(str[i]);
    }
    
    for(int i=0; i<K; i++)
        printf("%c",stack[i]);
}
