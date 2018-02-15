package com.patrickpu.test.playwithui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by patrickpu on 2/15/2018.
 */

public class ContactAdpater extends ArrayAdapter<Contact> {
    public ContactAdpater(@NonNull Context context, int resource) {
        super(context, resource);
    }

    private ViewHolder viewHolder = new ViewHolder();

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact contact = DataService.getInstance().getContacts().get(position);

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.contact_row, parent, false);
            viewHolder.nameView = convertView.findViewById(R.id.contact_name);
            viewHolder.ageView = convertView.findViewById(R.id.contact_age);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.nameView.setText(contact.getName());
        viewHolder.ageView.setText(String.valueOf(contact.getAge()));

        return convertView;
    }

    @Override
    public int getCount() {
        return DataService.getInstance().getContacts().size();
    }

    private class ViewHolder{
        TextView nameView;
        TextView ageView;
    }

}
