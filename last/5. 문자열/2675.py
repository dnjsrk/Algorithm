n = int(input())

for i in range(n):
  cnt, word = input().split()
  for j in range(len(word)):
    for k in range(int(cnt)):
      print(word[j], end='')
  print()