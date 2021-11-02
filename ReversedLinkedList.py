# Given pointer to the head node of a linked list, the task is 
# to reverse the linked list. We need to reverse the list by 
# changing the links between nodes.

# Input: Head of following linked list 
# head -> 1 -> 2 -> 3 -> 4 -> NULL 
# Output: Linked list should be changed to, 
# head -> 4 -> 3 -> 2 -> 1 -> NULL

# Time Complexity O(n).

class Node:
 
    # Constructor to initialize the node object
    def __init__(self, data):
        self.data = data
        self.next = None
 
 
class LinkedList:
 
    # Function to initialize head
    def __init__(self):
        self.head = None
 
    # Function to reverse the linked list
    # Remember to keep track of 3 nodes: prev, current, next.
    def reverse(self):
        prev = None
        current = self.head
        while(current is not None):
            next = current.next
            current.next = prev
            prev = current
            current = next
        self.head = prev
 
    # Function to insert a new node at the beginning (into a stack)
    def push(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
 
    # Utility function to print the linked LinkedList
    def printList(self):
        temp = self.head
        while(temp):
            print (temp.data, end=", ")
            temp = temp.next
 
 
# Driver code
llist = LinkedList()
llist.push(20)
llist.push(4)
llist.push(15)
llist.push(85)
 
print ("Given Linked List")
llist.printList()
llist.reverse()
print ("\nReversed Linked List")
llist.printList()