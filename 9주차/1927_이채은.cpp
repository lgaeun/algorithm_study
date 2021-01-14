#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100001
typedef struct {
	int arr[MAX_SIZE];
	int size;

	void init(){
		size = 0;
	}

	void swap(int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	void insert(int data){
		int temp = ++size;

		while(temp>1 && arr[temp/2]>data){
			arr[temp] = arr[temp/2];
			temp/=2;
		}

		arr[temp] = data;
	}

	int remove(){
		if(size == 0)
			return 0;
		else{
			int parent = 1;
			int child;
			int num = arr[1];
			arr[1] = arr[size--];
			while(true){
				child = parent*2;
				if(child+1<=size && arr[child]>arr[child+1])
					child++;
				if(child>size || arr[child]>arr[parent]) break;

				swap(parent, child);
				parent = child;
			}
			return num;
		}
	}
} MinHeap;

int main(){
    int N, x;
    MinHeap heap;
    scanf("%d", &N);
    heap.init();
    for(int i=0; i<N; i++){
        scanf("%d", &x);
        if(x==0)
			printf("%d\n", heap.remove());
        else
            heap.insert(x);
    }
    return 0;
}
