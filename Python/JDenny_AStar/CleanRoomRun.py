import CleaningRoom as CleaningRoom
import HeuristicFunctions as heurstic
import Astar as AStar

if __name__ == "__main__":
    dirty_list = [(0, 4), (1, 4), (2, 4), (3, 4), (4, 4)]
    cleaning_room1 = CleaningRoom.CleaningRoom(5, 5, dirty_list)
    cleaning_room1.set_tiles()
    closest_search = AStar.AStarTree((0, 0), cleaning_room1,
                                     heurstic.closest_room_heuristic)
    print("Closest heuristic run:")
    closest_search.run()

    dirty_list = [(0, 4), (1, 4), (2, 4), (3, 4), (4, 4)]
    cleaning_room2 = CleaningRoom.CleaningRoom(5, 5, dirty_list)
    cleaning_room2.set_tiles()
    farthest_search = AStar.AStarTree((0, 0), cleaning_room2,
                                      heurstic.farthest_room_heuristic)
    print("Farthest heuristic run:")
    farthest_search.run()
