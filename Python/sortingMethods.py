"""
John Luke Denny
Short Cicuit bubble sort, Insertion sort, Selection sort, and Merge
 sort in python
"""


def bubble_sort(int_list):
    """Takes a numerical list and sorts in ascending order using bubble sort
     with short circuit

    Args:\n
        int_list (list): a numerical list.
    """

    assert_numerical_list(int_list)

    for i in range(len(int_list)):
        swap = False
        for j in range((len(int_list) - i - 1)):
            if int_list[j] > int_list[j + 1]:
                int_list[j + 1], int_list[j] = int_list[j], int_list[j + 1]
                swap = True
        if not swap:
            break


def selection_sort(int_list):
    """Takes a numerical list and sorts in ascending order using selection sort

    Args:\n
        int_list (list): a numerical list.
    """

    assert_numerical_list(int_list)

    for i in range(len(int_list)):
        min_index = i
        for j in range(i + 1, (len(int_list))):
            if int_list[min_index] > int_list[j]:
                min_index = j
        int_list[i], int_list[min_index] = int_list[min_index], int_list[i]


def insertion_sort(int_list):
    """Takes a numerical list and sorts in ascending order using insertion sort

    Args:\n
        int_list (list): a numerical list.
    """

    assert_numerical_list(int_list)

    for i in range(len(int_list)):
        key = int_list[i]
        j = i - 1

        while j >= 0 and int_list[j] > key:
            int_list[j + 1] = int_list[j]
            j -= 1
        int_list[j + 1] = key


def merge_sort(int_list):
    """Takes a numerical list and sorts in ascending order using merge sort

    Args:\n
        int_list (list): a numerical list.
    """

    assert_numerical_list(int_list)

    if len(int_list) == 1:
        return

    mid = int(len(int_list) / 2)
    left = []
    right = []

    for i in range(mid):
        left.append(int_list[i])

    for j in range(mid, len(int_list)):
        right.append(int_list[j])

    merge_sort(left)
    merge_sort(right)

    merge(int_list, left, right, len(left), len(right))


def merge(array, left, right, l_len, r_len):
    """merges two lists in increasing order

    Args:\n
        array (list): list being sorted
        left (list): left half of list
        right (list): right half of list
        l_len (int): lenght for left list
        r_len (int): length for right list
    """

    # index variables
    i = 0
    j = 0
    k = 0

    while i < l_len and j < r_len:

        if left[i] <= right[j]:
            array[k] = left[i]
            i += 1
        else:
            array[k] = right[j]
            j += 1

        k += 1

    while i < l_len:
        array[k] = left[i]
        k += 1
        i += 1

    while j < r_len:
        array[k] = right[j]
        k += 1
        j += 1


def assert_numerical_list(var_list):
    """function to assert varable is a list of numeric values

    Args:\n
        var_list (unknown): variable to test
    """
    assert type(var_list) == list, "Not a list\n"
    for var in var_list:
        assert type(var) == int or type(var) == float,\
            "Not all values are numbers\n"


def main():
    test_list = [3, 5, 6, 3, 7, 2, 87, 2, 7]
    bubble_sort(test_list)
    print(test_list)

    test_list = [3, 5, 6, 3, 7, 2, 87, 2, 7]
    selection_sort(test_list)
    print(test_list)

    test_list = [3, 5, 6, 3, 7, 2, 87, 2, 7]
    insertion_sort(test_list)
    print(test_list)

    test_list = [3, 5, 6, 3, 7, 2, 87, 2, 7]
    merge_sort(test_list)
    print(test_list)


if __name__ == "__main__":
    main()
