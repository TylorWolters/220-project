import java.util.ArrayList; //n-ary trees require an expandable array of children.
	
public class TreeNode extends Item{
Item itemData; //A data structure that holds the items data (name, cost, serial #. warranty information, date added and etc.)
ArrayList<TreeNode> leaves; //The array list that holds the TreeNode's leaves.
String referenceName; // The name used to easily find a certain TreeNode.
//--------------------------------------------------------------------------------------------------------------------------------------------

int runCount=0;
TreeNode rootOfTree;
TreeNode foundNode = null;
public void removeLeaf(TreeNode node, String givenReferenceName){//remove a given leaf, given the root of the tree and the leaf's reference name.
if(runCount==0){// Tree traversed twice, and is called recursively. On the first pass save the root so we can use it again.
	rootOfTree = node;
	++runCount;
	}
	if (node != null)//expertly dodge null pointer exception
		{
		if (node.referenceName == givenReferenceName)//if we found it
			{
			foundNode = node; //record it as such
			if(rootOfTree.leaves.contains(foundNode))//used to delete if the leaf being removed is a category
				rootOfTree.leaves.remove(foundNode);
				
			for(TreeNode leaves : rootOfTree.getLeaves())//take leaves of the node being removed, delete those as well.
				{
					ripper(leaves);
				}
				
			}
for(TreeNode leaves : node.getLeaves())//check all the leaves of the root, and their leaves accordingly.
	{
	removeLeaf(leaves, givenReferenceName);
	}
		}
}
public void ripper(TreeNode startNode){//destroys 3rd/4th tier sub leafs, if they exist.
if(startNode.leaves.contains(foundNode))
	startNode.leaves.remove(foundNode);
for(TreeNode leaves : startNode.getLeaves()) 
	{
    ripper(leaves);
	}
}
public void add(TreeNode root, String refParent, String refNewNode){//add a leaf to a given parent node.
if (root != null)
	{
	if (root.referenceName == refParent) 
		root.addLeaf(refNewNode);
	for(TreeNode leaves : root.getLeaves())
		{
		add(leaves, refParent, refNewNode);
		}
	}
}

public TreeNode(String referenceName){ //Constructor
this.referenceName = referenceName; //Must have a name for easy reference.
leaves = new ArrayList<TreeNode>(); //Needs to hold leaves.
}

public void addLeaf(String referenceName) {//add a new leaf to a self referenced node.
TreeNode addedNode = new TreeNode(referenceName); //create a new Node that has the given reference name
leaves.add(addedNode); //add it to the leaves ArrayList of the currentNode.
}

TreeNode fNode=null;
public TreeNode getLeaf(TreeNode root, String referenceName){//traverse tree to find certain node
if (root != null)
{
	if (root.referenceName == referenceName) 
		{
		fNode = root;
		return fNode;
		}
	if (root!=null) 
		{
		for(TreeNode leaves : root.getLeaves())
			{
			getLeaf(leaves, referenceName);
			}
		}
	
}
return fNode;
}


public void setReferenceName(String referenceName){//reference name setter
	this.referenceName = referenceName;
	}




public TreeNode getLeaf(int location) {//see a certain leaf
if (location>leaves.size())//can't return a leaf outside of array
	return null;
else
	return leaves.get(location);
}
public void traverse(TreeNode node, int level){//go through and print the reference name of every entry
switch(level){
	case 0: System.out.print("*HOUSENAME:*" );
		break;
	case 1: System.out.print("*CATEGORY:* ");
			System.out.println(node.referenceName);
			System.out.print(node.getLeaves());
		break;
	case 2:
		break;
	case 3: System.out.print("*INFORMATION:* ");
		break;
	default: System.out.print("*ERROR:* ");
		break;
	}
    if (node != null) {
	for(TreeNode leaves : node.getLeaves()) {
        traverse(leaves, 1+level);
    }
    }
}
public ArrayList<TreeNode> getLeaves(){//see all leaves
	return new ArrayList<>(leaves);//returns an ArrayList that holds all of TreeNodes leaves.
}



}