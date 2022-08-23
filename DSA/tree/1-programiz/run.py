# Tree traversal in Python


class Node:
    def __init__(self, item):
        self.left = None
        self.right = None
        self.val = item


def inorder(root):
    if root:
        # Traverse left
        inorder(root.left)
        # Traverse root
        print(str(root.val) + "->", end='')
        # Traverse right
        inorder(root.right)


def postorder(root):
    if root:
        # Traverse left
        postorder(root.left)
        # Traverse right
        postorder(root.right)
        # Traverse root
        print(str(root.val) + "->", end='')


def preorder(root):

    if root:
        # Traverse root
        print(str(root.val) + "->", end='')
        # Traverse left
        preorder(root.left)
        # Traverse right
        preorder(root.right)


root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

print("Inorder traversal ")
inorder(root)

print("\nPreorder traversal ")
preorder(root)

print("\nPostorder traversal ")
postorder(root)


#The following code is for checking if a tree is a full binary tree.
def isFullTree(root):
    if not root:
        return True
    if not root.left and not root.right:
        return True
    if root.left and root.right:
        return (isFullTree(root.left) and isFullTree(root.right))
    return False

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

if isFullTree(root):
    print("this tree is full binary")
else:
    print("The tree is not a full binary tree")


# A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.

# calculate the depth
def calculateDepth(node):
    d = 0
    while node:
        d += 1
        node = node.left
    return d

# check if the tree is perfect binary tree
def is_perfect(root, d, level = 0):
    # check if the tree is empty
    if not root:
        return True
    # check the presence of trees
    if not root.left and not root.right:
        return (d == level + 1)
    if not root.left or not root.right:
        return False
    return (is_perfect(root.left, d, level + 1) and is_perfect(root.right, d, level + 1))

root = None
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

if (is_perfect(root, calculateDepth(root))):
    print("The tree is a perfect binary tree")
else:
    print("The tree is not a perfect binary tree")


# A complete binary tree is a binary tree in which all the levels are completely filled except possibly the lowest one, which is filled from the left.
def count_nodes(root):
    if not root:
        return 0
    return (1 + count_nodes(root.left) + count_nodes(root.right))

# check if the tree is complete binary tree
def is_complete(root, index, numberNodes):
    # check if the tree is empty
    if not root:
        return True
    if index >= numberNodes:
        return False
    return (is_complete(root.left, 2*index+1, numberNodes) and is_complete(root.right, 2*index+2, numberNodes))
        
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)

node_count = count_nodes(root)
index = 0

if is_complete(root, index, node_count):
    print("The tree is a complete binary tree")
else:
    print("The tree is not a complete binary tree")