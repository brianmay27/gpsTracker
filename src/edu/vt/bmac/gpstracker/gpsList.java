package edu.vt.bmac.gpstracker;

import java.io.Serializable;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Used to store Node items, which contain GPS info, and have the ability to
 *  list the nodes.
 *
 *  Some items may not be used but I wanted to get them to work so I did a quick
 *  Implementation. Everything works so it should not be a problem going on.
 *
 *  @author Brian McNamara (bmac), Anthony Allen(ala2555), Chris Pan (chrisp3)
 *  @version Apr 2, 2013
 */
public class gpsList implements gpsListI, Serializable
{
    private ArrayList<Node> data;
    private Integer id;

    // ----------------------------------------------------------
    /**
     * Constructor
     */
    public gpsList(Integer id) {
        this.id = id;
        data = new ArrayList<Node>();
    }
    public Integer getId() {
        return id;
    }
    public void add(Node item)
    {
        data.add(item);

    }

    public Node top()
    {
        return data.get(data.size() - 1);
    }

    public Node at(int i)
    {
        return data.get(i);
    }

    public boolean isEmpty()
    {
        return data.isEmpty();
    }

    public Node remove()
    {
        if (!data.isEmpty()) {
            return data.remove(data.size() - 1);
        }
        else {
            throw new java.util.NoSuchElementException();
        }
    }

    public Node remove(int i)
    {
        if (i < data.size()) {
            return data.remove(i);
        }
        else {
            throw new java.util.NoSuchElementException();
        }
    }

    public int size()
    {
        return data.size();
    }
    public ArrayList<Node> getList() {
        return this.data;
    }

}
