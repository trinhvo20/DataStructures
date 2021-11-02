# In a undirected graph containing 5 nodes: S, A, B, C, D.
#   S - A,B,C
#   A - S,D
#   B - S,D
#   C - S,D
#   D - A,B,C
# First, visit S and put it in the stack.
# Stack: S

# Explore any unvisited adjacent node from S. 
# Adjacent nodes from S: A, B, and C, and we can pick any of them.
# Let's visit A and put it in the stack.
# Stack: S, A

# Explore any unvisited adjacent node from A. 
# Adjacent nodes from A: S and D,but S is visited.
# Let's visit D and put it in the stack.
# Stack: S, A, D

# Explore any unvisited adjacent node from D. 
# Adjacent nodes from D: A, B and C, but A is visited and B,C are unvisited.
# Let's visit B and put it in the stack.
# Stack: S, A, D, B

# Explore any unvisited adjacent node from B.
# Adjacent nodes from B: S and C but they are all visited.
# Remove B from the stack.
# Stack: S, A, D

# Explore any unvisited adjacent node from D. 
# Adjacent nodes from D: B and C, but B is visited.
# Let's visit C and put it in the stack.
# Stack: S, A, D, C

# As C does not have any unvisited adjacent node so we keep popping the stack 
# until we find a node that has an unvisited adjacent node. 
# In this case, there's none and we keep popping until the stack is empty.

# Order of this DFS: S -> A -> D -> B -> C

''' Algorithm:''' 
# 1. Create a recursive function that takes the index of the node
#    and a visited array.
# 2. Mark the current node as visited and print the node.
# 3. Traverse all the adjacent and unmarked nodes and 
#    call the recursive function with the index of the adjacent node.
# 4. Run a loop from 0 to the number of vertices and check if the node
#    is unvisited in the previous DFS, call the recursive function 
#    with the current node.

'''Python program to print DFS traversal for complete graph'''
from collections import defaultdict
  
# this class represents a directed graph using adjacency list representation
  
class Graph:
    # Constructor 
    def __init__(self):
        # default dictionary to store graph
        self.graph=defaultdict(list)
      
    # Function to add an edge to graph
    def addEdge(self,u,v):
        self.graph[u].append(v)
    
    # The function to do DFS traversal. It uses recursive DFSUtil
    def DFS(self):
        # create a set to store all visited vertices
        visited=set()
        # call the recursive helper function to print DFS traversal 
        # starting from all vertices one by one
        for vertex in self.graph:
            if vertex not in visited:
                self.DFSUtil(vertex,visited)

    # A function used by DFS
    def DFSUtil(self,v,visited):
        # Mark the current node as visited and print it
        visited.add(v)
        print(v)
          
        # recur for all the vertices adjacent to this vertex
        for neighbour in self.graph[v]:
            if neighbour not in visited:
                self.DFSUtil(neighbour,visited)

# Driver code
# create a graph given in the above diagram
  
# g=Graph()
# g.addEdge(0,1)
# g.addEdge(0,2)
# g.addEdge(1,2)
# g.addEdge(2,0)
# g.addEdge(2,3)
# g.addEdge(3,3)
# g.DFS()

g=Graph()
g.addEdge(0,1)
g.addEdge(0,2)
g.addEdge(0,3)
g.addEdge(1,4)
g.addEdge(2,4)
g.addEdge(3,4)
g.DFS()