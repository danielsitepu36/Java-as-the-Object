Class Stacks {
    private int[] mystack;
    private int length,itr;

    public Stacts(int length){
        this.length = length;
        mystack = new int[length];
    }

    public void push (int in){
        mystack[itr++]=in;
    }

    public int pop(){
        return mystack[--itr];
    }
}