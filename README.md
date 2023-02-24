# COP4520-A2
Assignment #2 for COP4520.

### To run:
javac {file}.java
java {file}

## Problem 1 strategy:

An optimal strategy for this problem is to allow one of the guests to be the leader/counter of the rest of them. Whenever they encounter an empty plate, they can add one to the counter and then request a new cupcake. The counter is the only guest with the authority to request a new cupcake. As such, as everyone else goes into the maze, they will eat the cupcake ONLY IF there is a cupcake present, AND if they have not eaten one yet. If they have already eaten one, they leave it. Once again, they will not request a new cupcake either -- that is only for the counter to do. Once the counter sees an empty plate, they will add one to the count and request a new cupcake. As a result, the counter is sure that every person has but him has eaten the cupcake once he has counted to n-1. 

## Problem 2 strategy:
For Problem 2, I believe that strategy #3, the queue system is optimal. I think that it's best and fairest because all guests will end up having an equal opportunity to view the vase. The first approach is flawed because some guests may need to wait a long time and there is also the risk of several guests trying to access the door at the same time. This can end up causing further delays as the guest who is leaving will need to deal with multiple people at the door trying to enter. Furthermore, the second approach is better, with the sign, but some guests can still miss out if the room happens to be occupied when they approach the door. This strategy is still superior to strategy 1, however, as guests will not need to try the door to see if it's occupied - the sign allows for them to quickly see. It also eliminates the possibility crowding. Strategy 3, with the queue, is the best, as everyone will get their turn provided they wait in the line.
