package com.example.contactlist;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView lv;
	ItemAdapter adapter;
	ArrayList<Contact> list=new ArrayList<Contact>();
	ContactDatabase db;
	AdapterView.AdapterContextMenuInfo info;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv=(ListView) this.findViewById(R.id.listView1);
        
        
        db=new ContactDatabase(this);
        if(db.getAllContact().size()>0){
        	list=db.getAllContact();
        }
        this.adapter=new ItemAdapter(this,list);
        this.lv.setAdapter(adapter);
        this.registerForContextMenu(lv);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    
    

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id=item.getItemId();
		
		if(id==R.id.delete){
			
			list.remove(info.position);
			String phone=list.get(info.position).getTel();
			db.deleteContact(phone);
			adapter.notifyDataSetChanged();
		}
		
		
		return super.onContextItemSelected(item);
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		 getMenuInflater().inflate(R.menu.contextmenu, menu);
		 info=(AdapterContextMenuInfo) menuInfo;
		 menu.setHeaderTitle(list.get(info.position).getName());
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent =new Intent(this,AddItemActivity.class);
		this.startActivityForResult(intent, 0);		//add new contact
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==Activity.RESULT_OK){
			if(requestCode==0){
					Bundle b=data.getExtras();
					Uri image=b.getParcelable("image");
					String name=b.getString("name");
					String phone=b.getString("phone");
					
					//add to database as record
					long l=db.addContact(image.toString(), name, phone);
					
					Contact contact = new Contact(image,name,phone);
					list.add(contact);
					this.adapter.notifyDataSetChanged();
				
			}
		}				
	}
    
}
