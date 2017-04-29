package com.example.mylistview;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	ListView lv;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv=(ListView)this.findViewById(R.id.listView1);
        this.lv.setOnItemClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		String[] items=this.getResources().getStringArray(R.array.names);
		
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("Selected Item");
		builder.setMessage(items[arg2]);
		builder.setNeutralButton("Okey",null);
		
		AlertDialog dialog	=builder.create();
		dialog.show();
		
				
				
		
	}
    
}
