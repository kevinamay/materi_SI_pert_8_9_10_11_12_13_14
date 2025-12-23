public class stack {
private int stackSize;
private int[] stackArr;
private int top;

    // Constructor to initialize stack
    public stack(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1; // Stack is initially empty
    }
    public void push(int entry) throws Exception {
        if (this.isStackFull()) {
            throw new Exception("Stack is already full. can not add elements");}
        System.out.println("Adding: " + entry);
        this.stackArr[++top] = entry;}
    
    public int pop() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Stack is empty. can not remove elements");}
        int entry = this.stackArr[top--];
        System.out.println("Removed entry: " + entry);
        return entry;}
    
    public int peek(){
        return stackArr[top];}

    public boolean isStackEmpty() {
        return (top == -1);
    }
    public boolean isStackFull() {
        // TODO Auto-generated method stub
        return (top == stackSize - 1);
        }
        public static void main(String[] args) {
            stack stack = new stack(5);
            try {
                stack.push(4);
                stack.push(8);
                stack.push(3);
                stack.push(89);
                stack.pop();
                stack.push(23);
                stack.push(15);
                stack.push(7);
                //stack.push(6); // This will throw exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop(); // This will throw exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
}
}