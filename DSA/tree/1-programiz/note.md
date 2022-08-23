Root
It is the topmost node of a tree.

Height of a Node
The height of a node is the number of edges from the node to the deepest leaf (ie. the longest path from the node to a leaf node).

Depth of a Node
The depth of a node is the number of edges from the root to the node.

Height of a Tree
The height of a Tree is the height of the root node or the depth of the deepest node.

Degree of a Node
The degree of a node is the total number of branches of that node.

Forest
A collection of disjoint trees is called a forest.

Tree Applications
Binary Search Trees(BSTs) are used to quickly check whether an element is present in a set or not.
Heap is a kind of tree that is used for heap sort.
A modified version of a tree called Tries is used in modern routers to store routing information.
Most popular databases use B-Trees and T-Trees, which are variants of the tree structure we learned above to store their data
Compilers use a syntax tree to validate the syntax of every program you write.

# Inorder traversal
First, visit all the nodes in the left subtree
Then the root node
Visit all the nodes in the right subtree
inorder(root->left)
display(root->data)
inorder(root->right)

