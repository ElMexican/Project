public class AvlTree extends BinarySearchTree
{
  @Override
  protected BinaryNode insert(int data, BinaryNode root)
  {
      return balance(super.insert(data, root));
  }

  @Override
  protected BinaryNode remove(int data, BinaryNodeh root)
  {
      return balance(super.remove(data, root));
  }




 private static final int ALLOWED_IMBALANCE = 1;

 // Assume t is either balanced or within one of being balanced
 private AvlNode<AnyType> balance( AvlNode<AnyType> t )
 {
 if( t == null )
 return t;

 if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE )
 if( height( t.left.left ) >= height( t.left.right ) )
 t = rotateWithLeftChild( t );
 else
 t = doubleWithLeftChild( t );
 else
 if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE )
 if( height( t.right.right ) >= height( t.right.left ) )
 t = rotateWithRightChild( t );
 else
 t = doubleWithRightChild( t );

 t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
 return t;
 }

 /**
 * Rotate binary tree node with left child.
 * For AVL trees, this is a single rotation for case 1.
 * Update heights, then return new root.
 */
 private AvlNode<AnyType> rotateWithLeftChild( AvlNode<AnyType> k2 )
 {
 AvlNode<AnyType> k1 = k2.left;
 k2.left = k1.right;
 k1.right = k2;
 k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
 k1.height = Math.max( height( k1.left ), k2.height ) + 1;
 return k1;
 }


 /**
 * Double rotate binary tree node: first left child
 * with its right child; then node k3 with new left child.
 * For AVL trees, this is a double rotation for case 2.
 * Update heights, then return new root.
 */
 private AvlNode<AnyType> doubleWithLeftChild( AvlNode<AnyType> k3 )
 {
 k3.left = rotateWithRightChild( k3.left );
 return rotateWithLeftChild( k3 );
 }



}
