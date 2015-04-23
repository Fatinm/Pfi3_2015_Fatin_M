package k3.assignment4final;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Loki on 2015-04-21.
 */
public class Planet implements Serializable {
    String title;
    String radius;
    String temp;
    Drawable image;
    String summary;

    public Planet(String title, String radius, String temp, Drawable image, String summary) {
        this.title = title;
        this.temp = temp;
        this.image = image;
        this.radius=radius;
        this.summary = summary;

    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }



    @Override
    public String toString() {
        return title;
    }

    public String getSummary() {
        return summary;}

    public void setSummary(String summary){
        this.summary=summary;
    }

}