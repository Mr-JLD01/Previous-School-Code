StringList: StringSort.o StringArrayHelp.o
	gcc StringSort.o StringArrayHelp.o -o StringList
StringSort.o: StringSort.c StringArrayHelp.h
	gcc -c StringSort.c StringArrayHelp.h
StringArrayHelp.o: StringArrayHelp.c StringArrayHelp.h
	gcc -c StringArrayHelp.c StringArrayHelp.h
clean:
	rm *.o *.gch StringList