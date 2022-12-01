#!/usr/bin/python

# To add pairs, either alter the values or
# add a list of two numbers
from json.encoder import INFINITY


pairs = [
    # Case 1: already reciprocals
    [3, 1/3],
    [.5, 2],
    [5, .2],
    [13, 1/13],
    # Case 2: At least 1 number is > 1
    [1, 2],
    [7, .2],
    [2**(1.0/3.0), 2**(1.0/3.0)],
    [1.1, 1.1],
    [1.01, 1.01],
    [2, 8],
    [4, 2],
    [.2, 6],
    [4, .2],
    [.2, 6666],
    [46784, 34856],
    # Case 3: both numbers are < 1
    [.99, .99],
    [.9, .9],
    [.5, .5],
    [.7, .5],
    [.9, .8],
    [.123456, .22225],
    [0, 0]
]


def find_min_adjustment_both_to_one(num1, num2):
    """Finds the minimum adjustment needed to make num1 and num2
    reciprocals of each other. Finds the adjustment to make
    both numbers equal to 1.

    Args:
        num1 (int or float): a number
        num2 (int or float): a number

    Returns:
        float : the adjustment needed to make num1 and num2 == 1
    """
    if (num1 * num2 == 1):
        return 0
    return abs((1 - num1)) + abs((1 - num2))


def find_min_adjustment_adjust_smallest(num1, num2):
    """Finds the minimum adjustment needed to make num1 and num2
    reciprocals of each other. Is based on the conjecture explained
    in my project submission.

    Args:
        num1 (int or float): a number
        num2 (int or float): a number

    Returns:
        float : the adjustment needed to make num1 and num2 reciprocals
    """
    if(num1 == 0 and num2 == 0):
        return INFINITY
    if (num1 * num2 == 1):
        return 0
    if(num1 == 0):
        reciprocal = find_reciprocal(num2)
    elif(num2 == 0):
        reciprocal = find_reciprocal(num1)
    else:
        reciprocal = find_reciprocal(max(num1, num2))
    num_to_adjust = min(num1, num2)
    if (num_to_adjust >= 1):
        return (num_to_adjust - 1) + (1.0 - reciprocal)
    else:
        return abs(num_to_adjust - reciprocal)


def find_min_adjustment_hybrid(num1, num2):
    """Finds the minimum adjustment needed to make num1 and num2
    reciprocals of each other. Using a hybrid of both to one and
    adjust smallest num.

    Args:
        num1 (int or float): a number
        num2 (int or float): a number

    Returns:
        float : the ]adjustment needed to make num1 and num2 reciprocals
    """
    if (num1 * num2 == 1):
        return 0
    if (num1 < 1 and num2 < 1):
        return find_min_adjustment_both_to_one(num1, num2)
    return find_min_adjustment_adjust_smallest(num1, num2)


def find_reciprocal(num):
    """Finds the reciprocal of a number

    Args:
        num (int or float): number to find reciprocal of

    Returns:
        float : value for the reciprocal of a number
    """
    return 1.0 / num


def main():
    for pair in pairs:
        hybrid = find_min_adjustment_hybrid(pair[0], pair[1])
        to_one = find_min_adjustment_both_to_one(pair[0], pair[1])
        smallest = find_min_adjustment_adjust_smallest(pair[0], pair[1])
        print("Pair: {}".format(str((pair[0], pair[1]))))
        print("\tHybrid: {0}".format(hybrid))
        print("\tTo One: {0}".format(to_one))
        print("\tSmallest: {0}\n".format(smallest))


if __name__ == '__main__':
    main()
