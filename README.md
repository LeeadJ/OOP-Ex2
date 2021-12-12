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


