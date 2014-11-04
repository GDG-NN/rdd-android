package lv.rigadevday.android.ui.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import lv.rigadevday.android.R;
import lv.rigadevday.android.application.navigation.NavigationOption;
import lv.rigadevday.android.application.navigation.NavigationService;
import lv.rigadevday.android.common.StringService;
import lv.rigadevday.android.common.TypefaceCache;
import lv.rigadevday.android.common.ViewHolder;

public class NavigationAdapter extends ArrayAdapter<NavigationOption> {

    StringService stringService;

    @Inject
    TypefaceCache typefaceCache;

    @Inject
    public NavigationAdapter(Context context, NavigationService service, StringService stringService) {
        super(context, 0, service.getDrawerNavigationOptions());
        this.stringService = stringService;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.navigation_item, parent, false);
        }

        NavigationOption option = getItem(position);

        TextView title = ViewHolder.get(convertView, R.id.navigation_title);
        title.setText(stringService.loadString(option.getTitle()));
        title.setTypeface(typefaceCache.loadFromAsset("fonts/Roboto-Regular.ttf"));

        ImageView icon = ViewHolder.get(convertView, R.id.navigation_icon);
        icon.setImageDrawable(getContext().getResources().getDrawable(option.getImage()));

        return convertView;
    }
}
