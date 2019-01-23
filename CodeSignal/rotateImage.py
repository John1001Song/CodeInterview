'''
Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

Example

For

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
Input/Output

[execution time limit] 4 seconds (py3)

[input] array.array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 100,
a[i].length = a.length,
1 ≤ a[i][j] ≤ 104.

[output] array.array.integer
'''

# get solution from
# https://leetcode.com/problems/rotate-image/solution/

def rotateImage(a):
    size = len(a[0])
    for i in range(size // 2 + size % 2):
        for j in range(size // 2):
            tmp = [0] * 4
            row, col = i, j
            for k in range(4):
                tmp[k] = a[row][col]
                row, col = col, size - 1 - row
            for k in range(4):
                a[row][col] = tmp[(k - 1) % 4]
                row, col = col, size - 1 - row

    return a