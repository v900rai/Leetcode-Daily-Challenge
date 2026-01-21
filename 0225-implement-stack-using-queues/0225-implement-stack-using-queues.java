class MyStack {
    private Queue<Integer> Queue1;
    private Queue<Integer> Queue2;

    public MyStack() {

         Queue1=new LinkedList<>();
         Queue2=new LinkedList<>();
        
    }
    
    public void push(int x) {
        Queue1.add(x);
    }
    
    public int pop() {
        int Size=Queue1.size();
        int k=0;
        while(k<Size-1){
            k++;
            int ele=Queue1.poll();
            Queue2.add(ele);
        }
        int ans=Queue1.poll();
        while(!Queue2.isEmpty()){
            int ele=Queue2.poll();
            Queue1.add(ele);
        }
        return ans;
       

        
    }
    
    public int top() {  
        int size=Queue1.size();
        int k=0;
        while(k<size-1){
            k++;
            int element=Queue1.poll();
            Queue2.add(element);
        }
        int ans=Queue1.poll();
        Queue2.add(ans);
        while(!Queue2.isEmpty()){
            int element=Queue2.poll();
            Queue1.add(element);
        }
        return ans;
        
    }
    
    public boolean empty() {
        int size=Queue1.size();
        if(size==0){
            return true;
        }
        return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */