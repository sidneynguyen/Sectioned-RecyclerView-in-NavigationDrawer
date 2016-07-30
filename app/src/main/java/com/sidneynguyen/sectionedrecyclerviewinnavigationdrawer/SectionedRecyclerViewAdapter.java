package com.sidneynguyen.sectionedrecyclerviewinnavigationdrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SectionedRecyclerViewAdapter extends RecyclerView.Adapter<SectionedRecyclerViewAdapter.SectionedRecyclerViewViewHolder> {

    private static final int HEADER_VIEW_TYPE = 1;
    private static final int ITEM_VIEW_TYPE = 0;

    private SectionedRecyclerViewItem[] mList;

    public SectionedRecyclerViewAdapter(SectionedRecyclerViewItem[] list) {
        mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList[position].isHeader()) {
            return HEADER_VIEW_TYPE;
        } else {
            return ITEM_VIEW_TYPE;
        }
    }

    @Override
    public SectionedRecyclerViewAdapter.SectionedRecyclerViewViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        if (viewType == HEADER_VIEW_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,
                    parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                    parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(
            SectionedRecyclerViewAdapter.SectionedRecyclerViewViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).setTextViewText(
                    ((SectionedRecyclerViewItem.Header) mList[position]).getHeader());
        } else {
            ((ItemViewHolder) holder).setTextViewText(
                    ((SectionedRecyclerViewItem.Item) mList[position]).getItem());
        }
    }

    @Override
    public int getItemCount() {
        return mList.length;
    }

    protected abstract class SectionedRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        public SectionedRecyclerViewViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class ItemViewHolder extends SectionedRecyclerViewViewHolder {

        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_textView);
        }

        public void setTextViewText(String item) {
            mTextView.setText(item);
        }
    }

    private class HeaderViewHolder extends SectionedRecyclerViewViewHolder {

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
