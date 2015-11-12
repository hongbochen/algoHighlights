#include <stdio.h>
#include <stdlib.h>

int cmp(const void* a,const void* b)
{
    const int *arg1 = a;
    const int *arg2 = b;

    return *arg1 - *arg2;
}

int main()
{
	int n,m;
    int i,j;
    
    while(1){
        scanf("%d%d",&n,&m);
        
        if(n == 0 && m == 0)
            break;

        int *ns,*ms;
        ns = (int *)malloc(n * sizeof(int));
        ms = (int *)malloc(m * sizeof(int));

        for(i = 0;i < n;i++)
            scanf("%d",&ns[i]);

        for(i = 0;i < m;i++)
            scanf("%d",&ms[i]);

        qsort(ns,n,sizeof(int),cmp);
        qsort(ms,m,sizeof(int),cmp);

        int cur = 0; //需要砍掉的头的编号
        int cost = 0; //当前总费用

        for(i = 0;i < m;i++)
        {
            if(ms[i] >= ns[cur])
            {
                cost += ms[i];
                if(++cur == n) break;
            }
        }

        if(cur < n) printf("Loowater is doomed!\n");
        else printf("%d\n",cost);   
    }	

	return 0;
}
