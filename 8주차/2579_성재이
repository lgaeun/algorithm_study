#2579

n = int(input())

Stair = [0 for i in range(301)]
MaxVal = [0 for i in range(301)]

for i in range(n) : 
    Stair[i] = int(input())
    print(Stair[i])

MaxVal[0] = Stair[0]
print(MaxVal[0])
MaxVal[1] = Stair[0] + Stair[1]
print(MaxVal[1])
MaxVal[2] = max(Stair[0], Stair[1]) + Stair[2]
print(MaxVal[2])
    
for i in range (3 ,n) : 
    MaxVal[i] = max(MaxVal[i-3] + Stair[i-1], MaxVal[i-2]) + Stair[i]
    print(MaxVal[i])

print(MaxVal[n-1])
