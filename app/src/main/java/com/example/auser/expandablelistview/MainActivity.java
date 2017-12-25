package com.example.auser.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ArrayList<Map<String,String>> groupList=new ArrayList<>();
    ArrayList<ArrayList<Map<String,String>>>childList=new ArrayList<>();
    ExpandableListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ExpandableListView) findViewById(R.id.expendableListView);

        HashMap<String,String>m1=new HashMap<>();
        m1.put("main_name","便當,快餐類");
        groupList.add(m1);
        HashMap<String,String>m2=new HashMap<>();
        m2.put("main_name","燒烤類");
        groupList.add(m2);

        HashMap<String,String>m11=new HashMap<>();
        m11.put("sub_name","油雞飯");
        HashMap<String,String>m12=new HashMap<>();
        m12.put("sub_name","雞排飯");
        HashMap<String,String>m13=new HashMap<>();
        m13.put("sub_name","控肉飯");

        ArrayList<Map<String,String>> cList1=new ArrayList<>();
        cList1.add(m11);
        cList1.add(m12);
        cList1.add(m13);
        childList.add(cList1);

        HashMap<String,String>m21=new HashMap<>();
        m21.put("sub_name","烤蝦");
        HashMap<String,String>m22=new HashMap<>();
        m22.put("sub_name","牛小排");
        HashMap<String,String>m23=new HashMap<>();
        m23.put("sub_name","魚下巴");

        ArrayList<Map<String,String>> cList2=new ArrayList<>();
        cList2.add(m21);
        cList2.add(m22);
        cList2.add(m23);
        childList.add(cList2);

        SimpleExpandableListAdapter adapter=new SimpleExpandableListAdapter(
           MainActivity.this,
                groupList,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"main_name"},
                new int[]{android.R.id.text1},
                childList,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"sub_name"},
                new int[]{android.R.id.text1}

        );
        lv.setAdapter(adapter);
        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String p=groupList.get(groupPosition).get("main_name");
                String c=childList.get(groupPosition).get(childPosition).get("sub_name");
                Toast.makeText(MainActivity.this,p+"," +c,Toast.LENGTH_SHORT).show();
                return  false;

            }
        });




    }
}
