package ru.rmp.moodnotes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.rmp.moodnotes.R;
import ru.rmp.moodnotes.models.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Note> notes;

    public NoteAdapter(Context context, List<Note> notes) {
        this.notes = notes;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.creationDate.setText(note.getCreationDate().toString());
        holder.content.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView creationDate;
        final TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            creationDate = itemView.findViewById(R.id.note_item_datetime);
            content = itemView.findViewById(R.id.note_item_content);
        }
    }
}
