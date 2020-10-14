public class TestClass
{
    public static void main(String[] args)
    {
        // Here are some objects we can store in our lists...
        
        String r1 = new String("Iron Man");
        
        String r2 = new String("Captain America");
        
        String r3 = new String("Thor");
        
        String r4 = new String("Black Widow");
        
        String r5 = new String("Hulk");

        
        
        ////
        // We can manually create a linked list
        // with two nodes like this:

        ListNode listHead = new ListNode(r1);
        listHead.next = new ListNode(r2, listHead);
        
        ListNode.printNumNodes(); // 2 have been created so far
        //listHead.printNumNodes(); // <- prints the same thing, but should avoid
        //listHead.next.printNumNodes(); // <- prints the same thing, but should avoid
        
        listHead.printListFromHere(); // Iron Man, Captain America
        
        
        ////
        // Now we can add nodes to the beginning, end, and middle:
        
        listHead = listHead.addNodeToBeginning(new ListNode(r3));
        
        listHead.addNodeToEnd(new ListNode(r4));
        
        listHead.addNodeAfterNode(new ListNode(r5), listHead);
        
        ListNode.printNumNodes(); // 5 have been created so far
        listHead.printListFromHere(); // Thor, Hulk, Iron Man, Captain America, Black Widow
        
        System.out.println("\n" + listHead.concatenate() + "\n"); // ThorHulkIron ManCaptain AmericaBlack Widow
        System.out.println("Length of list: " + listHead.getLength() + "\n"); // Length of list: 5
        
        listHead = listHead.reverse();
        System.out.println("Reversed!");
        
        System.out.println(listHead.data); //Black Widow (this is the new head)
        listHead.printListFromHere(); // Black Widow, Captain America, Iron Man, Hulk, Thor
        
        
        ////
        // Let's test removing nodes from the beginning, middle, and end:
        
        listHead = listHead.removeFirstNode();
        listHead.printListFromHere(); // Captain America, Iron Man, Hulk, Thor
        
        listHead = listHead.removeLastNode();
        listHead.printListFromHere(); // Captain America, Iron Man, Hulk
        
        listHead = listHead.removeNode(listHead.next);
        listHead.printListFromHere(); // Captain America, Hulk
        
        listHead = listHead.removeNode(listHead);
        listHead.printListFromHere(); // Hulk
        
        listHead = listHead.removeNode(listHead);
        System.out.println(listHead); // <- should be null!
        
    }
    
    
    
}