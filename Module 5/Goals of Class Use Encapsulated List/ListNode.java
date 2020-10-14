public class ListNode
{
    private ReadThis data;    
    private ListNode next;
    
    private static int totalNodes = 0;
    
    public ListNode(ReadThis newData)
    {
        this(newData, null);
    }
    
    public ListNode(ReadThis newData, ListNode newNext)
    {
        data = newData;
        next = newNext;
        totalNodes++;
    }
    
    ////
    // Getters and setters - we never need to change the data in a node
    // once it's been created
    public ReadThis getData() { return data; }
    public ListNode getNext() { return next; }

    public void setNext(ListNode newNext) { next = newNext; }

    public static void printNumNodes()
    {
        System.out.println(totalNodes + " have been created so far.");
    }
}