#include<stdio.h>
int main() {
	int sign;
	struct duoxiangshi* t1, * t2, * t3;
	printf("1.输入两个链表\n");
	printf("2.合并并且输出输入的两个多项式的系数和指数\n");
	printf("0.结束\n");
	printf("请输入操作数\n");
	scanf("%d", &sign);
	while (sign != 0) {
		switch (sign) {
		case 1:
			printf("输入第一个多项式（只要输入系数和整数）:");
			t1 = creat();
			printf("多项式1");
			xianshi(t1);
			printf("输入第二个多项式（只要输入系数和整数）:");
			t2 = creat();
			printf("多项式2");
			xianshi(t2);
			break;
		case 2:
			printf("合并输入的两个多项式");
			t3=hebing(h1, h2);
			printf("合并后的多项式：");
			show(t3);
			break;
		case 0:
			break;
		default:
			printf("输入错误清重新输入\n");	
		}
		scanf("%d", &sign);
	}
}