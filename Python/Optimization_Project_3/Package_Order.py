class Pack:
    def __init__(self, cost, supplier, items):
        self.cost = cost
        self.supplier = supplier
        self.items = items
        self.num_items = len(items)


problems = {
    "Example 1": {
        "total_items": 12,
        "packs": [
            Pack(12, 1, [1, 2, 3, 4, 5, 6, 7, 8]),
            Pack(20, 2, [9, 10, 11, 12]),
            Pack(2, 3, [10, 11]),
            Pack(19, 4, [9, 12]),
            Pack(15, 5, [4, 5, 7, 8, 9]),
            Pack(20, 6, [1, 2, 3, 10, 11, 12])
            ],
    },
    "Example 2": {
        "total_items": 5,
        "packs": [
            Pack(12, 1, [1, 2]),
            Pack(20, 2, [3, 4, 5]),
            Pack(2, 3, [2]),
            Pack(19, 4, [3, 4])
            ],
    },
    "Example 3": {
        "total_items": 7,
        "packs": [
            Pack(11, 1, [1, 2, 4, 6]),
            Pack(16, 2, [3, 4, 5]),
            Pack(15, 3, [2, 7]),
            Pack(14, 4, [3, 4, 5, 7])
            ],
    },
    "Example 4": {
        "total_items": 12,
        "packs": [
            Pack(12, 1, [1, 2, 3, 4, 5, 6, 7, 8]),
            Pack(2, 2, [9, 10, 11, 12]),
            Pack(24, 3, [10, 11]),
            Pack(43, 4, [9, 12]),
            Pack(17, 5, [4, 5, 7, 8, 9]),
            Pack(50, 6, [1, 2, 3, 10, 11, 12])
            ],
    }

}


def union(list1, list2):
    return list(set(list1 + list2))


# using buuble sort because it is easy.
# there are much better sorting algorithms I could use
def sort_by_cost(packages):
    for i in range(0, len(packages) - 1):
        for j in range(0, len(packages) - i - 1):
            if (packages[j].cost > packages[j + 1].cost):
                packages[j], packages[j + 1] = packages[j + 1], packages[j]


# using buuble sort because it is easy.
# there are much better sorting algorithms I could use
def sort_by_num_items(packages):
    for i in range(0, len(packages) - 1):
        for j in range(0, len(packages) - i - 1):
            if (packages[j].num_items < packages[j + 1].num_items):
                packages[j], packages[j + 1] = packages[j + 1], packages[j]


def lowest_cost_heuristic(packages, total_items):
    suppliers = []
    total_cost = 0
    items = []

    sort_by_cost(packages)

    for package in packages:
        possible_addition = union(items, package.items)
        if(len(possible_addition) > len(items)):
            suppliers.append(package.supplier)
            total_cost = total_cost + package.cost
            items = possible_addition
            if(len(items) == total_items):
                break

    print("Found using lowest cost")
    print("Suppliers used:: {}".format(suppliers))
    print("Cost:: {}".format(total_cost))


def largest_catalog_heuristic(packages, total_items):
    suppliers = []
    total_cost = 0
    items = []

    sort_by_num_items(packages)

    for package in packages:
        possible_addition = union(items, package.items)
        if(len(possible_addition) > len(items)):
            suppliers.append(package.supplier)
            total_cost = total_cost + package.cost
            items = possible_addition
            if(len(items) == total_items):
                break

    print("Found using largest catalog")
    print("Suppliers used:: {}".format(suppliers))
    print("Cost:: {}".format(total_cost))


if __name__ == "__main__":
    for key in problems:
        problem = problems[key]
        print("\n{}".format(key))
        lowest_cost_heuristic(problem["packs"], problem["total_items"])
        print()
        largest_catalog_heuristic(problem["packs"], problem["total_items"])
