package com.bopbi.model;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bopbi.R;

public class LocationAdapter extends ArrayAdapter<LocationModel> {

	int resource;
	String response;
    Context context;
    private LayoutInflater mInflater;
    
	public LocationAdapter(Context context, int resource, List<LocationModel> objects) {
		super(context, resource, objects);
		this.resource = resource;
		mInflater = LayoutInflater.from(context);
	}
	
	static class ViewHolder {
		TextView title;
		TextView description;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
    {
		ViewHolder holder;
        //Get the current location object
        LocationModel lm = (LocationModel) getItem(position);
 
        //Inflate the view
        if(convertView==null)
        {
            convertView = mInflater.inflate(R.layout.item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView
					.findViewById(R.id.it_location_title);
			holder.description = (TextView) convertView
					.findViewById(R.id.it_location_description);

			convertView.setTag(holder);   
            
        }
        else
        {
        	holder = (ViewHolder) convertView.getTag();
        }
        
        holder.title.setText(lm.getName());
		holder.description.setText(lm.getDescription());

		return convertView;
    }

}
