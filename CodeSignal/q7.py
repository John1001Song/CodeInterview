'''
Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.

Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing only one element is also considered to be strictly increasing.

Example

For sequence = [1, 3, 2, 1], the output should be
almostIncreasingSequence(sequence) = false.

There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
almostIncreasingSequence(sequence) = true.

You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].

Input/Output

[execution time limit] 4 seconds (py3)

[input] array.integer sequence

Guaranteed constraints:
2 ≤ sequence.length ≤ 105,
-105 ≤ sequence[i] ≤ 105.

[output] boolean

Return true if it is possible to remove one element from the array in order to get a strictly increasing sequence, otherwise return false.
'''


# def almostIncreasingSequence(sequence):
#     print('input: ', sequence)
#     left = sequence[0]
#     counter_one = 1
#     counter_two = 1
#     index = 1
#     copy_one = list()
#     copy_two = list()
#
#
#     if len(sequence) <= 2:
#         return True
#
#     if left >= sequence[1]:
#         counter_one -= 1
#         counter_two -= 1
#     else:
#         copy_one.append(left)
#         copy_two.append(left)
#         left = sequence[1]
#         index += 1
#
#     copy_one.append(left)
#     copy_two.append(left)
#
#     while index < len(sequence):
#         if left >= sequence[index]:
#             counter_one -= 1
#             counter_two -= 1
#             copy_one.append(left)
#         else:
#
#             copy_two.append(left)
#         if counter_one < 0 and counter_two < 0:
#             return False
#         else:
#
#     else:
#         while index < len(sequence):
#             if left >= sequence[index]:
#                 counter_one -= 1
#                 if counter_one < 0:
#                     return False
#             else:
#                 copy_one.append(left)
#             left = sequence[index]
#             index += 1
#
#         print('copy_one: ', copy_one, '\n')
#
#         left = copy_one[0]
#         index = 1
#         while index < len(copy_one):
#             print('left: ', left)
#             print('index: ', index)
#             print('copy_one[', index, ']: ', copy_one[index], '\n')
#             if left >= copy_one[index]:
#                 return False
#             left = copy_one[index]
#             index += 1
#
#         return True

# get the solution from https://stackoverflow.com/questions/43017251/solve-almostincreasingsequence-codefights
# user sukai

# the key idea is checking two cases:
# sequence 1: remove current element
# sequence 2: remove the next element

def almostIncreasingSequence(sequence):

    #Take out the edge cases
    if len(sequence) <= 2:
        return True

    #Set up a new function to see if it's increasing sequence
    def IncreasingSequence(test_sequence):
        if len(test_sequence) == 2:
            if test_sequence[0] < test_sequence[1]:
                return True
        else:
            for i in range(0, len(test_sequence)-1):
                if test_sequence[i] >= test_sequence[i+1]:
                    return False
                else:
                    pass
            return True

    for i in range (0, len(sequence) - 1):
        if sequence[i] >= sequence [i+1]:
            #Either remove the current one or the next one
            test_seq1 = sequence[:i] + sequence[i+1:]
            test_seq2 = sequence[:i+1] + sequence[i+2:]
            if IncreasingSequence(test_seq1) == True:
                return True
            elif IncreasingSequence(test_seq2) == True:
                return True
            else:
                return False

if __name__ == '__main__':
    #[1, 2, 3, 4, 99, 5, 6]
    #[10, 1, 2, 3, 4, 5, 6]
    result = almostIncreasingSequence([1, 2, 3, 4, 3, 6])
    print("final result: ", result)