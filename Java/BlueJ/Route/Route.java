import java.io.*;
import java.util.*;
/* John Luke Denny
 * Route uses airports names and a daily flight log to calculate the path with the earliest arrival time at the final destination
 */
public class Route{

    public static Vertex[] hasharray = new Vertex[1000];
    public static Vertex[] heaparray= new Vertex[1000];
    public static int heapSize = 0;
    
    public static void main(String[] args)throws FileNotFoundException{
        String start = args[0];
        String end = args[1];
        File flights = new File("flights.txt");
        File airports = new File("airports.txt");
        Scanner flight = new Scanner(flights);
        Scanner airport = new Scanner(airports);
        
        //System.out.println("=========================================");
        
        int command = airport.nextInt();
        airport.nextLine();
        //adds all the airports
        for(int i = command; i > 0; i --){
            String code = airport.nextLine();
            Vertex a = new Vertex(code);
            addVertexHash(a);
            addVertexHeap(a);
            hasharray[getVertex(a.airport_code)].heap_pos = a.heap_pos;
            //System.out.printf("%s, hash: %d, heap: %d\n",code, a.hash_pos, a.heap_pos);
        }
        
        command = flight.nextInt();
        flight.nextLine();
        
        flight.nextLine();
        //adds all flights to their origin airports
        for(int i = command; i > 0; i --){
            String airln = flight.next();
            int fltno = flight.nextInt();
            String origin = flight.next();
            String dest = flight.next();
            int dep = flight.nextInt();
            int arr = flight.nextInt();
            flight.nextLine();
            Edge flt = new Edge(origin, dest, airln, fltno, dep, arr);
            //System.out.printf("Flight no: %d, airln: %s, Origin: %s, Dest: %s, Dep: %d, Arr: %d\n", fltno, airln, origin, dest, dep, arr);
            
            int hash = getVertex(origin);
            hasharray[hash].setEdge(flt);
            
        }
        //creates the itinerary with the earliest arrival time
        shortestPath(start);
        int hash = getVertex(end);
        int arrival = hasharray[hash].shortest.arrtime;
        String itinerary = end + "-";
        while(hasharray[hash].parent != null){
            Edge e = hasharray[hash].shortest;
            //System.out.printf("Origin: %s, Dest: %s, Dep: %d, Arr: %d\n", e.origin, e.dest, e.deptime, e.arrtime);
            itinerary = hasharray[hash].parent + "-" + itinerary;
            hash = getVertex(hasharray[hash].parent);
        }
        itinerary += "" + arrival;
        System.out.println(itinerary);
    }
    
    //hash function for the airport codes
    public static int myhash (String hash){
        int p0 = (int)(hash.charAt(0)) - 64;
        int p1 = (int)(hash.charAt(1)) - 64;
        int p2 = (int)(hash.charAt(2)) - 64;
        int p3 = p0*467*467 + p1*467 + p2 ;
        int p4 = p3 % 7193;
        return p4 % 1000;
    }
    
    //adds an airport to the hash
    public static void addVertexHash(Vertex v){
        String code = v.airport_code;
        int hash = myhash(code);
        
        while(hasharray[hash] != null){
            hash++;
            if(hash >= 1000)
                hash = hash % 1000;
        }
        hasharray[hash] = v;
        v.hash_pos = hash;
    }
    
    //adds and airport to the heap
    public static void addVertexHeap(Vertex v){
        heaparray[heapSize] = v;
        v.heap_pos = heapSize;
        heapSize++;
        heapify(heaparray, heapSize);
    }
    
    //organizes the heap based on an airport's dvalue
    public static void heapify(Vertex[] arr, int hSize){
        if(hSize > 1){
            int c = hSize - 1; //final child node
            Vertex sub;
            while(c > 0){
                if(arr[c].dvalue < arr[(c - 1)/3].dvalue){
                    sub = arr[c];
                    arr[c] = arr[(c - 1)/3];
                    arr[(c - 1)/3] = sub;
                    arr[c].heap_pos = c;
                    arr[(c - 1)/3].heap_pos = (c - 1)/3;
                }
                c--;
            }
        }
    }
    
