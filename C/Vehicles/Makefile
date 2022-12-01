VehicleOrganizer: Vehicles.o FileUtility.o VehicleStruct.o
	gcc Vehicles.o FileUtility.o VehicleStruct.o -o VehicleOrganizer
Vehicles.o: Vehicles.c FileUtility.h VehicleStruct.h
	gcc -c Vehicles.c FileUtility.h
FileUtility.o: FileUtility.c FileUtility.h
	gcc -c FileUtility.c FileUtility.h
VehicleStruct.o: VehicleStruct.c VehicleStruct.h
	gcc -c VehicleStruct.c VehicleStruct.h
clean:
	rm *.o *.gch VehicleOrganizer