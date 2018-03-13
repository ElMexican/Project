public class BinaryNode<AnyType>
{
// Constructors
BinaryNode( AnyType theElement )
{ this( theElement, null, null );
}

BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
{
   element = theElement;
   left = lt;
   right = rt;
   height = 0;
}

AnyType element; // The data in the node
BinaryNode<AnyType> left; // Left child
BinaryNode<AnyType> right; // Right child
int height;


public BinaryNode <AnyType> getLeft()
{
  return left;
}

public BinaryNode <AnyType> getRight()
{
  return right;
}

public AnyType getData()
{
  return element;
}

public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }



}
