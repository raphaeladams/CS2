public class LinkedList
{
    private ListNode listHead;
        
    // Constructor requires one ReadThis parameter to form the head
    public LinkedList(ReadThis firstData)
    {
        listHead = new ListNode(firstData);
    }

    ////
    // Returns data from list head, if it exists
    public ReadThis getFirst() 
    { 
        if (listHead != null)
        {
            return listHead.getData();
        }
        else
        {
            return null;
        }
    }

    
    // Prints the list from head node
    public void printList()
    {
        System.out.println("----------\nStart List\n----------");
        ListNode currNode = listHead;
        while (currNode != null)
        {
            System.out.println("\t" + currNode.getData());
            currNode = currNode.getNext();
        }
        System.out.println("----------\nEnd List\n----------");
    }
    
    
    // Add data to beginning of the list, and return the new
    // start of the list
    public ReadThis addToBeginning(ReadThis newData)
    {
        ListNode newNode = new ListNode(newData);
        newNode.setNext(listHead);
        listHead = newNode;
        return getFirst();
    }
    
    
    // Add data to the end of the list
    public void addToEnd(ReadThis newData)
    {
        ListNode newNode = new ListNode(newData);
        ListNode currNode = listHead;
        while (currNode.getNext() != null)
        {
            currNode = currNode.getNext();
        }
        
        currNode.setNext(newNode);
    }
    
    
    // Add new data after given data, starting the search
    // at listHead
    public void addDataAfterData(ReadThis newData, ReadThis givenData)
    {
        ListNode newNode = new ListNode(newData);
        ListNode currNode = listHead;
            
        // Use short-circuiting: if currNode ends up being
        // null, the first part of the and expression will be
        // false and the second part will never get evaluated
        // (this avoids a null pointer exception)
        while (currNode != null &&
               !currNode.getData().equals(givenData))
        {
            currNode = currNode.getNext();
        }
        
        // currNode will either be null if we got to the
        // end of the list without finding the node,
        // or the node we want to add the new one after
        if (currNode != null)
        {
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
    }
    
    
    // Remove the first node in the list, and return
    // data from the new head
    public ReadThis removeFirst()
    {
        // We just need to cut out the head node,
        // making the second node in the list the head
        // (if there isn't one, that's ok, head will
        // just become null)
        
        listHead = listHead.getNext();
        return getFirst();
    }
    
    
    // Remove the last node from the list, and return
    // data from the head in case it changes because the list
    // is now empty
    public ReadThis removeLast()
    {
        // If there's only one item in the list,
        // the new list should be empty (i.e. head
        // is null)
        if (listHead.getNext() == null)
        {
            listHead = null;
            return getFirst();
        }
        
        // Otherwise, find the last node to remove
        else
        {
            // First we have to actually find the end of the list,
            // but we also have to hang onto the node right before the
            // last one so we can update its next reference
            ListNode prevNode = null;
            ListNode currNode = listHead;
            while (currNode.getNext() != null)
            {
                prevNode = currNode;
                currNode = currNode.getNext();
            }
            
            // currNode is the last one in the list; now we can cut it out
            // using the previous node
            prevNode.setNext(null);
            
            // The head isn't changing in this case, so
            // just return it
            return getFirst();
            
        }
    }
    
    
    // Remove the given node from the list, and return
    // data from the head in case it changes
    public ReadThis remove(ReadThis givenData)
    { 
        // Check if the head is the one to remove;
        // if so, link it out by returning a new head
        // (which can be null)
        if (listHead.getData().equals(givenData))
        {
            listHead = listHead.getNext();
            return getFirst();      
        }
        
        // Otherwise, we can search the list for the
        // node to remove and link it out
        else
        {
            
            ListNode currNode = listHead;
            
            // Stop when the next node's data equals the data
            // we want to remove
            while (currNode.getNext() != null &&
                   !currNode.getNext().getData().equals(givenData))
            {
                currNode = currNode.getNext();
            }
            
            // If currNode's next is null, then we never found the
            // node to remove
            if (currNode.getNext() != null)
            {
                currNode.setNext(currNode.getNext().getNext());
            }
            
            // If we got this far, the head hasn't changed
            return getFirst();        
        }
    }
    
    
    // Get the length of the list, starting at head
    public int getLength()
    {
        // To get the length, walk through the list one
        // node at a time, adding one for each node we
        // visit
        
        int length = 0;
        
        ListNode currNode = listHead;
        while (currNode != null)
        {
            length++;
            currNode = currNode.getNext();
        }
        
        return length;
    }
}