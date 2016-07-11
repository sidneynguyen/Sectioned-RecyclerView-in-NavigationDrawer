package com.sidneynguyen.sectionedrecyclerviewinnavigationdrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sidney on 7/11/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    private ListSection[] mList;

    public CustomAdapter(ListSection[] list) {
        mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList[position].isHeader()) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_section,
                    parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_section,
                    parent, false);
            return new CustomViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).setTextViewText(((ListHeader) mList[position]).getHeader());
        } else {
            ((CustomViewHolder) holder).setTextViewText(((ListItem) mList[position]).getItem());
        }
    }

    @Override
    public int getItemCount() {
        return mList.length;
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_textView);
        }

        public void setTextViewText(String item) {
            mTextView.setText(item);
        }
    }

    protected class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.header_textView);
        }

        public void setTextViewText(String header) {
            mTextView.setText(header);
        }
    }
}
