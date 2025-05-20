package PlaylistAppFallback;

import java.util.ArrayList;




public class Playlist {
    private int song_count;
    private String name;
    private float lenght;
    private ArrayList<Song> songs = new ArrayList<Song>();
    private boolean is_none;

    // constructer.

    public Playlist(boolean set_none)
    {
        if (set_none)
        {
            set_none();
        }
    }

    public Playlist(String name)
    {
        this.song_count = 0;
        this.name = name;
        this.lenght = 0;
        this.is_none = false;
    }

    // Getters (>_<)
    public String get_name()
        {return this.name;}
    public String get_lenght()
        {return String.valueOf(this.lenght);}
    public String get_song_count()
        {return String.valueOf(this.song_count);}
    public ArrayList<Song> get_songs()
        {return this.songs;}
    //Setters (◔_◔)
    public void set_name(String name)
        {this.name = name;}
    public void set_song_count(int song_count)
        {this.song_count = song_count;}
    public void set_lenght(int lenght)
        {this.lenght = lenght;}
    public void add_song(Song s)
        {
            this.songs.add(s);
            increment_song_count();
            add_to_lenght(s.get_lenghth());
        }


    public boolean remove_song(Song song)
    {
        boolean song_exists = false;
        for (Song s : this.songs)
        {
            if (s.get_name().equals(song.get_name()))
            {
                this.songs.remove(s);
                song_exists = true;
            }
        }
        return song_exists;
    }

    public void print_defanition_values()
    {
        System.out.println("name: " + this.name);
        System.out.println("length: " + this.lenght);
        System.out.println("song count: " + this.song_count);
    }

    public void set_none()
    {
        this.is_none = true;
    }

    public boolean check_none()
    {
        return this.is_none;
    }

    public void increment_song_count()
    {
        this.song_count+=1;
    }

    public void add_to_lenght(float song_len)
    {
        this.lenght+=song_len;
    }

}
