# In a undirected graph containing 5 nodes: S, A, B, C, D.
#   S - A,B,C
#   A - S,D
#   B - S,D
#   C - S,D
#   D - A,B,C
# First, visit S and explore any unvisited adjacent node from S.
# Adjacent nodes from S: A, B, and C. We can pick any of them.
# Let's visit A and enqueue it.
# Queue: A

# Let's visit B - the next unvisited adjacent node from S - and enqueue it.
# Queue: A, B

# Let's visit C - the last unvisited adjacent node from S - and enqueue it.
# Queue: A, B, C

# Since S has no more unvisited adjacent node, we dequeue and explore A.
# Queue: B, C

# Adjacent nodes from A: S and D. But S is visited.
# Let's visit D and enqueue it.
# Queue: B, C, D

# Since A has no more unvisited adjacent node, we dequeue and explore B.
# Queue: C, D

# Since B and C has no more unvisited adjacent node, we keep on dequeuing in order to get all unvisited nodes. 
# When the queue gets emptied, the program is over.

# Order of this BFS: S -> A -> B -> C -> D

''' Python3 Program to print BFS traversal'''
# from a given source vertex. BFS(int s)
# traverses vertices reachable from s.
from collections import defaultdict
 
# This class represents a directed graph
# using adjacency list representation
class Graph:
 
    # Constructor
    def __init__(self):
 
        # default dictionary to store graph
        self.graph = defaultdict(list)
 
    # function to add an edge to graph
    def addEdge(self,u,v):
        self.graph[u].append(v)
 
    # Function to print a BFS of graph
    def BFS(self, s):
 
        # Mark all the vertices as not visited
        visited = [False] * (max(self.graph) + 1)
 
        # Create a queue for BFS
        queue = []
 
        # Mark the source node as visited and enqueue it
        queue.append(s)
        visited[s] = True
 
        while queue:
 
            # Dequeue a vertex from queue and print it
            s = queue.pop(0)
            print (s, end = " ")
 
            # Get all adjacent vertices of the dequeued vertex s. If a adjacent
            # has not been visited, then mark it
            # visited and enqueue it
            for i in self.graph[s]:
                if visited[i] == False:
                    queue.append(i)
                    visited[i] = True
 
# Driver code
 
# Create a graph given in
# the above diagram
g = Graph()
g.addEdge(0, 1)
g.addEdge(0, 2)
g.addEdge(1, 2)
g.addEdge(2, 0)
g.addEdge(2, 3)
g.addEdge(3, 3)
 
print ("Following is Breadth First Traversal (starting from vertex 2)")
g.BFS(2)