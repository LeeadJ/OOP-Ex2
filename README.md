# OOP - EX2: Making a Directed Graph
<br /> 

![rewxsx85fqmolo6r49p9](https://user-images.githubusercontent.com/68643157/145452228-7a1b05ce-b307-4bb5-b32e-802a72db0762.jpg)
  <br />
  
  ### In this assingment, we were challenged to create a directed weighted graph OOP and to visulise it in GUI. 
  
  # Input Files <br />
  To make the programme run, download the Jar file. In the cmd write as follow: java -jar <jarfile> and enter a jsonfile.

- The  graph interface shows the first graph that is given by the user with the json file. The graph is made of vertecies and edges.
- Behind the scenes the vertecies are nodes and the edges are edges.

## The main idea of the code <br />

Our Nodes are just normal nodes that we implement from the interface. Our data structure is based on hashmap with integers and nodes, 
and for the Edges, we use hashmap of integer that represent that Node id and another hashmap of integer of the Edged and Edges. 
To be more clear the first hasmap is interger 1 will give us value of node 1, but in the edge hashmap, int 1 will give up a hashmap of 
all the edged that are connected to Node 1 and so on. 

## classes <br />
1. **Point3d** - this class implements the Geolocation interface and it incharge of the points on the graph for each node .
   <br /><br />
2. **Gnode** - this class implements NodeData and stores the information for each verticy:
   - it includes id.
   - MyGeoLocation information.               
      <br />
3. **Edge** -this class implemets the EdgeData interface and is incharge of the edge.<br /><br />
4. **DWG** -AKA "Directed weighted graph" this class implements the Directed weighted graph interface
            and is build of two different hashmaps, one for nodes and one is a hashmap of hashmaps, for edges.<br /><br />
5. **DWGalgo** - aka Directed weighted grap algo. This class implements the algo interface, that is where all the algorithms for the graph are.
- Is the graph connected.
- Shortest path between 2 vertacies.
- The ideal center of the graph.
- Travelling salesman problem for a group of vertacies in the graph
  <br />
  ## Gui <br />
This is the Graphic User Interface, which will show the graph that we have created and enable the user to load save and run algorithms etc<br />
This is Graph 2 for example: 
<img width="960" alt="G2" src="https://user-images.githubusercontent.com/68643157/145458331-7b45cf49-d0cd-4bb6-90c2-576a6431f71b.png">
  
## Algorithms<br />

- **IsConnected** - This algorithm will check if all the vertacies are connected.<br />
  We implemented this by usign DFS, and checking if all the nodes were visited.    

- **ShortPathDis** - This algorithm finds the shortest path between two Nodes.
  We used the Floyd Warshall algorithm. <br /><br />
  
- **ShortPath** - This algorithm returns the shortest path as a journey between two nodes. <br /><br />
  
- **Center** - Find the Node that is the most center in the graph.<br />
  We use the Floyd Warshall algorithm and find the minimum distance for each Node. <br /><br />

- **Tsp** - Travelling Salesman Problem. 
  Given a list of Nodes, find the shortest way to visit all Nodes at least once. 
  In the tsp we first initialized a matrix. 
  Each index in the matrix represented the weight between two nodes.
  We than ran the 'floyd warshall' algorithem, minimizing each index to the shortrst path between the two nodes.
  We then initialized a boolean array, where each index represents a node key from the givin graph.
  The index in the boolean array is true if the node was visited and false if not.
  Since the rout is cyclic there is no importance to the starting point.
  We used the tsp_helper function. It recursivly computes the tsp for each node.
  The helper returns the lowest path by weight.

## Editing the Graph: 
  ** Nodes **
  
  ![node action menu ](https://user-images.githubusercontent.com/68643157/145788155-79d8d5d9-5c33-4059-98d1-dcfcb505ebbe.png)
  
  Add Node: 
  
  ![add node ](https://user-images.githubusercontent.com/68643157/145788202-46be1567-0a70-4472-a51c-a97059720f54.png)
  
  Remove Node: 
  
  ![remove node ](https://user-images.githubusercontent.com/68643157/145788245-d2a1296d-edcb-459a-a1c7-01ad67ab2354.png)
  <br />
  
  ** Edges ** 
  
  ![edge action menu](https://user-images.githubusercontent.com/68643157/145788305-fd90a7f8-fdd9-430c-9f99-da171c10e883.png)
  
  Add Edge: 
  
  ![add edge](https://user-images.githubusercontent.com/68643157/145788353-fb26e6d4-8b4d-4710-a900-92d263adedaa.png)

  Remove Edge: 
  
  ![remove edge](https://user-images.githubusercontent.com/68643157/145788381-64cedf8f-3db2-4dbe-b5e2-1fb596a6b5c4.png)
  <br />

      

## Algorithms Results<br />
  
 ![results](https://user-images.githubusercontent.com/68643157/145788456-ddfad22f-eace-4386-88bb-50fac57baab8.png)
<br />

## Running the programme <br />

1. Download The project [github repo](https://github.com/Arieh-code/OOP-Ex2.git) . <br />
2. Make sure you have the jar file [Jar file](https://github.com/Arieh-code/OOP-Ex2). <br />  
3. Run terminal through the directory <br />
4. Write this line in the CMD: <br />
> java -jar OOP-Ex2.jar <file_name>.json

![cmd](https://user-images.githubusercontent.com/68643157/145788844-b47eff6a-f2c2-4f59-b2b5-1c91b3d71247.png)<br />
 
The graphs that you can play with are here: [github repo](https://github.com/Arieh-code/OOP-Ex2.git)

