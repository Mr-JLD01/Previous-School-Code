#!/usr/bin/env python

import sys
import re

# Hadoop mapper to output first letter and word length
for line in sys.stdin:
	try:
		line.strip()
		words = re.split("[^0-9a-zA-Z]", line)

		for word in words:
			if len(word) > 0:
				print("{0}\t{1}".format(word[0:1], len(word)))
	except Exception as e:
		pass
