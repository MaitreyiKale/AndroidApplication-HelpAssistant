package com.example.project.UserFacilityNotes;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.UserActivity;
import com.example.project.UserNotesDatabaseHelper;

import java.util.ArrayList;

public class UserNoteAdapter extends RecyclerView.Adapter<UserNoteAdapter.ViewHolder> {

    ArrayList<String> noteAll;
    public UserNoteAdapter(ArrayList<String> disp) {
        noteAll=disp;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_recycler_view,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //final ArrayList<String> noteA=new ArrayList<>();
        //noteA.add(noteAll.toString());
        holder.noteView.setText((CharSequence) noteAll.get(position));
        //holder.deleteView.setText(noteA.get(position));
        holder.deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n[]=new String[50];
                int index=0;
                for (String a:noteAll) {
                    n[index]=a;
                    index++;
                }
                int g=0;
                for (String u:noteAll)  {
                    Intent intent=new Intent(view.getContext(), UserActivity.class);
                    intent.setData(Uri.parse(n[g]));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    UserNotesDatabaseHelper user=new UserNotesDatabaseHelper(view.getContext());
                    user.deleteNote(u);
                    g++;
                    view.getContext().startActivity(intent);

                }



            }
        });
    }

    @Override
    public int getItemCount() {
        return noteAll.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView noteView;
        public TextView deleteView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteView=(itemView).findViewById(R.id.noteView);
            deleteView=(itemView).findViewById(R.id.deleteView);
        }
    }
}
