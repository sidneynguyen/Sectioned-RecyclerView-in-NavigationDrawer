package com.sidneynguyen.sectionedrecyclerviewinnavigationdrawer;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SectionedRecyclerViewFragment extends Fragment {

    public SectionedRecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sectioned_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListSection[] list = {
                new ListHeader("Header 1"),
                new ListItem("Item 1"),
                new ListItem("Item 2"),
                new ListItem("Item 3"),
                new ListHeader("Header 2"),
                new ListItem("Item 4"),
                new ListItem("Item 5"),
                new ListItem("Item 6"),
                new ListItem("Item 7"),
                new ListHeader("Header 3"),
                new ListItem("Item 8"),
                new ListItem("Item 9")
        };

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomAdapter adapter = new CustomAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
