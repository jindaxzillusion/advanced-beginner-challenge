class Node:
    def __init__(self, item):
        self.left = None
        self.right = None
        self.key = item

class Height:
    def __init__(self):
        self.height = 0

def inorder(root):
    if root is not None:
        # Traverse left
        inorder(root.left)

        # Traverse root
        print(str(root.key) + "->", end=' ')

        # Traverse right
        inorder(root.right)

def isHeightBalanced(root, height):
    left_height = Height()
    right_height = Height()

    if not root:
        return True
    l = isHeightBalanced(root.left, left_height)
    r = isHeightBalanced(root.right, right_height)

    height.height = max(left_height.height, right_height.height) + 1

    if abs(left_height.height - right_height.height) <= 1:
        return l and r
    return False

height = Height()

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

if isHeightBalanced(root, height):
    print('The tree is balanced')
else:
    print('The tree is not balanced')

# insert a node
def insert(node, key):
    # return a new node if the tree is empty
    if not node:
        return Node(key)
    if key < node.key:
        node.left = insert(node.left, key)
    else:
        node.right = insert(node.right, key)
    return node

# find the inorder successor
def minValueNode(node):
    current = node
    # find the leftmost leaf
    while current.left:
        current = current.left
    return current


# delete a node
def deleteNode(root, key):
    # return if the tree is empty
    if not root:
        return root
    # find the node to be deleted
    if key < root.key:
        root.left = deleteNode(root.left, key)
    elif key > root.key:
        root.right = deleteNode(root.right, key)
    else:
        # if the node is with only one child or no child
        if not root.left:
            temp = root.right
            root = None
            return temp
        elif not root.right:
            temp = root.left
            root = None
            return temp
        # if the node has two children, place the inorder successor in position of the node to be deleted
        temp = minValueNode(root.right)

        root.key = temp.key
        
        # delete the inorder successor
        root.right = deleteNode(root.right, temp.key)
    return root

root = None
root = insert(root, 8)
root = insert(root, 3)
root = insert(root, 1)
root = insert(root, 6)
root = insert(root, 7)
root = insert(root, 10)
root = insert(root, 14)
root = insert(root, 4)

print("Inorder traversal: ", end=' ')
inorder(root)

print("\nDelete 10")
root = deleteNode(root, 10)
print("Inorder traversal: ", end=' ')
inorder(root)



