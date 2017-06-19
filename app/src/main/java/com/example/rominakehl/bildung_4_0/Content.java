package com.stundentcomments.stundentcomment;

import android.media.Image;

/**
 * Created by yannick.mickler on 27.05.2017.
 */

public class Content {
    private String sComment = "";
    private int iPic = -1;

    public Content(String comment, int pic){
        this.sComment = comment;
        this.iPic = pic;
    }

    public boolean hasPic()
    {
        return (this.iPic != -1);
    }

    public boolean hasComment()
    {
        return (this.sComment != "");
    }

    public boolean isValid()
    {
        return (hasPic() && hasComment());
    }
    public String getComment()
    {
        return this.sComment;
    }

    public int getPicId()
    {
        return this.iPic;
    }
}
