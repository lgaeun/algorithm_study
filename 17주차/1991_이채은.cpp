#include <stdio.h>

typedef struct node {
    char l, r;
} Node;

node tree[26];

void preorder(char e) {
    if (e == '.') return;
    else {
        printf("%c", e);
        preorder(tree[e - 'A'].l);
        preorder(tree[e - 'A'].r);
    }
}

void inorder(char e) {
    if (e == '.') return;
    else {
        inorder(tree[e - 'A'].l);
        printf("%c", e);
        inorder(tree[e - 'A'].r);
    }
}

void postorder(char e) {
    if (e == '.') return;
    else {
        postorder(tree[e - 'A'].l);
        postorder(tree[e - 'A'].r);
        printf("%c", e);
    }
}

int main() {
    int N;
    scanf("%d", &N);
    for (int i = 1; i < N + 1; i++) {
        char root, left, right;
        scanf(" %c %c %c", &root, &left, &right);
        tree[root - 'A'].l = left;
        tree[root - 'A'].r = right;
    }

    preorder('A');
    printf("\n");
    inorder('A');
    printf("\n");
    postorder('A');
}
