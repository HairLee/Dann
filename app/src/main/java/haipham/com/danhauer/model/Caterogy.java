package haipham.com.danhauer.model;

/**
 * Created by hailpt on 13/10/2016.
 */

public class Caterogy {

    private String id;
    private String itemCount;
    private String mImage;

    public Caterogy(){

    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }
}
