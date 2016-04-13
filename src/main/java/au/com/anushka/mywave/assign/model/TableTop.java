package au.com.anushka.mywave.assign.model;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * Denotes a Table for the Game
 */
public class TableTop {

    /**
     * Width of Table Top
     */
    private Integer width;

    /**
     * Height of Table Top
     */
    private Integer height;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableTop tableTop = (TableTop) o;

        if (width != null ? !width.equals(tableTop.width) : tableTop.width != null) return false;
        return !(height != null ? !height.equals(tableTop.height) : tableTop.height != null);

    }

    @Override
    public int hashCode() {
        int result = width != null ? width.hashCode() : 0;
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TableTop{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
