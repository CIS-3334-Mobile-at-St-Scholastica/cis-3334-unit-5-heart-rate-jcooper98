package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Tom Gibbons in Feb 2017.
 * For the CIS 3334 class at St. Scholastica
 */

public class HeartRateAdapter  extends ArrayAdapter<HeartRate> {

    private final Context context;      // The activity calling this adapter
    private HeartRateList hrList;       // The object holding the arraylist of hear rates
    TextView textViewRangeName;
    TextView textViewDescription;

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;

    }

    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        textViewRangeName = (TextView) view.findViewById(R.id.textViewRangeName);
        TextView tvPulse=(TextView)view.findViewById(R.id.textViewPulse);
        textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);

        tvPulse.setText(hr.getPulse().toString());
        textViewRangeName.setText(hr.getRangeName());
        textViewDescription.setText(hr.getRangeDescrtiption());



        // Not quite sure on what the range returns. This is what gave me the most variety for color in the app.
        if (hr.getRange() == 3)
        {
            textViewRangeName.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        }
        else if (hr.getRange() == 2)
        {
            textViewRangeName.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        }
        else if (hr.getRange() == 1)
        {
            textViewRangeName.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        }




        return(view);
    }

}