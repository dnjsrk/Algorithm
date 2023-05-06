n, m=map(int, input().split())
box = [i for i in range(1, n + 1)]

for i in range (m):
    a, b = map(int, input().split())
    temp = box[a - 1: b]
    temp.reverse()
    box[a - 1: b] = temp

for i in range (n):
    print(box[i], end=" ")