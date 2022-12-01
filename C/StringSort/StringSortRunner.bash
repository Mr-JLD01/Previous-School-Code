#!/bin/bash

INPUTS="$@"

make
chmod +x StringList

./StringList $INPUTS