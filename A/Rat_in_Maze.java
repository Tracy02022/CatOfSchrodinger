/*
Rat in Maze
*/
/*
Naive Algorithm
while there are untried paths
{
   generate the next path
   if this path has all blocks as 1
   {
      print this path;
   }
}

Backtrackng Algorithm
If destination is reached
    print the solution matrix
Else
   a) Mark current cell in solution matrix as 1. 
   b) Move forward in horizontal direction and recursively check if this 
       move leads to a solution. 
   c) If the move chosen in the above step doesn't lead to a solution
       then move down and check if  this move leads to a solution. 
   d) If none of the above solutions work then unmark this cell as 0 
       (BACKTRACK) and return false.
*/
