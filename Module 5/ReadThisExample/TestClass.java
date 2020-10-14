public class TestClass
{
    public static void main(String[] args)
    {
        // Here are some objects we can store in our lists...
        
        ReadThis r1 = new ReadThis("http://www.bustle.com/articles/" +
                                   "63466-im-brianna-wu-and-im-risking-" +
                                   "my-life-standing-up-to-gamergate");
        
        ReadThis r2 = new ReadThis("http://i.imgur.com/4NjBQzn.jpg");
        
        ReadThis r3 = new ReadThis("http://imgur.com/zhppgSx");
        
        ReadThis r4 = new ReadThis("http://gnuu.org/2009/09/18/writing-" +
                                   "your-own-toy-compiler/all/1/");
        
        ReadThis r5 = new ReadThis("https://gigaom.com/2015/02/10/samsung-" +
                                   "tvs-start-inserting-ads-into-your-movies/");

        
        
        ////
        // We can manually create a linked list
        // with two nodes like this:

        LinkedList list = new LinkedList(new ListNode(r1, new ListNode(r2)));
        
        ListNode.printNumNodes(); // 2 have been created so far
        //listHead.printNumNodes(); // <- prints the same thing, but should avoid
        //listHead.next.printNumNodes(); // <- prints the same thing, but should avoid
        
        list.printListFromHere(); // bustle, i.imgur
        
        
        ////
        // Now we can add nodes to the beginning, end, and middle:
        
        list.addNodeToBeginning(new ListNode(r3));
        
        list.addNodeToEnd(new ListNode(r4));
        
        list.addNodeAfterNode(new ListNode(r5), list.getListHead());
        
        ListNode.printNumNodes(); // 5 have been created so far
        list.printListFromHere(); // imgur, gigaom, bustle, i.imgur, gnuu
        
        
        ////
        // Let's test removing nodes from the beginning, middle, and end:
        
        list.removeFirstNode();
        list.printListFromHere(); // gigaom, bustle, i.imgur, gnuu
        
        list.removeLastNode();
        list.printListFromHere(); // gigaom, bustle, i.imgur
        
        list.removeNode(list.getListHead().getNext());
        list.printListFromHere(); // gigaom, i.imgur
        
        list.removeNode(list.getListHead());
        list.printListFromHere(); // i.imgur
        
        list.removeNode(list.getListHead());
        System.out.println(list.getListHead()); // <- should be null!
    }
}