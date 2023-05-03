H, M = map(int, input().split())
timer = int(input())

time = H * 60 + M + timer

H = time // 60
M = time % 60

if H >= 24:
    H -= 24

print(H, M)