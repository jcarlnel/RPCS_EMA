package rpcs.jacob.ema.Util;

/**
 * Created by jacobnelson on 4/4/16.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import rpcs.jacob.ema.R;

public class ListViewAdapter extends ArrayAdapter<Model>{
        Model[] modelItems = null;
        Context context;
public ListViewAdapter(Context context, Model[] resource) {
        super(context, R.layout.checkboxrow,resource);
        this.context = context;
        this.modelItems = resource;
        }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.checkboxrow, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        name.setText(modelItems[position].getName());
        if(modelItems[position].getValue() == 1)
        cb.setChecked(true);
        else
        cb.setChecked(false);
        return convertView;
        }
        }
