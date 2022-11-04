''' Python3 Program for recursive binary search.'''
# Time Complexity O(logn)
 
# Returns index of x in arr if present, else -1
def binarySearch (arr, left, right, x):
 
    # Check base case
    if right >= left:

        # calculate the middle index of the array
        mid = left + (right - left) // 2
 
        # If x is at the middle of the array
        if arr[mid] == x:
            return mid
         
        # If x < mid, then it can only be present in left subarray
        elif arr[mid] > x:
            return binarySearch(arr, left, mid-1, x)
 
        # Else the element can only be present in right subarray
        else:
            return binarySearch(arr, mid + 1, right, x)
 
    else:
        # Element is not present in the array
        return -1
 
# Driver Code
arr = [ 2, 3, 4, 10, 40 ]
x = 10
 
# Function call
result = binarySearch(arr, 0, len(arr)-1, x)
 
if result != -1:
    print ("Element is present at index %d" %result)
else:
    print ("Element is not present in array")


##################################################################
''' Python3 code to implement iterative Binary Search.'''
 
# It returns location of x in given array arr if present, else returns -1
def binarySearch2(arr, left, right, x):
 
    while left <= right:
 
        mid = left + (right - left) // 2;
         
        # Check if x is present at mid
        if arr[mid] == x:
            return mid

        # If x is smaller, ignore right half
        elif arr[mid] > x:
            right = mid - 1
 
        # If x is greater, ignore left half
        else:
            left = mid + 1
 
        
     
    # If we reach here, then the element
    # was not present
    return -1
 
# Driver Code
arr = [ 2, 3, 4, 10, 40 ]
x = 10
 
# Function call
result = binarySearch2(arr, 0, len(arr)-1, x)
 
if result != -1:
    print ("Element is present at index %d" %result)
else:
    print ("Element is not present in array")