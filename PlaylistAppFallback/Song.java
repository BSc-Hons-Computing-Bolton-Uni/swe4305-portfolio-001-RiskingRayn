package PlaylistAppFallback;

public class Song
{
    private String name;
    private float lenghth;
    private int plays;
    private boolean is_none;
    private String artist_name;

    // alt constructer+
    // this constructer is for the purpous of defining an empty song
    // allowing it to be defined at a later time.
    public Song(boolean set_none) {
        if (set_none) {
            set_none();
        }
    }

    // main constructer.
    public Song(String name, float lenghth, int plays, String artist_name)
    {
        this.name  = name;
        this.lenghth = lenghth;
        this.plays = plays;
        this.artist_name = artist_name;
    }

    // getters
    public String get_name()
    {return this.name;}
    public float get_lenghth()
    {return this.lenghth;}
    public int get_plays()
    {return this.plays;}
    public String get_artist_name()
    {return this.artist_name;}

    // setters
    public void set_name(String name)
    {this.name = name;}
    public void set_plays(int plays)
    {this.plays = plays;}

    // play incromenter.
    public void add_play()
    {this.plays +=1;}

    public void print_all_values()
    {
        System.out.print(
                "name: " + this.name + "\n" +
                        "artist: " + this.artist_name + "\n" +
                        "length: " + this.lenghth + "\n" +
                        "play count: " + this.plays + "\n"
        );
    }
    // sets the song to no song
    public void set_none()
    {
        this.is_none = true;
    }

    // checks the song if it is a non song
    public boolean check_none()
    {
        return this.is_none;
    }
}
