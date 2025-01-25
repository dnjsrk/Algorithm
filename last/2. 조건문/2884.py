h, m = input().split()

hour = int(h)
minute = int(m)

time = (hour * 60) + minute - 45

if time < 0:
    hour = 23
    minute = 60 + time
else:
  hour = time // 60
  minute = time % 60

print(hour, minute)