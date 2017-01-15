package com.example.fontt;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;


import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;



@SuppressLint("NewApi")
public class Editor extends Activity {
	EditText t;

	Intent sharingIntent;

	float  TesT2;

	String[] spinnerValues = {  "تیتر", "نستعلیق","بانو", "نستعلیق 2", "کرشمه","شابلن","سیم خاردار"};

	String[] fontfile = {"titr.ttf","nast.ttf","BanooThin.ttf","nast2.ttf","keresh.ttf" ,"shablon.ttf","sim.ttf"};

	Typeface[] f;

	String ResaultPath="";

	ArrayList<Button> back_bs;



	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		f=new Typeface[fontfile.length];

		for(int i=0;i<fontfile.length;i++){
			f[i]=Typeface.createFromAsset(getAssets(),fontfile[i]);
		}


		FrameLayout ic=(FrameLayout)findViewById(R.id.fcsaver);
		//  ic.setLayoutParams(new FrameLayout.LayoutParams(500,500));

		t=(EditText) findViewById(R.id.textI);

		t.setTextSize(30);
		t.setTextColor(Color.rgb(255,100,15));

		t.setHeight(300);
		t.setMaxHeight(700);
		t.setMaxLines(10);
		t.setBackgroundResource(R.drawable.ttt);

		t.setTypeface(f[2]);




		back_bs=new ArrayList<Button>();
		back_bs.add((Button)findViewById(R.id.bac_g1));
		back_bs.add((Button)findViewById(R.id.bac_g2));
		back_bs.add((Button)findViewById(R.id.bac_g3));
		back_bs.add((Button)findViewById(R.id.bac_g4));
		back_bs.add((Button)findViewById(R.id.bac_g5));
		back_bs.add((Button)findViewById(R.id.bac_g6));
		back_bs.add((Button)findViewById(R.id.bac_g7));
		back_bs.add((Button)findViewById(R.id.bac_g8));
		back_bs.add((Button)findViewById(R.id.bac_g9));
		back_bs.add((Button)findViewById(R.id.bac_g10));
		back_bs.add((Button)findViewById(R.id.bac_g11));
		back_bs.add((Button)findViewById(R.id.bac_g12));
		back_bs.add((Button)findViewById(R.id.bac_g13));
		back_bs.add((Button)findViewById(R.id.bac_g14));
		back_bs.add((Button)findViewById(R.id.bac_g15));
		back_bs.add((Button)findViewById(R.id.bac_g16));


		String[] ssss=new String[back_bs.size()];

		AssetManager asm=getAssets();
		InputStream is = null ,is2= null;
		Drawable ddd,dddsb;
		for(int i=0;i<ssss.length;i++){
			try {
				is=asm.open("p ("+String.valueOf(i+1)+").jpg");
				is2=asm.open("sb ("+String.valueOf(i+1)+").jpg");
			} catch (IOException e) {
				e.printStackTrace();
			}

			ddd=Drawable.createFromStream(is, "p ("+String.valueOf(i+1)+").jpg");

			dddsb=Drawable.createFromStream(is2, "sb ("+String.valueOf(i+1)+").jpg");

			back_bs.get(i).setBackground(dddsb);

			final Drawable dddd=ddd;

			back_bs.get(i).setOnClickListener(new OnClickListener() {

				public void onClick(View arg0) {
					t.setBackground(dddd);
				}
			});
		}




