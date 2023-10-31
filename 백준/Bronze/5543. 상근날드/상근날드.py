S = int(input())
J = int(input())
H = int(input())
C = int(input())
P = int(input())

B_M = 2000
if (S < B_M) :
    B_M = S
if (J < B_M) :
    B_M = J
if (H < B_M) :
    B_M = H

M_M = 2000
if (C < M_M) :
    M_M = C
if (P < M_M) :
    M_M = P

Min = B_M + M_M - 50

print(Min)