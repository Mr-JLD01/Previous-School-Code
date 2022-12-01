#!/usr/bin/python


# problem functions
# format: [coeff x1, coeff x2, isMaximization]
opt_funcs = [
    [5, 6, 1],
    [8, 10, 1],
    [5, 6, 1],
    [10, 18, 1],
    [6, 0, 0],
    [3, 4, 1],
    [6, 0, 1]

]

# array means coefficient(c) in format:
# [coeff x1, coeff x2, RHS, isGreaterThan]
prob_constraints = [
    [
        [6, 4, 24, 0],
        [1, 2, 6, 0],
        [-1, 1, 1, 0],
        [0, 1, 2, 0],
        [1, 0, 0, 1],
        [0, 1, 0, 1]
    ],
    [
        [6, 4, 24, 0],
        [1, 2, 6, 0],
        [-1, 1, 1, 0],
        [0, 1, 2, 0],
        [1, 0, 0, 1],
        [0, 1, 0, 1]
    ],
    [
        [6, 4, 24, 0],
        [1, 2, 6, 0],
        [-1, 1, 1, 0],
        [0, 1, 2, 0],
        [1, 0, 5, 1],
        [1, 0, 0, 1],
        [0, 1, 0, 1]
    ],
    [
        [3, 2, 12, 0],
        [2, 4, 12, 0],
        [-1, 1, 1, 0],
        [0, 2, 4, 0],
        [1, 0, 0, 1],
        [0, 1, 0, 1]
    ],
    [
        [5, 0, 20, 1],
        [2, 0, 30, 1],
        [1, 0, 6, 1],
        [3, 0, 24, 1],
        [1, 0, 0, 1],
    ],
    [
        [1, 5, 20, 0],
        [1, 0, 2, 1],
        [1, 0, 0, 1],
        [0, 1, 0, 1]
    ],
    [
        [5, 0, 20, 0],
        [1, 0, 0, 1],
    ]
]


def intersection(constraint_1, constraint_2):
    """
    Finds the intersection point between two constraints
    """
    divisor = ((constraint_1[0]*constraint_2[1]) -
               (constraint_1[1]*constraint_2[0]))
    if (divisor == 0):
        return (None, None)
    x1 = ((constraint_1[2]*constraint_2[1]) -
          (constraint_1[1]*constraint_2[2])) / divisor
    x2 = ((constraint_1[0]*constraint_2[2]) -
          (constraint_1[2]*constraint_2[0])) / divisor
    return (x1, x2)


def is_feasible(constraints, test_values):
    """
    Finds if the intersection point follows all the constraints
    """
    follows_constraints = True
    if (test_values[0] is None or test_values[1] is None):
        return False
    for constraint in constraints:
        lhs = constraint[0]*test_values[0] + constraint[1]*test_values[1]
        rhs = constraint[2]
        if (constraint[3] == 0):
            follows_constraints = lhs <= rhs
        elif (constraint[3] == 1):
            follows_constraints = lhs >= rhs
        if (not follows_constraints):
            break

    return follows_constraints


def optimal_value(func_to_optimize, feasibility_region):
    '''
    Finds optimal value depending on min and max problem
    '''
    optimal_points = []
    optimal_val = None
    if (func_to_optimize[2] == 1):
        optimal_val = -999999999
    elif (func_to_optimize[2] == 0):
        optimal_val = 99999999999

    for point in feasibility_region:
        result = point[0]*func_to_optimize[0] + point[1]*func_to_optimize[1]
        if ((func_to_optimize[2] == 1 and result > optimal_val) or
           (func_to_optimize[2] == 0 and result < optimal_val)):
            optimal_val = result
            optimal_points = [point]
        elif (result == optimal_val):
            optimal_points.append(point)

    print("Optimal value is {0}: at point(s) {1}".format(
        optimal_val, optimal_points))


def intersect_values(opt_func, values):
    if (values[0] is None):
        return None
    return values[0]*opt_func[0] + values[1]*opt_func[1]


def optimization_runner(opt_func, constraints):
    """
    Runs all the problems
    """
    num_constraints = len(constraints)
    feasible_points = []
    for i in range(num_constraints):
        for j in range(i+1, num_constraints):
            test_intersect = intersection(constraints[i], constraints[j])
            print("{0} has a value of {1}".format(test_intersect,
                  intersect_values(opt_func, test_intersect)))
            if (is_feasible(constraints, test_intersect)):
                feasible_points.append(test_intersect)
    fr = list(set(feasible_points))
    print("\nThe feasibility reagion is {0}".format(fr))
    if (fr):
        optimal_value(opt_func, fr)
    else:
        print("There is no feasibility region!")
    print("")


def main():
    for i in range(7):
        print("Problem {0}:".format(i+1))
        optimization_runner(opt_funcs[i], prob_constraints[i])


if __name__ == "__main__":

    main()
