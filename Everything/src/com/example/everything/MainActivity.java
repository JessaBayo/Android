package com.example.everything;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	GridView gv;
	GridAdapter adapter;
	ArrayList<Person> list= new ArrayList<Person>();

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
        this.list.add(new Person(R.drawable.img1,"Claire","BA"));
        this.list.add(new Person(R.drawable.img2,"JienRose","BEED"));
        this.list.add(new Person(R.drawable.img3,"Ailyn","BSIT"));
        this.list.add(new Person(R.drawable.img4,"Girlie","BSIT"));
        this.list.add(new Person(R.drawable.img5,"Sherlyn","BASMASSCOM"));
        this.list.add(new Person(R.drawable.img6,"Melvic","BSBA"));
        this.list.add(new Person(R.drawable.img7,"Jeremy","BSHRM"));
        this.list.add(new Person(R.drawable.img8,"Leonardo","BSHRM"));
        this.list.add(new Person(R.drawable.img9,"MarkAndrew","BSHRM"));
        this.list.add(new Person(R.drawable.img10,"Kenwahl","BSIT"));
        this.list.add(new Person(R.drawable.img11,"Joannie","BSCRIM"));
        this.list.add(new Person(R.drawable.img12,"Apple","BSOA"));
        
        this.gv=(GridView) this.findViewById(R.id.gridView1);
        this.adapter= new GridAdapter(this,list);
        this.gv.setAdapter(adapter);
        
        this.gv.setOnItemClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		
		LinearLayout layout=new LinearLayout (this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
	
		
		ImageView iv=new ImageView(this);
		TextView tv= new TextView(this);
		
		iv.setImageResource(list.get(arg2).getImage());
		tv.setText(list.get(arg2).getCourse());
		
		layout.addView(iv);
		layout.addView(tv);
		
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getName());
		builder.setView(layout);
		builder.setNeutralButton("Okey",null);
		
		AlertDialog dialog= builder.create();
		dialog.show();
		
		
		
		
	}
    
}
