package com.sidneynguyen.sectionedrecyclerviewinnavigationdrawer;

/**
 * Created by sidney on 7/11/16.
 */
public class ListHeader implements ListSection {

    private String mHeader;

    public ListHeader(String header) {
        mHeader = header;
    }

    public String getHeader() {
        return mHeader;
    }

    @Override
    public boolean isHeader() {
        return true;
    }
}
