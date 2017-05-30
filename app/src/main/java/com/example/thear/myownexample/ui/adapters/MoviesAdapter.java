package com.example.thear.myownexample.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thear.myownexample.R;
import com.example.thear.myownexample.mvp.model.Movie;

import java.util.ArrayList;
import java.util.HashMap;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private HashMap<String, ArrayList<Movie>> movies;
    private ArrayList<Movie> movieList = new ArrayList<>();

    public MoviesAdapter(HashMap<String, ArrayList<Movie>> movies) {
        this.movies = movies;
        mapToList();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            default:
            case 0:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_header_view, parent, false);
                return new HeaderViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_list_row, parent, false);
                return new MyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        if (movie.getCover() == null) {
            ((HeaderViewHolder) holder).header.setText(movie.getGenre());
        } else {
            ((MyViewHolder) holder).cover.setImageResource(movie.getCover());
            ((MyViewHolder) holder).title.setText(movie.getTitle());
            ((MyViewHolder) holder).genre.setText(movie.getGenre());
            ((MyViewHolder) holder).year.setText(movie.getYear());
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, genre, year;
        ImageView cover;
        MyViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.image_view);
            title = (TextView) itemView.findViewById(R.id.title);
            genre = (TextView) itemView.findViewById(R.id.genre);
            year = (TextView) itemView.findViewById(R.id.year);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), title.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView header;
        HeaderViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.header_text_view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (movieList.get(position).getCover() == null)
            return 0;
        else
            return 1;
    }

    private void mapToList() {
        for (String key : movies.keySet()) {
            movieList.add(new Movie(null, null, key, null));
            for (Movie movie : movies.get(key)) {
                movieList.add(movie);
            }
        }
    }
}
