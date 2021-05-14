"""
Basic rock paper scissors game. One with random computer and
one that bases choice off of previous wins/loses
"""

import random


def rock_paper_scissors():
    """
    rock paper scissors with a random computer
    """
    while True:
        # player inputted play
        play = input("Make your play!\n" +
                     "R for rock\n" +
                     "P for Paper\n" +
                     "S for Scissors\n")
        # possible plays for player and computer
        plays = ["R", "P", "S"]
        try:
            assert play in plays
            opp = random.choice(plays)
            if opp == play:
                print("Tie!\n")
            elif (opp == "S" and play == "R") or (opp == "R" and play == "P")\
                    or (opp == "P" and play == "S"):
                print("You win!", play, "beats", opp)
            else:
                print("You lose!", opp, "beats", play)
        except AssertionError:
            print("Illegal input!")

        choice = input("Type 'exit' if you want to quit")
        if choice == "exit":
            break


def rock_paper_scissors_strategy():
    """
    rock paper scissors with a computer basing choices on previous record
    """
    record = {"R": 0, "P": 0, "S": 0}

    while True:
        # player inputted play
        play = input("Make your play!\n" +
                     "R for rock\n" +
                     "P for Paper\n" +
                     "S for Scissors\n")
        # possible plays for player and computer
        plays = ["R", "P", "S"]
        try:
            assert play in plays
            maximum = max(record.values())
            # chooses play based on what would win the previous game
            strat = [key for key in record if record[key] == maximum]
            opp = random.choice(strat)
            if opp == play:
                print("Tie!\n")
            elif (opp == "S" and play == "R") or (opp == "R" and play == "P")\
                    or (opp == "P" and play == "S"):
                print("You win!", play, "beats", opp)
                record[(set(plays)-{opp, play}).pop()] += 1
            else:
                print("You lose!", opp, "beats", play)
                record[opp] += 1
        except AssertionError:
            print("Illegal input!")

        choice = input("Type 'exit' if you want to quit")
        if choice == "exit":
            break


def main():
    rock_paper_scissors()
    rock_paper_scissors_strategy()


if __name__ == "__main__":
    main()
