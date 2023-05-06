l = []
max_n = 0
max_l = 0

for i in range (9):
    a = int(input())
    l.append(a)

for i in range (9):
    if (max_n < l[i]):
        max_n = l[i]
        max_l = i + 1

print(max_n)
print(max_l)