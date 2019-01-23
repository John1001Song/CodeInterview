'''
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

Input/Output

[execution time limit] 4 seconds (py3)

[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false.
'''


def sudoku2(grid):
    # print('grid: ', grid)

    size = len(grid[0])
    temp_list = list()
    temp_set = set()
    # print('size: ', size)
    for row in grid:
        for ele in row:
            if ele != '.':
                temp_list.append(ele)
                temp_set.add(ele)
        # print('temp_list: ', temp_list)
        # print('temp_set: ', temp_set)
        if len(temp_list) != len(temp_set):
            return False
        temp_list = list()
        temp_set = set()

    # print('=========================')
    col_index = 0
    row_index = 0
    while col_index < size:
        while row_index < size:
            # print('\nsize: ', size)
            # print('col_index: ', col_index)
            # print('row_index: ', row_index)
            if grid[row_index][col_index] != '.':
                temp_list.append(grid[row_index][col_index])
                temp_set.add(grid[row_index][col_index])
            row_index += 1

        # print('\ntemp_list: ', temp_list)
        # print('temp_set: ', temp_set)
        # print('col_index: ', col_index)
        # print('row_index: ', row_index)

        if len(temp_list) != len(temp_set):
            return False
        row_index = 0
        col_index += 1
        temp_list = list()
        temp_set = set()

    temp_3by3_list = list()
    temp_3by3_set = set()
    row_index = 0
    col_index = 0
    while col_index <= size - 3:
        while row_index <= size - 3:
            for i in range(3):
                for j in range(3):
                    if grid[row_index + i][col_index + j] != '.':
                        temp_3by3_list.append(grid[row_index + i][col_index + j])
                        temp_3by3_set.add(grid[row_index + i][col_index + j])
            row_index += 1
            print('\ntemp_list: ', temp_3by3_list)
            print('temp_set: ', temp_3by3_set)
            print('col_index: ', col_index)
            print('row_index: ', row_index)
            if len(temp_3by3_list) != len(temp_3by3_set):
                return False
            temp_3by3_list = list()
            temp_3by3_set = set()

        row_index = 0
        col_index += 1
        temp_3by3_list = list()
        temp_3by3_set = set()

    return True

if __name__ == '__main__':
    grid= [[".", ".", ".", "1", "4", ".", ".", "2", "."],
           [".", ".", "6", ".", ".", ".", ".", ".", "."],
           [".", ".", ".", ".", ".", ".", ".", ".", "."],
           [".", ".", "1", ".", ".", ".", ".", ".", "."],
           [".", "6", "7", ".", ".", ".", ".", ".", "9"],
           [".", ".", ".", ".", ".", ".", "8", "1", "."],
           [".", "3", ".", ".", ".", ".", ".", ".", "6"],
           [".", ".", ".", ".", ".", "7", ".", ".", "."],
           [".", ".", ".", "5", ".", ".", ".", "7", "."]]

    # grid= [[".", "4", ".", ".", ".", ".", ".", ".", "."],
    #        [".", ".", "4", ".", ".", ".", ".", ".", "."],
    #        [".", ".", ".", "1", ".", ".", "7", ".", "."],
    #        [".", ".", ".", ".", ".", ".", ".", ".", "."],
    #        [".", ".", ".", "3", ".", ".", ".", "6", "."],
    #        [".", ".", ".", ".", ".", "6", ".", "9", "."],
    #        [".", ".", ".", ".", "1", ".", ".", ".", "."],
    #        [".", ".", ".", ".", ".", ".", "2", ".", "."],
    #        [".", ".", ".", "8", ".", ".", ".", ".", "."]]

    print('\nresult: ', sudoku2(grid))