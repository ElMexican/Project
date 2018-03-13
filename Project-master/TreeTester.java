import java.util.Random;

public class TreeTester
{
  public static void main(String[] args)
  {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    Random rand = new Random();

    while(bst.height() <5 )
    {
      bst.insert(rand.nextInt(100 - 10) + 10);
    }

    new TreePrinter(bst).print("bst");

    while(!bst.isEmpty())
    {
      bst.remove(bst.getRoot().getData());
      new TreePrinter(bst).print("Removed root");
    }

    return;

  }



}
