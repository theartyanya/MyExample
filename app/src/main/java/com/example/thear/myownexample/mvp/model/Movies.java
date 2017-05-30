package com.example.thear.myownexample.mvp.model;

import com.example.thear.myownexample.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Movies {
    private static HashMap<String, ArrayList<Movie>> map = new HashMap<>();

    public static HashMap<String, ArrayList<Movie>> getMovies() {
        if (map.isEmpty())
            fillMap();
        return map;
    }

    private static void fillMap() {
        Movie movie = new Movie(R.drawable.mad_max, "Mad Max: Fury Road", "Action", "2015");
        map.put("Action", new ArrayList<Movie>());
        map.get("Action").add(movie);

        movie = new Movie(R.drawable.star_wars, "Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        map.get("Action").add(movie);

        movie = new Movie(R.drawable.iron_man, "Iron Man", "Action", "2008");
        map.get("Action").add(movie);

        movie = new Movie(R.drawable.mission_impossible, "Mission: Impossible Rogue Nation", "Action", "2015");
        map.get("Action").add(movie);

        movie = new Movie(R.drawable.inside_out, "Inside Out", "Animation", "2015");
        map.put("Animation", new ArrayList<Movie>());
        map.get("Animation").add(movie);

        movie = new Movie(R.drawable.up, "Up", "Animation", "2009");
        map.get("Animation").add(movie);

        movie = new Movie(R.drawable.martian, "The Martian", "Science Fiction", "2015");
        map.put("Science Fiction", new ArrayList<Movie>());
        map.get("Science Fiction").add(movie);

        movie = new Movie(R.drawable.guardians, "Guardians of the Galaxy", "Science Fiction", "2014");
        map.get("Science Fiction").add(movie);

        movie = new Movie(R.drawable.back_to_the_future, "Back to the Future", "Science Fiction", "1985");
        map.get("Science Fiction").add(movie);

        movie = new Movie(R.drawable.aliens, "Aliens", "Science Fiction", "1986");
        map.get("Science Fiction").add(movie);

        movie = new Movie(R.drawable.star_trek, "Star Trek", "Science Fiction", "2009");
        map.get("Science Fiction").add(movie);
    }
}
