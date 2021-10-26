class Tile:
    def __init__(self, x_coordinate, y_coordinate, is_dirty=False):
        self.x_coordinate = x_coordinate
        self.y_coordinate = y_coordinate
        self.is_dirty = is_dirty

    def change_clean_status(self, new_status):
        self.is_dirty = new_status

    def calculate_manhattan_distance(self, other_tile):
        self.manhattan_distance = abs(
            self.x_coordinate - other_tile[0]) + abs(
                self.y_coordinate - other_tile[1])