		ToggleButton centerB=(ToggleButton)findViewById(R.id.bold_but);
		centerB.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if(arg1==true)t.setGravity(Gravity.CENTER);
				else t.setGravity(Gravity.RIGHT);
			}
		});






		TesT2=t.getTextSize();


		Button plus=(Button)findViewById(R.id.plus);        
		plus.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				TesT2=TesT2+4;
				t.setTextSize(TesT2);
			}
		});


		Button mines=(Button)findViewById(R.id.mines);
		mines.setOnClickListener(new OnClickListener() {        	
			public void onClick(View arg0) {
				TesT2=TesT2-5;
				t.setTextSize(TesT2);
			}
		});


		Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

		MyAdapter  dataAdapter=new MyAdapter(this,R.layout.custom_spiner,spinnerValues);

		mySpinner.setAdapter(dataAdapter);

		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				t.setTypeface(f[arg2]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});


		Button pakon=(Button)findViewById(R.id.pakon);
		pakon.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				t.setText("  ");
			}
		});


		Button shut=(Button)findViewById(R.id.shut);
		shut.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if(t.getText().toString()!="" && t.getText().toString()!=" " && t.getText().toString()!=null){
					t.setCursorVisible(false);
					add_space();
					try {
						ResaultPath=shooot();
					} catch (IOException e) {
						e.printStackTrace();
					}
					t.setCursorVisible(true);
				}
			}
		});


		Button sharB=(Button)findViewById(R.id.share_b);
		sharB.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if(ResaultPath!="")
				{
					sharingIntent = new Intent(Intent.ACTION_SEND);
					Uri screenshotUri = Uri.parse(ResaultPath);
					sharingIntent.setType("image/jpg");
					sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
					startActivity(Intent.createChooser(sharingIntent, "متنی  را که نوشتید اشتراک بگزارید(عکس"));
					//share(ResaultPath);
				}
			}
		});



		Button change_color=(Button)findViewById(R.id.color_c_b);
		change_color.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				RainbowPickerDialog di=new RainbowPickerDialog(Editor.this);
				di.show();
			}
		});







		Button pifg=(Button)findViewById(R.id.gallery_picer);
		pifg.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});


	}



	private static int RESULT_LOAD_IMAGE = 1;

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {

			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };
			Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
			cursor.moveToFirst();
			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();


			Bitmap dfdf=BitmapFactory.decodeFile(picturePath);

			Bitmap resizedBitmap = Bitmap.createScaledBitmap(dfdf, 700, 500 ,false); 


			Matrix matrix = new Matrix();

			ExifInterface exifReader = null;
			try {
				exifReader = new ExifInterface(picturePath);
			} catch (IOException e) {}

			int orientation = exifReader.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);


			if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
				matrix.postRotate(90);

			} else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {

				matrix.postRotate(180);

			} else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {

				matrix.postRotate(270);

			}else{
				//do nothing
			}

			//matrix.postRotate(45);


			Bitmap rotatedBitmap = Bitmap.createBitmap(resizedBitmap,0,0,resizedBitmap.getWidth(),resizedBitmap.getHeight(), matrix, true);
			BitmapDrawable rANDrBD=new BitmapDrawable(getResources(),rotatedBitmap);

			t.setBackground(rANDrBD);
		}


	}








	public void add_space(){
		String s=t.getText().toString(),res ="";


		StringTokenizer st=new StringTokenizer(s,"\n");
		while(st.hasMoreTokens()){
			res+="  "+st.nextToken()+"  \n";
		}

		char[] ret=new char[res.length()-1];
		for(int i=0;i<res.length()-1;i++)ret[i]=res.charAt(i);


		t.setText(ret, 0, ret.length-1);
	}



	public String shooot() throws IOException{
		//FrameLayout memecontentView = (FrameLayout) findViewById(R.id.fcsaver);

		View v =t;

		v.setDrawingCacheEnabled(true);

		v.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

		v.layout(0,0, v.getMeasuredWidth(), v.getMeasuredHeight());

		v.buildDrawingCache(true);


		Bitmap bitmap = Bitmap.createBitmap(v.getDrawingCache());

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();

		bitmap.compress(Bitmap.CompressFormat.JPEG , 100 , bytes);

		v.destroyDrawingCache();

		String rootp=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();

		File dirFolder=new File(rootp+ File.separator + "ZN_Parsi");
		dirFolder.mkdir();

		String namee=String.valueOf(System.currentTimeMillis());
		File f = new File(rootp + File.separator + "ZN_Parsi/"+namee+"_Parsi.jpg");                   
		f.createNewFile(); 


		// write the bytes in file
		FileOutputStream fo = new FileOutputStream(f);
		BufferedOutputStream bos=new BufferedOutputStream(fo);
		bos.write(bytes.toByteArray());
		bos.flush();
		fo.flush();
		bos.close();
		fo.close();


		File parent = f.getParentFile();

		ContentValues image = new ContentValues();

		image.put(Images.Media.TITLE, "Rendane_parsi");
		image.put(Images.Media.DISPLAY_NAME, "BMD");
		image.put(Images.Media.DESCRIPTION, "App Image");
		image.put(Images.Media.DATE_ADDED, System.currentTimeMillis());
		image.put(Images.Media.MIME_TYPE, "image/jpg");
		image.put(Images.Media.ORIENTATION, 0);
		image.put(Images.ImageColumns.BUCKET_ID, parent.toString().toLowerCase().hashCode());
		image.put(Images.ImageColumns.BUCKET_DISPLAY_NAME , parent.getName().toLowerCase());
		image.put(Images.Media.SIZE, f.length());
		image.put(Images.Media.DATA, f.getAbsolutePath());

		Uri result = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, image);

		galleryAddPic(f);


		Toast.makeText(getApplicationContext(),"Image Saved at " + f.getAbsolutePath() , Toast.LENGTH_LONG).show();


		return f.getAbsolutePath();

	}

	private void galleryAddPic(File f) {
		Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		Uri contentUri = Uri.fromFile(f);
		mediaScanIntent.setData(contentUri);
		this.sendBroadcast(mediaScanIntent);
	}

	public String saveMyImage(String imageName, byte[] bytess) throws IOException {

		String path1 = android.os.Environment.getExternalStorageDirectory().toString();

		File file = new File(path1 + "/" + "Rendane_parsi");
		if (!file.exists()) file.mkdirs();

		File filename = new File(file.getAbsolutePath() + "/" + imageName+ ".jpg");

		FileOutputStream out = new FileOutputStream(filename);
		BufferedOutputStream bos=new BufferedOutputStream(out);
		bos.write(bytess);
		out.flush();
		out.close();
		bos.flush();
		bos.close();

		File parent = filename.getParentFile();


		ContentValues image = new ContentValues();

		image.put(Images.Media.TITLE, "Rendane_parsi");
		image.put(Images.Media.DISPLAY_NAME, imageName);
		image.put(Images.Media.DESCRIPTION, "App Image");
		image.put(Images.Media.DATE_ADDED, System.currentTimeMillis());
		image.put(Images.Media.MIME_TYPE, "image/jpg");
		image.put(Images.Media.ORIENTATION, 0);
		image.put(Images.ImageColumns.BUCKET_ID, parent.toString().toLowerCase().hashCode());
		image.put(Images.ImageColumns.BUCKET_DISPLAY_NAME , parent.getName().toLowerCase());
		image.put(Images.Media.SIZE, filename.length());
		image.put(Images.Media.DATA, filename.getAbsolutePath());

		Uri result = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, image);

		Toast.makeText(getApplicationContext(),"File is Saved in  " + filename, Toast.LENGTH_LONG).show();


		return filename.getAbsolutePath().toString();
	}

	public void share(String path){
		Intent sharingIntent = new Intent(Intent.ACTION_SEND);
		Uri screenshotUri = Uri.parse(path);
		sharingIntent.setType("image/jpg");
		sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
		startActivity(Intent.createChooser(sharingIntent, "متن تاپیپ شده اماده اشترام به صورت عکس است"));
	}





	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



	public class MyAdapter extends ArrayAdapter<String> {

		public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {
			super(ctx, txtViewResourceId, objects);
		}

		@Override
		public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
			return getCustomView(position, cnvtView, prnt);
		}

		@Override
		public View getView(int pos, View cnvtView, ViewGroup prnt) {
			return getCustomView(pos, cnvtView, prnt);
		}

		public View getCustomView(int position, View convertView , ViewGroup parent) {

			LayoutInflater inflater = getLayoutInflater();
			View mySpinner = inflater.inflate(R.layout.custom_spiner, parent,false);

			TextView main_text = (TextView) mySpinner.findViewById(R.id.text_main_seen);
			main_text.setText(spinnerValues[position]);
			main_text.setTypeface(f[position]);
			main_text.setTextColor(Color.RED);
			return mySpinner;
		}
	}






	class RainbowPickerAdapter extends BaseAdapter {

		Context context;
		List<Integer> colorList = new ArrayList<Integer>();
		int colorGridColumnWidth;

		public RainbowPickerAdapter(Context context) {

			this.context = context;

			// defines the width of each color square
			colorGridColumnWidth = context.getResources().getInteger(R.integer.colorGridColumnWidth);

			int colorCount = 96;
			int step = 256 / (colorCount / 6);
			int red = 0, green = 0, blue = 0;

			// FF 00 00 --> FF FF 00
			for (red = 255, green = 0, blue = 0; green <= 255; green += step)
				colorList.add(Color.rgb(red, green, blue));

			// FF FF 00 --> 00 FF 00
			for (red = 255, green = 255, blue = 0; red >= 0; red -= step)
				colorList.add(Color.rgb(red, green, blue));

			// 00 FF 00 --> 00 FF FF
			for (red = 0, green = 255, blue = 0; blue <= 255; blue += step)
				colorList.add(Color.rgb(red, green, blue));

			// 00 FF FF -- > 00 00 FF
			for (red = 0, green = 255, blue = 255; green >= 0; green -= step)
				colorList.add(Color.rgb(red, green, blue));

			// 00 00 FF --> FF 00 FF
			for (red = 0, green = 0, blue = 255; red <= 255; red += step)
				colorList.add(Color.rgb(red, green, blue));

			// FF 00 FF -- > FF 00 00
			for (red = 255, green = 0, blue = 255; blue >= 0; blue -= 256 / step)
				colorList.add(Color.rgb(red, green, blue));

			// add gray colors
			for (int i = 255; i >= 0; i -= 11) {
				colorList.add(Color.rgb(i, i, i));
			}
		}


		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;

			// can we reuse a view?
			if (convertView == null) {
				imageView = new ImageView(context);
				// set the width of each color square
				imageView.setLayoutParams(new GridView.LayoutParams(colorGridColumnWidth, colorGridColumnWidth));

			} else {
				imageView = (ImageView) convertView;
			}

			imageView.setBackgroundColor(colorList.get(position));
			imageView.setId(position);

			return imageView;

		}

		public int getCount() {
			return colorList.size();
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return position;
		}

	}



	class RainbowPickerDialog extends Dialog {

		public RainbowPickerDialog(Context context) {
			super(context);
			this.setTitle("چه رنگی را می پسندید؟");
		}


		RainbowPickerAdapter rpa;

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.color_picker);

			GridView gridViewColors = (GridView) findViewById(R.id.gridViewColors);
			rpa=new RainbowPickerAdapter(getContext());
			gridViewColors.setAdapter(rpa);



			gridViewColors.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

					t.setTextColor(rpa.colorList.get(position));
					RainbowPickerDialog.this.dismiss();
				}
			});


		}
	}


}


