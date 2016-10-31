package PracticepackDs;

import javafx.scene.chart.StackedAreaChartBuilder;

public class Stack 
{
	static long[] StackArray;
	static int top;
	int maxsize;
	public Stack(int d){
		maxsize = d;
		StackArray = new long[maxsize];
		top = -1;
	}
     public void push(long data)
     {
    	 StackArray[++top] = data;
     }
     public void println(){
    	 for(int i=0;i<=top;i++){
    		 System.out.println(StackArray[i]);
    	 }
     }
     public long pop(){
    	return StackArray[top--];
     }
	
	public static void main(String[] Args){
		Stack obj = new Stack(10);
		  obj.push(40);
		  obj.push(50);
		  obj.push(80);
		  obj.println();
		  System.out.println("somevalue" + StackArray[top]);
	}
}
