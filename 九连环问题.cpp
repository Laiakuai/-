#include<stdio.h>
void zhuang(int n);
void xie(int n);
int sign[10] = { 0 };
int main() {
	int n;
	char ch0, ch1;
	int i;
	scanf("%d%c%c", &n, &ch0, &ch1);
	if (ch1 == 'D') {
		for (i = n; i >= 1; i--) {
			xie(i);
		}
	}
	else if (ch1 == 'U') {
		for (i = 0; i < 10; i++) {
			sign[i] = 1;
		}
		for (i = n; i >= 1; i--) {
			if (sign[i] == 1) {
				zhuang(i);
			}
		}
	}
}
void zhuang(int n) {
	if (n == 1) {
		printf("%d: U\n", n);
		sign[n] = 0;
		return;
	}
	if (sign[n - 1] == 1) {
		zhuang(n - 1);
	}
	for (int i = n - 2; i >= 1; i--) {
		if (sign[i] == 0) {
			xie(i);
		}
	}
	printf("%d: U\n", n);
	sign[n] = 0;
	return;
}
void xie(int n) {
	if (n == 1) {
		printf("%d: D\n", n);
		sign[n] = 1;
		return;
	}
	if (sign[n - 1] == 1) {
		zhuang(n - 1);
	}
	for (int i = n - 2; i >= 1; i--) {
		if (sign[i] == 0) {
			xie(i);
		}
	}
	printf("%d: D\n", n);
	sign[n] = 1;
	return;
}