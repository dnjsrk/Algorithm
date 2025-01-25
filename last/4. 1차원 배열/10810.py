n, m=map(int, input().split())
box = [0]*n

for i in range (m):
    a, b, c = map(int, input().split())
    for j in range (a, b + 1):
        box[j - 1] = c

for i in range (n):
    print(box[i], end=" ")