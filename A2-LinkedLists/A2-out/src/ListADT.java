package src;

/**
 * Interface to describe the behavior of a List
 * Author: Claire Newcom cnewcom@smith.edu
 *
 * assume there is a constructor that creates an empty list (just a simple instance of the ListADT class)
 * [not sure how this would work but also maybe have a constructor that can take in a collection or another list
 *      and populate a list from that collection/other list]
 *
 * General assumptions about lists:
 * -Items in the List don't randomly appear or disappear
 * -Items in the List don't randomly move around (there is an order and it matters)
 * -Information about each of the elements can be accessed
 */
public interface ListADT<T> {

    //Required Methods

    /**
     * Returns the total number of elements in this list
     * @return the total number of elements in this list
     */
    public int size();


    /**
     * Checks whether or not this list is empty
     * @return true if this list is empty, false if there are elements in this list.
     */
    public boolean isEmpty();


    /**
     * Gets the item at the specified index.
     * @throws IndexOutOfBoundsException if the index is not greater than or equal to 0 or less than size()
     * @param index the index of the desired item
     * @return the item at the given index
     */
    public T get(int index);


    /**
     * Sets the value at this index to the new value.
     * @throws IndexOutOfBoundsException if the index is not greater than or equal to 0 or less than size()
     * @param index the index of the value to be set
     * @param value the new value to be set at the specified index
     * @return returns the previous value at the given index
     */
    public T set(int index, T value);



    /**
     * Adds a new item to the list at the specified index. Index of list starts
     * at 0. Pushes items on and after that index to the right. For example,
     * take the list 0,1,2. If we wanted to add an item called 3 to the list at index
     * 1, the new list would be 0,3,1,2.
     * @throws IndexOutOfBoundsException if the index is not greater than or equal to 0 or less or equal to than size()
     * @param index the index the item will be inserted at.
     * @param value the new value to be added at the index
     */
    public void add(int index, T value);


    /**
     * Removes the item at the specified index from the list and shifts elements to left.
     * @throws IndexOutOfBoundsException if the index is not greater than or equal to 0 or less than size()
     * @param index the index of the item to remove
     * @return the item that was removed from the list.
     */
    public T remove(int index);






}

