package PlalistApp;

import java.util.ArrayList;




public class Playlist {
    private int song_count;
    private String name;
    private int id;
    private float lenght;
    private ArrayList<Song> songs = new ArrayList<Song>();

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
        make_id();
    }

    public String get_name()
    {
        return this.name;
    }

    public void print_defanition_values()
    {
        System.out.println("name: " + this.name);
        System.out.println("length: " + this.lenght);
        System.out.println("song count: " + this.song_count);
    }

    private void make_id()
    {

    }

    public void set_none()
    {
        this.id = -1;
    }

    public boolean check_none()
    {
        if (this.id == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
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
