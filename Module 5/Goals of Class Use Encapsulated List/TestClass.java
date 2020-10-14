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
        // We can manually create a list
        // with two entries like this:
        LinkedList list = new LinkedList(r1);
        list.addToEnd(r2);
   
        ListNode.printNumNodes(); // 2 have been created so far
        
        list.printList(); // bustle, i.imgur
        
        
        ////
        // Now we can add nodes to the beginning, end, and middle:
        
        list.addToBeginning(r3);
        
        list.addToEnd(r4);
        
        list.addDataAfterData(r5, list.getFirst());
        
        ListNode.printNumNodes(); // 5 have been created so far
        list.printList(); // imgur, gigaom, bustle, i.imgur, gnuu
        
        
        ////
        // Let's test removing nodes from the beginning, middle, and end:
        
        list.removeFirst();
        list.printList(); // gigaom, bustle, i.imgur, gnuu
        
        list.removeLast();
        list.printList(); // gigaom, bustle, i.imgur
        
        list.remove(r1);
        list.printList(); // gigaom, i.imgur
        
        list.remove(list.getFirst());
        list.printList(); // i.imgur
        
        list.remove(list.getFirst());
        System.out.println(list.getFirst()); // <- should be null!
    }
}