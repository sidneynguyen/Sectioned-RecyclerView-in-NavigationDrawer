package com.sidneynguyen.sectionedrecyclerviewinnavigationdrawer;

/**
 * Created by sidney on 7/11/16.
 */
public interface SectionedRecyclerViewItem {

    boolean isHeader();

    class Header implements SectionedRecyclerViewItem {

        private String mHeader;

        public Header(String header) {
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

    class Item implements SectionedRecyclerViewItem {

        private String mItem;

        public Item(String item) {
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
}
