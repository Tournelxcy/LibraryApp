package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class BookListFragment extends Fragment{
    private static final String TAG = "BookListFragment";
    private FloatingActionMenu actionAdd;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.booklist_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        actionAdd = (FloatingActionMenu) view.findViewById(R.id.fab_menu_add);
        fab1 = (FloatingActionButton) view.findViewById(R.id.fab_menu_item_1);
        fab1.setOnClickListener(mOnClickListener);
        fab2 = (FloatingActionButton) view.findViewById(R.id.fab_menu_item_2);
        fab2.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.fab_menu_item_1:
                    Log.i(TAG,"fab menu item 1 clicked");
                    actionAdd.close(true);
                    break;
                case R.id.fab_menu_item_2:
                    Log.i(TAG,"fab menu item 2 clicked");
                    actionAdd.close(true);
                    break;
                default:
                    break;
            }
        }
    };
}
