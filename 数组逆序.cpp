#include<stdio.h>
int main() {
	int a[10], b[10], c, d, n, e = 0;
	scanf("%d", &n);
	for (c = 0; c < n; c++) {
		scanf("%d", &a[c]);
	}
	for (d = n - 1; d >= 0; d--) {
		b[d] = a[e];
		e++;
	}
	printf("%d", b[0]);
	for (c = 1; c < n; c++) {
		printf(" %d", b[c]);
	}
	return 0;
}