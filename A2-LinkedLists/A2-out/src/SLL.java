package src;

/**
 * Class to implement a singly linked list
 *
 * @author Claire Newcom
 * @version Spring 2026
 *
 */
public class SLL<T> implements ListADT<T>,NodeBasedOps<T> {

    /**
     * A pointer to the first element in the list
     */
    private NodeSL<T> head;

    /**
     * The size of the list
     */
    private int size;

    /**
     * Constructs an empty singly linked list
     */
    public SLL(){
        this.head = null;
        this.size = 0;
    }

    //STILL A STUB UPDATE THIS LATER
    public SLL(SLL<T> toCopy){

        for(int i = toCopy.size()-1; i >=0; i--){
            T value = toCopy.get(i);
            this.addFirst(value); //this updates the head and size
        }

    }

    //ListADT
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public T get(int index) {
        if (index>=0 && index < this.size()) {
            return this.nodeAt(index).getData();
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    //might need to be changed
    @Override
    public T set(int index, T value) {

        NodeSL<T> data = null;


        if (index>=0 && index < this.size()) {
            data = this.nodeAt(index); //shallow copy, 2 nodes that point to the same data, so if data changes
            // something, the index should change as well.
            T previousValue = data.getData();
            data.setData(value);

            return previousValue;
        } else {
            throw new IndexOutOfBoundsException();
        }


    }


    @Override
    public void add(int index, T value) {

        if (index>=0 && index <= this.size()) {
            if(index == 0 ){ //this adds at the beginning, just changes the head
                this.head = new NodeSL<>(value, this.head);
                size++;
                return;
            }

            NodeSL<T> prevData = this.nodeAt(index-1);

            NodeSL<T> newValue = new NodeSL<>(value, prevData.getNext()); //assigns next of newValue to the item
                                                                          // at the index
            prevData.setNext(newValue);//reassigns the pointer of the prev data to the new value
            size++; //updates size

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T remove(int index) {

        NodeSL<T>  prevData = null;
        if (index>=0 && index < this.size()) {

            if(index == 0){
                prevData = this.head;
                T value = prevData.getData();
                this.head = prevData.getNext();
                size--;
                return value;
            }

            prevData = this.nodeAt(index-1);
            T value = prevData.getNext().getData();
            this.nodeAt(index-1).setNext(prevData.getNext().getNext());
            size--; //updates size
            return value;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString(){

        String insideOfArray = "";
        int index = 0;

        for (NodeSL<T> item = this.head; index<this.size; index++) {
            if(index==0){
                insideOfArray = item.getData().toString();
            } else {
                insideOfArray = insideOfArray.concat(", " + item.getData().toString());
            }
            item = item.getNext();
        }

        return "[" + insideOfArray + "]";

        //

        //for (Node item = this.head; item.next != null; item = item.next) { // item is a node in the list }
    }

            //Helpers for ListADT

    /**
     * Traverses the list and gets the node at the given index
     * @param index a valid index of the desired node
     * @return the node at the given index
     */
    private NodeSL<T> nodeAt(int index){
        NodeSL<T> node = this.head;
        int currentIndex = 0;

        while(currentIndex<index){
            node = node.getNext();
            currentIndex++;
        }

        return node;
    }

    //NodeBasedOps
    @Override
    public NodeSL<T> getHead() {
        return this.head;
    }

    @Override
    public NodeSL<T> getTail() {
        return this.nodeAt(size-1);
    }

    @Override
    public void addFirst(T v) {
        this.add(0,v);
    }

    @Override
    public void addLast(T v) {
        this.add(size, v);
    }

    @Override
    public T removeFirst() {
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        T value = this.remove(0);
        return value;
    }

    @Override
    public T removeLast() {
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        T value = this.remove(size-1);
        return value;
    }

    /**
     *  Inserts the given item after the specified node.
     *  If here is null, insert at the head.
     *  @param here node to insert after
     *  @param v item to insert
     */
    @Override
    public void addAfter(NodeSL<T> here, T v) {
        if(here == null){
            NodeSL<T> newHead = new NodeSL<>(v,this.head);
            this.head = newHead;
        } else {
            NodeSL<T> next = here.getNext();
            NodeSL<T> newNode = new NodeSL<>(v, next);
            here.setNext(newNode);
        }
        size++;
    }

    /**
     *  Removes the node after the given position.
     *  If here is null, remove the head node.
     *  @param here marks position to remove after
     *  @return item removed
     */
    @Override
    public T removeAfter(NodeSL<T> here) {
        if(this.isEmpty()){
            throw new IllegalStateException();
        }
        T value;
        if (here == null){
            value = this.head.getData();
            this.head = this.head.getNext();
        } else {
            value = here.getNext().getData();
            here.setNext(here.getNext().getNext());
        }
        size--;
        return value;
    }

}


