#include<stdio.h>
int main() {
	int a, b, c=0;
    char ch;
	scanf("%d", &a);
	scanf("%c", &ch);
	while (ch != '='&&c!=1) {
		scanf("%d", &b);
		switch (ch) {
		case'+':a += b;
			break;
		case'-':a -= b; 
			break;
		case'*':a *= b; 
			break;
		case'/':if (b ==0)
			c = 1;
				else a /= b;
			break;
		default:c = 1;
		}
		scanf("%c", &ch);
	}
	if (c == 1)
		printf("ERROR");
	else
		printf("%d", a);
	return 0;
}