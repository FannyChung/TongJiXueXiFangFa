/**
 * 
 */
package ch3KNN;

/**
 * @author fang
 *
 */
public class Node<T> {

	Node<T> child;
	Node<T> parent;
	public Node<T> getParent() {
		return parent;
	}
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	T t;
	int level;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public Node<T> getChild() {
		return child;
	}
	public void setChild(Node<T> child) {
		this.child = child;
	}
	/**
	 * 
	 */
	public Node(T t) {
		this.t=t;
	}

}
