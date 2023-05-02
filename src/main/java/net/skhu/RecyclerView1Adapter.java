package net.skhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView1Adapter extends RecyclerView.Adapter<RecyclerView1Adapter.ViewHolder> {
    // adapter data 항목에 대한 view를 만들어 주는 역할을 한다.
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<String> arrayList;

    public RecyclerView1Adapter(Context context, ArrayList<String> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    // on : ~할때 자동으로 호출
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Data 항목을 담을 view
        View view = layoutInflater.inflate(R.layout.memo1, viewGroup, false);

        // Inflater layout에 있는 대로 view를 만들어준다.
        return new ViewHolder(view);
    }

    // viewHolder 에 data를 바인드 할 때 사용
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.textView.setText(arrayList.get(index));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
