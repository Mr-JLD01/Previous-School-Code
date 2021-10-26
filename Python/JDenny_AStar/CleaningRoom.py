
import Tile as Tile


class CleaningRoom:

    def __init__(self, length, width, list_of_dirty_tiles):
        self.length = length
        self.width = width
        self.rooms = [[0 for le in range(length)] for wi in range(width)]
        self.list_of_dirty_rooms = list_of_dirty_tiles
        # self.original_list = self.list_of_dirty_tiles.copy()

    def set_tiles(self):
        for hall in range(0, len(self.rooms)):
            for room in range(0, len(self.rooms[hall])):
                is_dirty_room = True if (
                    (hall, room) in self.list_of_dirty_rooms) else False
                self.rooms[hall][room] = Tile.Tile(hall, room, is_dirty_room)
