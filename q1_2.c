#include <stdio.h>
//write a method void reverse(char* str) in c that reverses a char arra in place

void reverseCharArray(char *arr) {
    //find the length of the array
    char tmp;
    int done = 0;
    int count = 0;

    while (!done) {
        tmp = arr[count];
        if (tmp) {
            count++;
        } else {
            done = 1;
        }
    }

    //iterate backwards into a temp array
    char tmpArr[count];
    int p = 0;
    for (int i = count-1; i >= 0; i--) {
        tmpArr[p] = arr[i];
        p++;
    }

    //iterate temp into original array
    for (int i = 0; i < count; i++ ) {
        arr[i] = tmpArr[i];
    }
}

int main() {
    char arr[] = "hello world";
    
    printf("string forward:\n%s\n\n", arr);
    reverseCharArray(arr);
    printf("string reversed:\n%s\n\n", arr);

    return 0;
}