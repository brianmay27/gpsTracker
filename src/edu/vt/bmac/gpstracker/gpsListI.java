package edu.vt.bmac.gpstracker;

// -------------------------------------------------------------------------
/**
 *  interface for the GPS List which stores Locations to be analyzed later
 *
 *  @author Brian McNamara (bmac), Anthony Allen(ala2555), Chris Pan (chrisp3)
 *  @version Apr 30, 2013
 */
public interface gpsListI
{
    /**
     * Add to the list at the end
     * @param item An node to be added
     */
    public void add(Node item);
    /**
     * List item at the end
     * @return the top node
     */
    public Node top();
    /**
     * List item at index
     * @return node at location i
     * @param i the index of the item
     */
    public Node at(int i);
    /**
     * remove the top item
     * @return the item removed
     */
    public Node remove();
    /**
     * remove at location i
     * @return the Node that was removed
     * @param i the index of the node to be removed
     */
    public Node remove(int i);
    /**
     * Checks if list is empty
     * @return true if empty
     */
    public boolean isEmpty();
    /**
     * returns the size of the list
     * @return the size
     */
    public int size();
}
