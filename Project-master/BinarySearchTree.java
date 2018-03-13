 public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
 {


 private BinaryNode<AnyType> root;

 public BinarySearchTree( )
 { root = null; }

 public void makeEmpty( )
 { root = null; }


 public boolean isEmpty( )
 { return root == null; }

 public boolean contains( AnyType x )
 { return contains( x, root ); }

 public BinaryNode<AnyType> getRoot()
 {
   return root;
 }

 public int height()
 {
   return height(root);
 }


 private int height(BinaryNode<AnyType> t)
 {
   if( t == null)
    return -1;
  else
    return 1 + Math.max(height(t.left), height(t.right) );
 }


 public AnyType findMin( )
 { //if( isEmpty( ) )
   //throw new UnderflowException( );

   return findMin( root ).element;
 }
 public AnyType findMax( )
 { //if( isEmpty( ) ) throw new UnderflowException( );
 return findMax( root ).element;
 }

 public void insert( AnyType x )
 { root = insert( x, root ); }

 public void remove( AnyType x )
 { root = remove( x, root ); }

 public void printTree( )
 {
	if( isEmpty( ) )
		System.out.println( "Empty tree" );
	else
		printTree( root );
 }

 /**
 * Internal method to find an item in a subtree.
 * @param x is item to search for.
 * @param t the node that roots the subtree.
 * @return true if the item is found; false otherwise.
 */
 private boolean contains( AnyType x, BinaryNode<AnyType> t )
 {
 if( t == null )
 return false;

 int compareResult = x.compareTo( t.element );

 if( compareResult < 0 )
 return contains( x, t.left );
 else if( compareResult > 0 )
 return contains( x, t.right );
 else
 return true; // Match
 }

 /**
 * Internal method to find the smallest item in a subtree.
 * @param t the node that roots the subtree.
 * @return node containing the smallest item.
 */
 private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
 {
 if( t == null )
 return null;
 else if( t.left == null )
 return t;
 return findMin( t.left );
 }

 /**
 * Internal method to find the largest item in a subtree.
 * @param t the node that roots the subtree.
 * @return node containing the largest item.
 */
 private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
 {
 if( t != null )
 while( t.right != null )
 t = t.right;

 return t;
 }



 /**
 * Internal method to insert into a subtree.
 * @param x the item to insert.
 * @param t the node that roots the subtree.
 * @return the new root of the subtree.
 */
 private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
 {
	if( t == null )
		return new BinaryNode<>( x, null, null );

	int compareResult = x.compareTo( t.element );

	if( compareResult < 0 )
		t.left = insert( x, t.left );
	else if( compareResult > 0 )
		t.right = insert( x, t.right );
	else
		; // Duplicate; do nothing
	return t;
 }



 private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
 {
	if( t == null )
		return t; // Item not found; do nothing

	int compareResult = x.compareTo( t.element );

	if( compareResult < 0 )
		t.left = remove( x, t.left );
	else if( compareResult > 0 )
		t.right = remove( x, t.right );
	else if( t.left != null && t.right != null ) // Two children
	{
		t.element = findMin( t.right ).element;
		t.right = remove( t.element, t.right );
	}
	else
		t = ( t.left != null ) ? t.left : t.right;
	return t;

 }

 private void printTree( BinaryNode<AnyType> t )
 {
	if( t != null )
	{
		printTree( t.left );
		System.out.println( t.element );
		printTree( t.right );
	}
 }



 }
