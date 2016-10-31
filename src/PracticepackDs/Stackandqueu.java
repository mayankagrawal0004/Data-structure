package PracticepackDs;

public class Stackandqueu {
    static stacknode First;
	public static void main(String[] Args){
		Stackandqueu stack = new Stackandqueu();
   stack.push('m');		
   stack.push('a');
   stack.push('y');
   stack.push('a');
   stack.push('n');
   stack.push('k');
   stack.printstack();
   stack.pop();
   //stack.reverse();
	}
	public void pop(){
		System.out.println("----------------");
		while(First.next != null){
			System.out.print(First.data);
			stacknode tempnode;
			tempnode = First.next;
			First = tempnode;
		}
	}
	public void printstack(){
		stacknode tempstack = First;
		while(tempstack != null)
		{
			System.out.print(tempstack.data);
			tempstack = tempstack.next;
		}
	}
	public void push(char data)
	{
	stacknode newstack = new stacknode(data);
	 newstack.next = First;
	 First = newstack;
	 System.out.print(First.data);
	}
	public void reverse(){
		stacknode temp = null;
		while(First.next!= null){
		First = First.next;
		temp = First;		
		}
		System.out.println("print this" + temp.data);
	}
	
}
