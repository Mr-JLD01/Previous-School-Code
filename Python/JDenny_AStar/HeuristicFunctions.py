import CleaningRoom as CleaningRoom
import Tile as Tile


def closest_room_heuristic(current_tile, cleaning_room):
    room_dist = []
    for room in cleaning_room.list_of_dirty_rooms:
        current_tile.calculate_manhattan_distance(room)
        room_dist.append(current_tile.manhattan_distance)

    try:
        return len(
            cleaning_room.list_of_dirty_rooms) + min(room_dist)
    except ValueError:
        return 0


def farthest_room_heuristic(current_tile, cleaning_room):
    room_dist = []
    for room in cleaning_room.list_of_dirty_rooms:
        current_tile.calculate_manhattan_distance(room)
        room_dist.append(current_tile.manhattan_distance)
    try:
        return len(
            cleaning_room.list_of_dirty_rooms) + max(room_dist)
    except ValueError:
        return 0
