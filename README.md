# Boggle Game
Contributer: Yuchen Shao (Winnie)

## Introduction
The application uses Depth First Search to find all the possible answers on the board.

for every node(character) on the board: mark the node as visited "generate" all possible words using the node as the start of the word mark the node as unvisited proceed to the next node on the board

generate (Starting node, word we have so far): check if the word so far is valid for every neighbour node: skip it if been visited mark the neighbouring node as visited generate(neighbouring node, current word + neighbourign character); mark the neighbouring node as not visited
