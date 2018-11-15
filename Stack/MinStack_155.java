/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.*/
public class MinStack_155 {
    //利用辅助stack 来存储每一个状态下的stack的最小值
//唯一不一样的地方在 push
//空的情况要判断 因为min一开始是没有值的 你必须赋值给他 才能进行接下来的操作
//当 pop之后 下一次push要进行 min的更新
    class MinStack {
        Stack <Integer> stack;
        Stack <Integer> assist;
        int min;
        /** initialize your data structure here. */
        public MinStack() {
            stack= new Stack<>();
            assist = new Stack<>();
        }
        public void push(int x) {
            if(stack.isEmpty()){
                min = x;
                stack.push(x);
                assist.push(min);
                return;
            }
            stack.push(x);
            if (x<assist.peek()) { //不能用 x<min 因为pop后 虽然 assist改变了 但是min的值是没有变的
                min = x;
                assist.push(min);
                return;
            }
            min = assist.peek();//如果新加入的比peek大 更新min为peek 然后加入辅助stack
            assist.push(min);
        }

        public void pop() {
            stack.pop();
            assist.pop();
            //min = assist.peek();//不能在这里更新min 因为 当pop之后 两个都为空的情况下 peep为 null
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return assist.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
