#!/usr/bin/env python

from operator import itemgetter
import sys

current_letter = None
current_count = 0
first_letter = None
sum = 0

# Hadoop reducer to output first letter and average word length
for line in sys.stdin:
    line.strip()
    first_letter, word_length = line.split("\t")

    try:
        word_length = float(word_length)
    except ValueError:
        continue

# this IF-switch only works because Hadoop sorts map output
# by key (here: word) before it is passed to the reducer
    if current_letter == first_letter:
        sum = sum + word_length
        current_count = current_count + 1
    else:
        if current_letter:
            print("{0}\t{1}".format(current_letter, sum/current_count))
        current_count = 1
        current_letter = first_letter
        sum = word_length

# print final letter
if current_letter == first_letter:
    print("{0}\t{1}".format(current_letter, sum/current_count))
