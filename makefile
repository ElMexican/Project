
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AvlTree.java \
	BinaryNode.java \
	BinarySearchTree.java \
	TreePrinter.java \
	TreeTester.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