    //extracts the airport with the lowest dvalue
    public static Vertex extractMin(){
        Vertex min = heaparray[0];
        min.heap_pos = -1;
        for(int i = 1; i <= heapSize; i++){
            heaparray[i-1] = heaparray[i];
            if(heaparray[i-1] != null){
                heaparray[i-1].heap_pos--;
                
            }
        }
        heapSize--;
        heapify(heaparray, heapSize);
        return min;
    }
    
    //calulates the path with the earliest arrival time(dvalue = earliest arrival)
    public static void shortestPath(String s){
        int hash = getVertex(s); //s is the starting airport
        hasharray[hash].dvalue = 0;//so your base arrival is 0
        int heapPos = hasharray[hash].heap_pos;
        heaparray[heapPos].dvalue = 0;
        heapify(heaparray, heapSize);
        while(heapSize > 0){
            Vertex node = extractMin();
            
            //System.out.printf("%s, hash: %d, heap: %d\n",node.airport_code, node.hash_pos, node.heap_pos);
            Edge list = node.adj_list;
            while(list != null){
                //System.out.printf("Flight no: %d, airln: %s, Origin: %s, Dest: %s, Dep: %d, Arr: %d\n", list.fltno, list.airline, list.origin, list.dest, list.deptime, list.arrtime);
                String parent = list.origin;
                hash = getVertex(parent);
                String dest = list.dest;
                int hashDest = getVertex(dest);
                if(hasharray[hashDest].shortest == null || hasharray[hashDest].dvalue > list.arrtime){
                    if(hasharray[hash].dvalue < list.deptime){
                           
                        heapPos = hasharray[hashDest].heap_pos;
                        
                        if(heapPos >= 0){
                            hasharray[hashDest].shortest = list;
                            hasharray[hashDest].dvalue = list.arrtime;
                            hasharray[hashDest].parent = parent;
                            heaparray[hasharray[hashDest].heap_pos].shortest = list;
                            heaparray[hasharray[hashDest].heap_pos].dvalue = hasharray[hashDest].dvalue;
                            heaparray[hasharray[hashDest].heap_pos].parent = parent;
                        }
                    }
                }
                list = list.next;
            }
            heapify(heaparray, heapSize);
        }
    }
    
    //returns the hash position of an airport
    public static int getVertex(String code){
        int p = myhash(code);
        
        if (hasharray[p] == null){
            return -1;
        }
        if (hasharray[p].airport_code.equals(code)){ 
            return p;
        }
        for (int i = p + 1; i != p; i++){
            if (i >=1000)
                i = i %1000; // rolling over
            if (hasharray[i].airport_code.equals(code) ) {
                return i;
            }
            if ( hasharray[i] == null){
                return -1;
            }
        }
        return -1;
    }

}

//Airport object, called vertex as it relates to a graph
class Vertex{
    public String airport_code;
    public int heap_pos;
    public int hash_pos;
    public Edge adj_list;
    public Edge shortest;
    public int dvalue;
    public String parent;
    
    public Vertex(String code){
        airport_code = code;
        dvalue = Integer.MAX_VALUE;
    }
    public void setEdge(Edge first){
        if(adj_list == null)
            adj_list = first;
        else
            addEdge(adj_list, first);
    }
    public void addEdge(Edge list, Edge next){
        if(list.next == null)
            list.next = next;
        else
            addEdge(list.next, next);
    }
    public void updateDVal(int newVal){
        dvalue = newVal;
    }
}

//Flights, called edge as it relates to a graph
class Edge{
    public String origin;
    public String dest;
    public String airline;
    public int fltno ;
    public int deptime ;
    public int arrtime ;
    public Edge next ; // to be used in adjacency list
    
    public Edge(String o, String d, String air, int flight, int departure, int arrival){
        origin = o;
        dest = d;
        airline = air;
        fltno = flight;
        deptime = departure;
        arrtime = arrival;
    }
    
}
