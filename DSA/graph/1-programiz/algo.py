"""
DFS pseudocode
DFS(G, u)
    u.visited = true
    for each v in G.adj[u]
        if v.visted == false
            DFS(G, v)

init()
    for each u in G
        u.visited = false
    for each u in G:
        DFS(G, u)
"""
def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)

    print(start)

    for next in graph[start] - visited:
        dfs(graph, next, visited)
    return visited


graph = {'0': set(['1', '2']),
         '1': set(['0', '3', '4']),
         '2': set(['0']),
         '3': set(['1']),
         '4': set(['2', '3'])}

dfs(graph, '0')


"""
BFS pseudocode

create a queue Q
mark V as visited and put v into Q
while q is not empty:
    remove the head u of q
    mark and enqueue all (unvisited) neighbour of u
"""

import collections

def bfs(graph, root):
    visited, queue = set(), collections.deque([root])
    visited.add(root)

    while queue:
        # dequeue a vertext from queue
        vertex = queue.popleft()
        print(str(vertex) + " ", end="")

        # if not visited, mark it as visited, and enqueue it
        for neighbour in graph[vertex]:
            if neighbour not in visited:
                visited.add(neighbour)
                queue.append(neighbour)

if __name__ == '__main__':
    graph = {0: [1, 2], 1: [2], 2: [3], 3: [1, 2]}
    print("Following is Breadth First Traversal: ")
    bfs(graph, 0)