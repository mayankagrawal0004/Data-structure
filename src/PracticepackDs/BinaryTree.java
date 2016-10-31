package PracticepackDs;

public class BinaryTree {
static Node root;
static Node pre;
static Node suc;


public void AddBinaryTree(int data){
	Node newnode = new Node(data);
	if(root == null){
		root = newnode;
		return;
	}
	Node tempnode = root;
	addnode(tempnode,newnode);
}
public static void main(String[] Args)

{
	BinaryTree binary = new BinaryTree();
	binary.AddBinaryTree(50);
	binary.AddBinaryTree(30);
	binary.AddBinaryTree(20);
	binary.AddBinaryTree(40);
	binary.AddBinaryTree(70);
	binary.AddBinaryTree(60);
	binary.AddBinaryTree(80);
	//binary.AddBinaryTree(91);
	//binary.traverse();
	/*Node tempnode = binary.findingnode(root,new Node(30));
	if(tempnode != null)
	{
	System.out.println("Found the data");
	}else
	{
		System.out.println("FNot found");
	}*/
	binary.findlca(root,20,40);
	System.out.println("LCA OF l1 and l2" + root.data);
 	binary.predSucc(root,50);
 	System.out.println("key" + pre.data + " " + suc.data);
	//binary.findminimum(root);
	
}
Node findlca(Node roots,int k1,int k2){
	if(roots == null){
		return null;
	}
	if(roots.data > k1 && roots.data > k2){
		return findlca(roots.leftnode,k1,k2);
	}else if(roots.data <k1 && roots.data <k2){

		return findlca(roots.rightnode,k1,k2);
	}
	return roots;
}
Node findminimum(Node roota)
{

if(roota.leftnode == null){
	System.out.println("Found the data" +  roota.data);
return roota;
}
return findminimum(roota.leftnode); 
}
Node find(int numb)
{
	if(root != null){
	return	findingnode(root,new Node(numb));
	}	
return null;
}
void delete(int numb){
	//case1--Node to be deleted doesnot have any child
	Node found = find(numb);
	if(found != null){
		if(found.leftnode == null && found.rightnode == null){
			deletcase1(found);
		}
		else if(found.leftnode != null && found.rightnode != null){
			deletcase3(found);
		}
		else if(found.leftnode != null){
			deletcase2(found);
		}else if(found.rightnode != null){
			deletcase2(found);
		}
		
	}else{
		return;
	}
}
void deletcase3(Node founddelete){
Node min =findmin(founddelete.rightnode);
deletcase2(min);
min.parent = founddelete.parent;
min.leftnode = founddelete.leftnode;
min.rightnode = founddelete.rightnode;
if(founddelete.parent.leftnode == founddelete)
{
	founddelete.parent.leftnode = min;
}else if(founddelete.parent.rightnode == founddelete){
	founddelete.parent.rightnode = min;
}
}
Node findmin(Node minnode){
	if(minnode.leftnode == null)
	{
	 return minnode;
	}
	return findmin(minnode.leftnode);
}
void deletcase2(Node founddelete)
{
	if(founddelete.parent.leftnode == founddelete){
		if(founddelete.leftnode != null){
			founddelete.parent.leftnode = founddelete.leftnode;	
		}else if(founddelete.rightnode!=null){
			founddelete.parent.leftnode = founddelete.rightnode;
		}
		
		
	}else if(founddelete.parent.rightnode == founddelete){
		if(founddelete.leftnode != null){
			founddelete.parent.rightnode = founddelete.leftnode;	
		}else if(founddelete.rightnode!=null){
			founddelete.parent.rightnode = founddelete.rightnode;
		}
		
	}
	
}
void deletcase1(Node founddelete){
	if(founddelete.parent.leftnode == founddelete)
	{
		founddelete.parent.leftnode = null;
	}
	else if(founddelete.parent.rightnode == founddelete)
	{
		founddelete.parent.rightnode = null;
	}
	
}

Node findingnode(Node tempfind,Node node)
{
	if(tempfind == null){
		return null;
	}
	if(tempfind.data == node.data){
		return tempfind;
	}
	else
	{   
    Node returnnode = findingnode(tempfind.leftnode,node);
 
	if(returnnode == null){
	 returnnode = findingnode(tempfind.rightnode, node);
	}
	return returnnode;
}
}
void traverse(){
	if(root == null){
		System.out.println("No node found");
		return;
	}
	inorder(root);
	/*int key = 65;
	inordertraveral(root,key,suc,pre);
	if(suc != null)
	{
		System.out.println("print suc" + suc.data);
	}else{
		System.out.println("nothing");
	}
	if(pre != null)
	{
		System.out.println("print pre" + pre.data);
	}*/
	
}
void predSucc(Node node,int key){
    if(node==null)
        return;
    
    if(node.data==key){
        if(node.leftnode!=null){
            Node temp = node.leftnode;
            while(temp.rightnode!=null)
                temp = temp.rightnode;
            pre = temp;
        }
        
        if(node.rightnode!=null){
            Node temp = node.rightnode;
            while(temp.leftnode!=null)
                temp = temp.leftnode;
            suc = temp;
        }
    }
    
    if(key < node.data){
        suc = node;
        predSucc(node.leftnode,key);
    }
    else if(key > node.data){
        pre = node;
        predSucc(node.rightnode,key);
    }
}
void inordertraveral(Node basicnode,int key,Node suc,Node pre)
{
	if(basicnode == null){
		return;
	}
if(basicnode.data > key){
	suc  = basicnode;
	inordertraveral(basicnode.leftnode, key,suc,pre);
}	

if(basicnode.data < key){
	pre = basicnode;
	inordertraveral(basicnode.rightnode, key,suc,pre);
}
	
}
void inorder(Node root)
{
	 System.out.println(root.data);
   if(root.leftnode != null){
	   inorder(root.leftnode);
   }	
  
   if(root.rightnode !=null){
	   inorder(root.rightnode);
   }
  
}

public void addnode(Node node,Node Newnode){
	if(Newnode.data < node.data) {
	  if(node.leftnode == null)
	  {
		  Newnode.parent = node;
		  node.leftnode = Newnode;
	  }
	  else{
		  addnode(node.leftnode,Newnode);
	  }
		
	}
	else if(Newnode.data > node.data )
	{
		if(node.rightnode == null){
			 Newnode.parent = node;
			node.rightnode = Newnode;
		}else{
			addnode(node.rightnode,Newnode);
		}
		
	}
}
}