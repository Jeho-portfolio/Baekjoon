N, X = map(int, input() .split())
A = list(map(int, input() .split()))

for i in range(0, N, 1) :
    if (A[i] < X) :
        print("%d " %A[i], end ='')