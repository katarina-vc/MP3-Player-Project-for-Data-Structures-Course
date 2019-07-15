/*
 * Name:		Katarina Capalbo 
 * Student ID:		n01399315
 * Date:		5/28/2019
 * Assignment:		Project 1 COP3530, Data Structures
 * 
 * Description: Originally an arraylist class that supports the mp3 GUI, now has been modified
 *  		to a linked list for this project
 */

// start class List
public class List {

    // variable declarations 
    private ListNode head = new ListNode(); // head of the list
    private ListNode tail= new ListNode(); // tail of the list
    private ListNode current= new ListNode(); // used to traverse list
    private ListNode prevNode= new ListNode(); // referencing the previous node before current node
    private int listSize = 0;
    
    // constructor
    public List() {}
    
    // insertItem() adds a new node to the end of the Linked List
    public  void insertItem(String name)
    {
    	// create new node
    	ListNode newNode = new ListNode(name);
    	
    	if(size() == 0) // if empty list, add in first node
    	{
    		head = newNode;
    		tail = head;
    		tail.next = null;
    	}
    	else // if list is not empty, create new node and add to end
    	{
    		newNode.next = null;
    		tail.next = newNode;
    	}
    	
    	tail = newNode;
    	listSize++;
    } // end insertItem(String name)
    
    // insertItem() adds a new node at a specified position of the Linked List
    public  void insertItem(String name, int pos)
    {
    	// create new node
    	ListNode newNode = new ListNode(name);
    	
    	// add node to the front of the list (pos == 0 references front of list)
    	if(pos == 0) 
    	{
    		newNode.next = head;
    		head = newNode;
    	}
    	else // add node somewhere else in the list
    	{
    		current = head;
    		prevNode = head;
    		for(int i = 0; i < pos; i++)
    		{
    			prevNode = current;
    			current = current.next;    	
    		}
    		
    		newNode.next = current;
    		current = newNode;
    		prevNode.next = newNode;
    	}	

		listSize++;
    } // end insertItem(String name, int pos)
   
    // size() returns the size of the LinkedList
    public int size()
    {
    	return listSize;
    } // end size()

    // removeItem() removes a node based on the name of the string it holds
    public boolean removeItem(String aname)
    {
    	boolean foundNameFlag = false;
    	prevNode = head;
    	current = head;
    	
        	for(int i = 0; i < listSize; i++)// traverse the list
        	{
        		if(current.songName.equals(aname)) // found song
        		{
        			foundNameFlag = true; 
        			
        			if(current == head) 
        			{
        				head = head.next; // remove node
        				break;
        			}
        			else
        			{	
        				prevNode.next =  current.next; // remove node
        				break;
        			}
        		}
        		
        		// increment prevNode and current to continue traversing the list
        		prevNode = current;
        		current = current.next;
        	}
    	
    	
    	listSize--;
    	
    	return foundNameFlag;
    } // end removeItem(String aname)

    // removeItem() removes a node based on its position in the linked list
    public void removeItem(int position)
    {
    	current = head;
        prevNode = head;
    	
    	if(position >= size())
    	{
    		System.out.println("Out of bounds position");
    	}
    	else if(size() == 0)
    	{
    		System.out.println("List is empty, cannot remove node");
    	}
    	else
    	{
    		for(int i = 0; i < position; i++) // traverse list until reached position
    		{
    			prevNode = current;
    			current = current.next;
    		}
    		
    		prevNode.next = current.next; // remove node from position
    		listSize--;
    	}
    } // end removeItem(int pos)

    // contains() returns true if the linked list contains the string
    public boolean contains(String name) 
    {
    	current = head;
    	
    	for(int i = 0; i < size(); i++)
    	{
    		if(current.songName.equals(name))
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }// end contains()

    // clear() removes all of the elements from the linked list
    public void clear()
    {    	
    	head = null;
    	tail = null;
    	listSize = 0;
    }// end clear
    
    // get() return the element at the specified position in the list.
    public String get(int index)
    {
    	current = head;
    	
    	for(int i = 0; i < index; i++)
    	{
    		current = current.next;
    	}
    	
    	return current.songName;
    }// end get(int index)

    // toString() Override the toStringmethodto printout the names of all the songs in the list
    public String toString()
    {
    	current = head;
    	String temp = "";
    	for(int i = 0; i < listSize; i++)
    	{
    		temp = temp + current.songName + "\n";
    		current = current.next;
    	}

    	return temp;
    }// end toString()
    
    /*
     * Return a String that starts with < html > ends with < /html >
     * and uses the line breaks, < br/ >, 
     * in replacement of new line characters and prints out all the names of all the songs in the list. 
     */
    public String toHTMLString()
    {
    	current = head;
    	String temp = "<html>PlayList<br/>";
    	for(int i = 0; i < listSize; i++)
    	{
    		temp = temp + current.songName + "<br/>";
    		current = current.next;
    	}
    	temp = temp+"</html>";
    	return temp;
    }// end toHTMLString()
}// end class List

// A class to create nodes for the List class
class ListNode {
	
	public ListNode next;
	public String songName;

	// constructor with no parameters, songName should be an empty string 
	public ListNode()
	{
		this.songName = "";
	}// end constructor ListNode()
	
	// constructor with 1 parameter, set the name of the song file
	public ListNode(String name)
	{
		this.songName = name;
	}// end constructor ListNode(String name)
	
	/*  constructor with 2 parameters, name of the song and
	 *  the next node in the list
	 */
	public ListNode(String name, ListNode nxt)
	{
		this.songName = name;
		this.next = nxt;
	}// end constructor ListNode(String name, ListNode nxt)
}// end class ListNode
