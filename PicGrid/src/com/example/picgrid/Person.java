package com.example.picgrid;

import android.net.Uri;

public class Person {

	public Uri getImageUri() {
		return imgaeUri;
	}
	public void setImgaeUri(Uri imgaeUri) {
		this.imgaeUri = imgaeUri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Uri imgaeUri;
	private String name;
	public Person(Uri imgaeUri, String name) {
		super();
		this.imgaeUri = imgaeUri;
		this.name = name;
	}
	
	
	
}
