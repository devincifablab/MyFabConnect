package fablab.devinci.myfabconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ken on 22/07/2017.
 */

public class CustomAdapterProject extends BaseAdapter {

    private List<Project.ItemsBean> mProjectItem;
    private Context mContext;
    private LayoutInflater inflater;

    public CustomAdapterProject(Context mContext, List<Project.ItemsBean> mProjectItem)
    {
        this.mContext = mContext;
        this.mProjectItem = mProjectItem;
    }

    @Override
    public int getCount() {
        return mProjectItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mProjectItem.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    View.OnClickListener myButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            View parentRow = (View) view.getParent();
            ListView listview = (ListView) parentRow.getParent();
            final int position = listview.getPositionForView(parentRow);

        }
    };

    View.OnClickListener voiceButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (Integer) view.getTag();
        }
    };


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_project, parent, false);

        Project.ItemsBean item = (Project.ItemsBean) getItem(position);
        TextView title = (TextView) rowView.findViewById(R.id.project_title);
        TextView type = (TextView) rowView.findViewById(R.id.project_type);
        TextView datecrea = (TextView) rowView.findViewById(R.id.project_datecreation);

        title.setText(item.getTitle());
        type.setText(item.getType());
        datecrea.setText(item.getDatecreated());



        return rowView;
    }
}
