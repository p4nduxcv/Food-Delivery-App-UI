package com.example.assignmentdmsl;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    //Arrays for declare constant values
    Context context;
    String[] titleList;
    String[] titleDescription;
    int[] imageList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowName;
        TextView rowDescription;
        ImageView rowImages;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView1);
            rowDescription = itemView.findViewById(R.id.textView2);
            rowImages = itemView.findViewById(R.id.imageView);
        }
    }

    public ProgramAdapter(Context context,String[] titleList,String[]titleDescription, int[] imageList ){
        this.context = context;
        this.titleList = titleList;
        this.titleDescription = titleDescription;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
    holder.rowName.setText(titleList[position]);
    holder.rowDescription.setText(titleDescription[position]);
    holder.rowImages.setImageResource(imageList[position]);
    }

    @Override
    public int getItemCount() {
        return titleList.length;
    }
}
