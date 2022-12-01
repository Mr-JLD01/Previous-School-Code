#!/bin/bash

INPUTS="$@"

make
chmod +x VehicleOrganizer

./VehicleOrganizer $INPUTS