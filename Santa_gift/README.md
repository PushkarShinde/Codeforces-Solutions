# [A. Santa's Gift Packaging](https://codeforces.com/group/X1jmHxEVlA/contest/576957/problem/A)

## Problem Statement
Santa Claus is busy preparing gifts for Christmas and wants to pack them efficiently. He has two types of gift boxes available:

- A cuboid-shaped box with dimensions: length \(L\), breadth \(B\), and height \(H\).
- A cube-shaped box with side length \(S\).

To minimize space, Santa will always choose the box with the smaller volume to pack the gift. Your task is to help Santa decide which box to use.

The formulas for the volume of the boxes are as follows:

- The volume of a cuboid is \(L \cdot B \cdot H\).
- The volume of a cube is \(S^3\).

If the cube has a smaller volume, print `CUBE`. If the cuboid has a smaller volume, print `CUBOID`. If both have the same volume, print `EQUAL`.

## Input
The first line contains a single integer \(t\) \((1 \leq t \leq 10^3)\) — the number of test cases. Then, \(t\) test cases follow.

Each test case consists of a single line containing four space-separated integers \(L, B, H,\) and \(S\) \((1 \leq L, B, H, S \leq 100)\) — the length, breadth, and height of the cuboid, and the side length of the cube, respectively.

## Output
Print one of the following:

- `CUBE` if the cube has the smaller volume.
- `CUBOID` if the cuboid has the smaller volume.
- `EQUAL` if their volumes are the same.

You may print each letter in any case you prefer (for example, the strings "cUbe", "Cube", "cuBE", and "cube" will all be accepted if the cube has a smaller volume).

## Examples
### Input
```
5
1 2 3 4
3 3 3 3
1 18 3 2
97 30 21 97
4 1 2 2
```
### Output
```
CUBOID
EQUAL
CUBE
CUBOID
EQUAL
```

## Note
Test Case 1:

Given \(L=1, B=2, H=3, S=4\): The volume of the cuboid is \(L \cdot B \cdot H = 1 \cdot 2 \cdot 3 = 6\). The volume of the cube is \(S^3 = 4^3 = 64\). Since \(6 < 64\), the cuboid is chosen. Therefore, the output is `CUBOID`.

