a, b = map(int, input().split())
l = list(map(int, input().split()))

for i in range (a):
    if (l[i] < b):
        print(l[i], end=" ")