package PlalistApp;

public class Song
{
    private String name;
    private float lenghth;
    private int plays;
    private  int id;
    private String artist_name;

     // constructer+
    public Song(boolean set_none)
    {
        if (set_none)
        {
            set_none();
        }
    }

    public Song(String name, float lenghth, int plays, String artist_name)
    {
        this.name  = name;
        this.lenghth = lenghth;
        this.plays = plays;
        this.artist_name = artist_name;
        this.id = make_id();
    }

    // getters
    public String get_name()
        {return this.name;}
    public float get_lenghth()
        {return this.lenghth;}
    public int get_plays()
        {return this.plays;}
    public int get_id()
        {return this.id;}
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
                "play count: " + this.plays
                );
    }

    public void set_none()
    {
        this.id = -1;
    }

    public boolean check_none()
    {
        if(this.id == -1) {
            return true;
        }
        else
            return false;
    }

    private int make_id()
    {
        return 1;
    }
}
