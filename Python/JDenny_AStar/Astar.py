import Tile as Tile
import CleaningRoom as CleaningRoom
import HeuristicFunctions as Heuristics


class Node:
    def __init__(self, location, parent, accrued_cost, heuristic_cost,
                 dirty_rooms_left, action, was_cleaned=False):
        self.location = location
        self.parent = parent
        self.accrued_cost = accrued_cost
        self.heuristic_cost = heuristic_cost
        self.dirty_rooms_left = dirty_rooms_left
        self.was_cleaned = was_cleaned
        self.action = action


class AStarTree:
    fringe_nodes = []
    at_goal_state = False
    nodes_expanded = 0

    def __init__(self, start_location, rooms_to_clean, heuristic):
        self.root = Node(start_location, None, 0, 0,
                         len(rooms_to_clean.list_of_dirty_rooms),
                         "Start")
        self.fringe_nodes.append(self.root)
        self.rooms_to_clean = rooms_to_clean
        self.heuristic = heuristic

    def insert(self, location, parent, accrued_cost, heuristic_cost,
               dirty_rooms_left, action, was_cleaned):
        child = Node(location, parent, accrued_cost, heuristic_cost,
                     dirty_rooms_left, action, was_cleaned)
        self.fringe_nodes.append(child)

    def traverse(self, parent, heuristic_function):
        if self.rooms_to_clean.rooms[parent.location[0]][
                            parent.location[1]].is_dirty:
            self.rooms_to_clean.list_of_dirty_rooms.remove(
                (parent.location[0],
                 parent.location[1]
                 )
                 )
            self.rooms_to_clean.rooms[parent.location[0]][
                                parent.location[1]].is_dirty = False
            self.fringe_nodes = []
            self.fringe_nodes.append(parent)
            self.insert(parent.location, parent,
                        parent.accrued_cost + 1 +
                        2*(parent.dirty_rooms_left - 1),
                        heuristic_function(
                            self.rooms_to_clean.rooms[parent.location[0]][
                                parent.location[1]],
                            self.rooms_to_clean,),
                        parent.dirty_rooms_left - 1,
                        "Cleaned",
                        True)

        else:
            if parent.location[0] > 0:
                self.insert((parent.location[0] - 1, parent.location[1]),
                            parent,
                            parent.accrued_cost + 1 +
                            2*parent.dirty_rooms_left,
                            heuristic_function(
                                self.rooms_to_clean.rooms[
                                    parent.location[0] - 1]
                                [parent.location[1]],
                                self.rooms_to_clean),
                            parent.dirty_rooms_left,
                            "Moved Right",
                            False)
            if parent.location[0] < self.rooms_to_clean.length - 1:
                self.insert((parent.location[0] + 1, parent.location[1]),
                            parent,
                            parent.accrued_cost + 1 +
                            2*parent.dirty_rooms_left,
                            heuristic_function(
                                self.rooms_to_clean.rooms[
                                    parent.location[0] + 1]
                                [parent.location[1]],
                                self.rooms_to_clean),
                            parent.dirty_rooms_left,
                            "Moved Left",
                            False)
            if parent.location[1] > 0:
                self.insert((parent.location[0], parent.location[1] - 1),
                            parent,
                            parent.accrued_cost + 1 +
                            2*parent.dirty_rooms_left,
                            heuristic_function(
                                self.rooms_to_clean.rooms[parent.location[0]]
                                [parent.location[1] - 1],
                                self.rooms_to_clean),
                            parent.dirty_rooms_left,
                            "Moved Down",
                            False)
            if parent.location[1] < self.rooms_to_clean.width - 1:
                self.insert((parent.location[0], parent.location[1] + 1),
                            parent,
                            parent.accrued_cost + 1 +
                            2*parent.dirty_rooms_left,
                            heuristic_function(
                                self.rooms_to_clean.rooms[parent.location[0]]
                                [parent.location[1] + 1],
                                self.rooms_to_clean),
                            parent.dirty_rooms_left,
                            "Moved Up",
                            False)

        self.fringe_nodes.remove(parent)

    def run(self):
        path = ""
        node_costs = ""
        current_node = self.root
        while len(self.rooms_to_clean.list_of_dirty_rooms) > 0:
            self.nodes_expanded = self.nodes_expanded + 1
            self.traverse(current_node, self.heuristic)
            current_node = min(self.fringe_nodes,
                               key=lambda n:
                               n.accrued_cost + n.heuristic_cost)

        while current_node is not None:
            path = "\n" + current_node.action + " : " + \
                str(current_node.location) + \
                path
            cost = current_node.accrued_cost + current_node.heuristic_cost
            node_costs = "=> " + str(cost) + node_costs
            current_node = current_node.parent

        print("Path:{0}\nCosts:{1}\nNodes Expanded: {2}".format(
            path,
            node_costs,
            self.nodes_expanded))
