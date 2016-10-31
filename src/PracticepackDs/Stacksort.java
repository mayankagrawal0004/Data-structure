package PracticepackDs;
public class Stacksort {
    int top;
	int[] stackarray;
	int maxsize;
public Stacksort(int d){
	maxsize = d;
	stackarray = new int[maxsize];
	top = -1;
}	
public boolean isEmpty(){
		return top == -1;
}
		static void sort(Stacksort stack)
		{
			if (!stack.isEmpty()) {
				int top = stack.pop();
				System.out.println("removed element" + top);
				sort(stack);
				putSorted(stack, top);
			}
		}

		private static void putSorted(Stacksort stack, int item) {
			if (stack.isEmpty() || stack.peek() < item) {
				stack.push(item);
			} else {
				int top = stack.pop();
				putSorted(stack, item);
				stack.push(top);
			}
		}
		public int peek() {
			// TODO Auto-generated method stub
			return stackarray[top];
		}
		public void push(int data){
			stackarray[++top] = data;
			
		}
		public int pop(){
			return stackarray[top--];
		}
		public static void main(String[] args) {
			Stacksort stack = new Stacksort(10);
			stack.push(-3);
			stack.push(19);
			stack.push(18);
			stack.push(-5);
			stack.push(30);
			
			//System.out.println(Array.toString(stack.toArray()));
			sort(stack);
			while(!stack.isEmpty()){
				int value = stack.pop();
				System.out.println("print " + value);
			}
			//System.out.println(Array.toString(stack.toArray()));
		}
	}


