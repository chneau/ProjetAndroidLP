package fr.iut.licence.projetandroid;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.iut.licence.projetandroid.entities.Constantes;
import fr.iut.licence.projetandroid.entities.Plot;
import fr.iut.licence.projetandroid.entities.ViewHolder;

public class PlotArrayAdapter extends BaseAdapter{
	private final Context mContext;
	private final List<Plot> mValues;
	private int type; 
	
	public PlotArrayAdapter(Context context,List<Plot> plots, int typeAffich) {
		mContext = context;
		mValues = plots;	
		type = typeAffich;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = LayoutInflater .from(mContext).inflate(R.layout.list_plot, parent, false);

			holder = new ViewHolder ();
			holder.plotName= (TextView) convertView.findViewById(R.id.tv_plot);
			holder.plotType = (TextView) convertView.findViewById(R.id.tv_type);
			//Store the holder with the view.
			convertView.setTag(holder);
		} else {
			// Else re-assign
			holder = (ViewHolder) convertView.getTag();
		}
		Plot p = mValues.get(position);

		holder.plotName.setText(p.getName());
		switch(type){
		  case Constantes.TYPE_SURFACE :
			holder.plotType.setText(String.valueOf(p.getSurface()));
			break;
		  case Constantes.TYPE_SEMANCE:
			holder.plotType.setText(p.getGrowing());
			break;
		  default:
		    holder.plotType.setText(p.getGrowing());break;

		}
		
		return convertView;
	}

	@Override
	public int getCount() {
		return mValues.size();
	}

	@Override
	public Object getItem(int arg0) {
		return mValues.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return Long.parseLong(mValues.get(arg0).getId());
	}


}
