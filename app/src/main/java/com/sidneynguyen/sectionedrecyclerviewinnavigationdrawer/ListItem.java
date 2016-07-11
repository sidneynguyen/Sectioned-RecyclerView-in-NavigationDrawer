package com.sidneynguyen.sectionedrecyclerviewinnavigationdrawer;

/**
 * Created by sidney on 7/11/16.
 */
public class ListItem implements ListSection {

    private String mItem;

    public ListItem(String item) {
        mItem = item;
    }

    public String getItem() {
        return mItem;
    }

    @Override
    public boolean isHeader() {
        return false;
    }
}
