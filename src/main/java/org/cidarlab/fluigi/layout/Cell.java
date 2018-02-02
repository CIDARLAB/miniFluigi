package org.cidarlab.fluigi.layout;

/**
 * Created by krishna on 3/7/17.
 */
public class Cell {

    private final String id;
    private int x;
    private int y;
    private int xspan; //width x-span
    private int yspan; //height y-span

    public Cell(String id, int x, int y, int xspan, int yspan) {
        this.id = id;
        this.setX(x);
        this.setY(y);
        this.setXspan(xspan);
        this.setYspan(yspan);
    }

    public String getID() {
        return id;
    }

    public int getCoord(int axis) {
        if (axis == 1) {
            return x;
        } else {
            return y;
        }
    }

    public void setCoord(int value, int axis) {
        if (axis == 1) {
            x = value;
        } else {
            y = value;
        }
    }

    public void addCoord(double delta, int axis, int max) {
        if (axis == 1) {
            addX(delta, max);
        } else {
            addY(delta, max);
        }
    }

    public void addCoord(double delta, int axis, int min, int max) {
        if (axis == 1) {
            addX(delta, min, max);
        } else {
            addY(delta, min, max);
        }
    }

    public double getCenterCoord(int axis) {
        if (axis == 1) {
            return getCenterX();
        } else {
            return getCenterY();
        }
    }

    public int getSpan(int axis) {
        if (axis == 1) {
            return xspan;
        } else {
            return yspan;
        }
    }

    /**
     * Returns the X co-ordinate of the ce;; (top left corner)
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the X co-ordinate of the ce;; (top left corner)
     * @return
     */
    public void setX(int x) {
        this.x = x;
    }

    public void addX(double delta, int max) {
        if (Math.abs(delta) < 1e-6) {
            return;
        }
        if (delta > 0 && delta < 1) {
            delta = 1;
        } else if (delta < 0 && delta > -1) {
            delta = -1;
        }
        if (this.x + this.xspan + delta >= max) {
            this.x = (int) (max - delta - this.xspan);
        } else if (this.x + delta < 0) {
            this.x = 0;
        } else {
            this.x += (int) delta;
        }
    }

    public void addX(double delta, int min, int max) {
        if (Math.abs(delta) < 1e-6) {
            return;
        }
        if (delta > 0 && delta < 1) {
            delta = 1;
        } else if (delta < 0 && delta > -1) {
            delta = -1;
        }
        if (this.x + this.xspan + delta >= max) {
            this.x = (int) (max - delta - this.xspan);
        } else if (this.x + delta < min) {
            this.x = min;
        } else {
            this.x += (int) delta;
        }
    }

    /**
     * Returns the Y co-ordinate of the ce;; (top left corner)
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the Y co-ordinate of the ce;; (top left corner)
     * @return
     */
    public void setY(int y) {
        this.y = y;
    }

    public void addY(double delta, int max) {
        if (Math.abs(delta) < 1e-6) {
            return;
        }
        if (delta > 0 && delta < 1) {
            delta = 1;
        } else if (delta < 0 && delta > -1) {
            delta = -1;
        }
        if (this.y + this.yspan + delta >= max) {
            this.y = (int) (max - delta - this.yspan);
        } else if (this.y + delta < 0) {
            this.y = 0;
        } else {
            this.y += (int) delta;
        }
    }

    public void addY(double delta, int min, int max) {
        if (Math.abs(delta) < 1e-6) {
            return;
        }
        if (delta > 0 && delta < 1) {
            delta = 1;
        } else if (delta < 0 && delta > -1) {
            delta = -1;
        }
        if (this.y + this.yspan + delta >= max) {
            this.y = (int) (max - delta - this.yspan);
        } else if (this.y + delta < min) {
            this.y = min;
        } else {
            this.y += (int) delta;
        }
    }

    /**
     * Returns the X-Dimension of the cell
     * @return
     */
    public int getXspan() {
        return xspan;
    }

    /**
     * Sets the X-Dimension of the cell
     * @return
     */
    public void setXspan(int xspan) {
        this.xspan = xspan;
    }

    /**
     * Returns the Y-Dimension of the cell
     * @return
     */
    public int getYspan() {
        return yspan;
    }

    /**
     * Sets the Y-Dimension of the cell
     * @return
     */
    public void setYspan(int yspan) {
        this.yspan = yspan;
    }

    /**
     * Returns the center X coordinate of the cell
     * @return
     */
    public double getCenterX(){ return x + xspan / 2; }

    /**
     * Returns the center Y coordinate of the cell
     * @return
     */
    public double getCenterY(){ return y + yspan / 2; }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Cell) && ((Cell) obj).getID().equals(this.getID());
    }

    @Override
    public String toString() {
        return String.format("Cell %s (%f, %f)", getID(), getCenterX(), getCenterY());
    }

    /**
     * Returns the largest X coordinate of the cell
     * @return
     */
    public int getMaxX() {
        return x + xspan;
    }

    /**
     * Returns the largest Y coordinate of the cell
     * @return
     */
    public int getMaxY() {
        return y + yspan;
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     *
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     *
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     *
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     *
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Cell clone = new Cell(this.id,this.x,this.y,this.xspan,this.yspan);
        return clone;
    }
}
