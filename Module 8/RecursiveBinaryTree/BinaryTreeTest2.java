public class BinaryTreeTest2
{
    public static void main(String[] args) 
    {
        BinaryTree  root; 
        root = new BinaryTree("A",
                              new BinaryTree("B",
                                             new BinaryTree("C",
                                                            new BinaryTree("D"),
                                                            new BinaryTree("E",
                                                                           new BinaryTree("F",
                                                                                          new BinaryTree("G"),
                                                                                          new BinaryTree("I")),
                                                                           new BinaryTree("H"))),
                                             new BinaryTree("J",
                                                            new BinaryTree("K",
                                                                           null,
                                                                           new BinaryTree("L",
                                                                                          null,
                                                                                          new BinaryTree("M"))),
                                                            new BinaryTree("N",
                                                                           null,
                                                                           new BinaryTree("O")))),
                              new BinaryTree("P",
                                             new BinaryTree("Q"),
                                             new BinaryTree("R",
                                                            new BinaryTree("S",
                                                                           new BinaryTree("T"),
                                                                           null),
                                                            new BinaryTree("U"))));



        BinaryTree duplicateRoot1 = root;


        
        BinaryTree duplicateRoot2; 
        duplicateRoot2 = new BinaryTree("A",
                              new BinaryTree("B",
                                             new BinaryTree("C",
                                                            new BinaryTree("D"),
                                                            new BinaryTree("E",
                                                                           new BinaryTree("F",
                                                                                          new BinaryTree("G"),
                                                                                          new BinaryTree("I")),
                                                                           new BinaryTree("H"))),
                                             new BinaryTree("J",
                                                            new BinaryTree("K",
                                                                           null,
                                                                           new BinaryTree("L",
                                                                                          null,
                                                                                          new BinaryTree("M"))),
                                                            new BinaryTree("N",
                                                                           null,
                                                                           new BinaryTree("O")))),
                              new BinaryTree("P",
                                             new BinaryTree("Q"),
                                             new BinaryTree("R",
                                                            new BinaryTree("S",
                                                                           new BinaryTree("T"),
                                                                           null),
                                                            new BinaryTree("U"))));



        BinaryTree distinctRoot1; 
        distinctRoot1 = new BinaryTree("A",
                              new BinaryTree("B",
                                             new BinaryTree("C",
                                                            new BinaryTree("D"),
                                                            new BinaryTree("E",
                                                                           new BinaryTree("F",
                                                                                          new BinaryTree("G"),
                                                                                          new BinaryTree("I")),
                                                                           new BinaryTree("H"))),
                                             new BinaryTree("J",
                                                            new BinaryTree("K",
                                                                           null,
                                                                           new BinaryTree("L",
                                                                                          null,
                                                                                          new BinaryTree("M"))),
                                                            new BinaryTree("N",
                                                                           new BinaryTree("O"),
                                                                           null))), // reversed left & right here
                              new BinaryTree("P",
                                             new BinaryTree("Q"),
                                             new BinaryTree("R",
                                                            new BinaryTree("S",
                                                                           new BinaryTree("T"),
                                                                           null),
                                                            new BinaryTree("U"))));




        
        System.out.println("The tree's height is: " + root.height()); // 6
        System.out.println("The tree's leaves are: " + root.leafData()); // D, G, I, H, M, O, Q, T, U
        System.out.println(root.hasSameContentsAs(duplicateRoot1)); // true
        System.out.println(root.hasSameContentsAs(duplicateRoot2)); // true
        System.out.println(root.hasSameContentsAs(distinctRoot1)); // false
        System.out.println("The tree has " + root.numberOfNodes() + " nodes"); // 21
    }
}
