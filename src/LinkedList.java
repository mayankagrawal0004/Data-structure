
public class LinkedList
{
static Node head;
static class Node
{
	Node next;
	int data;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		LinkedList.head = new Node(5);
		Node second = new Node(8);
		Node Third = new Node(12);
		LinkedList.head.next = second;
		second.next = Third;
	//	list.enterfirst();
		list.nodeatdata(11, second);
		list.enterdatalast(15);
		list.enterdatalast(18);
		//list.specificposition(3);
		//list.deletefunction(12);
		list.countnode();
		list.linkedlistreversal(head);
		System.out.println("head node" + head.data);
		//list.swapnode(5, 18);
		list.println(head);
	//System.out.println("This recurssive count" + list.getrecirsivenode());
	}
	Node linkedlistreversal(Node nhead)
	{
	/*Node current = nhead;
	System.out.println("i want to see my return" + current.data);
	Node prev = null;
	Node nextnode;
	while(current != null){
		nextnode = current.next;
		current.next = prev;
		current = nextnode;
		prev = current;
	}

	System.out.println("i want to see my return" + prev.data);
	return prev;*/
	  Node prev = null;
      Node current = nhead;
      Node next = null;
      while (current != null) {
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
      System.out.println("i want to see my return" + prev.data);
      while(prev != null){
    	  System.out.println(prev.data);
    	  prev = prev.next;
    	  
      }
      return prev;
	}
	public void countnode(){
		Node n = head;
		int i =0;
		while(n!=null){
			n = n.next;
			i = i+1;			
		}
		System.out.println("Count" + i);
	}
	public void swapnode(int k1,int k2)
	{
		Node temp = head,prev = null;
		int n,d = 0,k = 0;
		// if both are adjacents
	 while(temp != null){
		 prev = temp;		 
		 temp = temp.next;
		 if(prev.data == k1 && temp.data == k2)
		 {
			n = prev.data;			
			 prev.data = temp.data;	
			 temp.data = n;
			// temp.data = swap.data;
		 }
	 }
	 //if k1 or k2 is a head and k1 or k2 is available at last node
	 while(temp != null){
		 if(temp.data == k1 || temp.data == k2)
		 {
			 d = temp.data;
			 System.out.println(d);
		 }
		 temp = temp.next;
		 if(temp.next == null && temp.data == k1 || temp.data == k2){
			 k  = temp.data;
			 System.out.println(k);
		 }
		 if(d != 0 && k != 0){
			 
			 n =d;
			 d = k;
			 k = n;
		 }
	 }
	 	
	}
	public int recirsivenode(Node node){
		if(node == null){return 0;}
		return 1 + recirsivenode(node.next);
		
	}
	public int getrecirsivenode(){
		
		return recirsivenode(head);
	}
	public void specificposition(int pos){
		Node temp = head,previpous = null;
		int i =1;
		while(temp != null){
			if(i == pos)
			{
				break;
			}
			previpous = temp;
			temp = temp.next;
			i = i+1;			
		}
		previpous.next = temp.next;
	}
	public void println(Node nhead){
		Node temp = nhead;
		while(temp != null){
			System.out.println("print this" + temp.data);
			temp = temp.next;
		}
	}
	public void deletefunction(int key){
		Node temp = head,prev = null;
		if(temp != null && temp.data == key){
			System.out.println("i have found the key and now i am going to delet this key");
			head = temp.next;
			return;
		}
		while(temp != null && temp.data != key){
			prev = temp;
			temp = temp.next;
		}
		if(temp == null){
			return;
		}
		prev.next = temp.next;
	}
	public void enterfirst(){
		Node fourth = new Node(6);
		fourth.next = head;
		fourth = head;
		System.out.println(fourth.data);
		
	}
	public void enterdatalast(int datas){
		if(head == null){
			head = new Node(datas);
		}
		Node sixth = new Node(datas);
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
			
		}
		temp.next  = sixth;
		return;
	}
	public void nodeatdata(int data,Node Prev_node){
		if(Prev_node == null){
			System.out.println("The node doesnot exist");
			return;
		}
		Node five = new Node(data);
	    five.next = Prev_node.next ;
	    Prev_node.next = five;	
	}

}
