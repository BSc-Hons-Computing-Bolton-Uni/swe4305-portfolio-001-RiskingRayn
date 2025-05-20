package PlaylistAppFallback;
import java.util.*;
// the menu is the only thing that the user will see. it is the frunt end of this
// program. this means that it contains allot of error mitigation in the form of try cach
// statments.
// this class contains menues that the user can select a value and then error checking on that input

public class Menu {
    ArrayList<Playlist> playlists = new ArrayList<Playlist>();

    ArrayList<Song> songs = new ArrayList<Song>();
    // check_ans_string checks the ans to see if it in a given array.
    // if it is not it asks the user to reenter a valid responce.
    // this function will itarate itself until a valid anser is enterd

    public Menu()
    {
        Song s1= new Song ("KillV.Maim", 4.06F, 124471295, "Grimes");
        Song s2= new Song ("take it", 3.11F, 582227427, "Cafune");
        Song s3= new Song ("Freaks", 2.27F, 1416688779, "Surf Curse");
        Song s4= new Song ("Disco", 2.32F, 384414675, "Surf Curse");
        Song s5= new Song ("Natural", 3.09F, 1399701143, "Imagine Dragons");
        Song s6= new Song ("Bones", 3.07F, 1539848587, "Imagin Dragons");
        Song s7= new Song ("Take me to the Beach", 2.47F, 56287319, "Imagin Dragons");
        this.songs.add(s1);
        this.songs.add(s2);
        this.songs.add(s3);
        this.songs.add(s4);
        this.songs.add(s5);
        this.songs.add(s6);
        this.songs.add(s7);
        Playlist playlist = new Playlist("playlist1");
        playlist.add_song(s1);
        playlist.add_song(s2);
        playlist.add_song(s3);
        playlist.add_song(s4);
        playlist.add_song(s5);
        playlist.add_song(s6);
        playlist.add_song(s7);
        this.playlists.add(playlist);

    }

    // -------------------------------------------------------------------------------------- reed this---------------------------------------------
    // future me you have a problem
    // at the moment you are constantly ittrating back to main menu
    // this means that every time you return to the main menu all the prossesses are still loaded in the background
    // you need to fix this.
    // for a ram reduction fix in the future. ask andrew pas me has no idea how to fix this one.
    // thanks future me
    private void reset_to_main() {
        main_menu();
    }

    private String check_ans_string(ArrayList<String> valid) {

        String ans = get_ans_string();

        if (!valid.contains(ans)) {
            System.out.println("You need to enter one of the valid options listed above. ");
            ans = check_ans_string(valid);
        }
        return ans;
    }


    // -----------------------------------------------------------------------------------|all user inputs|-------------------------------------------------------------------
    // get_ans_string gets a string anser from the user.
    // it error checks this to make sure that a string is input in the unlikley event that it is not.
    // this function will itarate itself until a valid anser is enterd
    private String get_ans_string() {
        Scanner scanner = new Scanner(System.in);
        String ans = "";
        try {
            ans = scanner.next();

        } catch (Exception e) {
            System.out.println("please enter enter a valid value");
            ans = get_ans_string();
        }
        if (ans.equals("")) {
            System.out.println("you must enter a something");
            ans = get_ans_string();
        }
        return ans;
    }

    // get_ans_float dose the same thing as get_ans_string but with a float insted
    private float get_ans_float() {
        Scanner scanner = new Scanner(System.in);
        float ans = -1;
        try {
            ans = scanner.nextFloat();

        } catch (Exception e) {
            System.out.println("please enter enter a valid value");
            ans = get_ans_float();
        }
        if (!(ans >= 0)) {
            System.out.println("you must enter a valid play count");
            ans = get_ans_float();
        }
        return ans;
    }

    // get_ans_float dose the same thing as get_ans_string but with an int insted
    private int get_ans_int() {
        Scanner scanner = new Scanner(System.in);
        int ans = -1;
        try {
            ans = scanner.nextInt();

        } catch (Exception e) {
            System.out.println("please enter enter a valid value");
            ans = get_ans_int();
        }
        if (!(ans >= 0)) {
            System.out.println("you must enter a valid play count");
            ans = get_ans_int();
        }
        return ans;
    }

    //----------------------------------------------------------------------------------------|the main menu|------------------------------------------------------------------------
    // the main maenue is the starting point for the program as far as the user is conserned.
    // it allows the user to pick between the functions of the program.
    // allowing the branching off to every other menue.
    // when any prossess ends the user will be sent back here.
    public void main_menu() {
        ArrayList<String> valid = new ArrayList<String>();
        valid.add("1");
        valid.add("2");
        valid.add("3");
        valid.add("4");
        valid.add("5");

        System.out.print(
                "plese enter the option you want with the corasponding number \n" +
                        "1: Add song \n" +
                        "2: Remove song\n" +
                        "3: add new playlist\n" +
                        "4: show all songs in playlist\n" +
                        "5: show all songs above play count\n"
        );
        String ans = check_ans_string(valid);

        if (ans.equals("1")) {
            add_song_menu();
        } else if (ans.equals("2")) {
            remove_song_menu();
        } else if (ans.equals("3")) {
            add_new_playlist_menu();
        } else if (ans.equals("4")) {
            all_songs_in_playlist_menu();
        } else {
            all_songs_above_playcount_menu();
        }
    }

    // ------------------------------------------------------------------------------------------|branch menus|-----------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------|Add Menus|
    // add_song_menu gives the user three options and calls the appropriat menues depending on whitch
    // option the user picks.
    // it calls check_ans_string to check the andser.
    private void add_song_menu() {
        ArrayList<String> valid = new ArrayList<>();
        valid.add("1");
        valid.add("2");
        valid.add("3");
        System.out.print(
                "enter the number corasponding to the answer you want \n" +
                        "1: add new song to libary \n" +
                        "2: add new song to playlist \n" +
                        "3: add exsisting song to playlist \n");
        String ans = check_ans_string(valid);
        if (ans.equals("1")) {
            add_new_song_to_libary();
        } else if (ans.equals("2")) {
            add_new_song_to_playlist();
        } else {
            add_exsisting_song_to_playlist();
        }
    }

    private void add_new_song_to_libary() {
        Song song = add_new_song_menu();
        this.songs.add(song);
        System.out.println("the song has been added to the libary\n");
        reset_to_main();
    }


    private void add_exsisting_song_to_playlist()
    {
        Song song = find_song();
        Playlist playlist = find_playlist();
        playlist.add_song(song);
        System.out.println(song.get_name() + " has been added to " + playlist.get_name() + "\n");
        reset_to_main();
    }

    private void add_new_song_to_playlist()
    {
        Song song = add_new_song_menu();
        this.songs.add(song);
        Playlist playlist = find_playlist();
        playlist.add_song(song);
        System.out.println(song.get_name() + " has been added to " + playlist.get_name() + "\n");
        reset_to_main();
    }

    private void add_new_playlist_menu()
    {
        System.out.println("Enter the name of the playlist.");
        String name = get_ans_string();
        Playlist playlist = new Playlist(name);
        this.playlists.add(playlist);
        System.out.println(name + "has been added as a playlist \n");
        reset_to_main();
    }

    //-----------------------------------------------------------------------------------------------|Remove Menus|
    public void remove_song_menu()
    {
        ArrayList<String> valid = new ArrayList<String>();
        valid.add("1");
        valid.add("2");

        System.out.print( "Enter the number of the option you want \n" +
                "1: remove song from libary \n"+
                "2: remove song from playlist \n");
        String ans = check_ans_string(valid);
        if (ans.equals("1"))
            {remove_song_from_libary();}
        else
            {remove_song_from_playlist();}
    }

    public void remove_song_from_libary()
    {
        Song song = find_song();
        this.songs.remove(song);
        System.out.println(song.get_name() + " has been removed from libary ");
        reset_to_main();
    }

    private void remove_song_from_playlist()
    {
        Playlist playlist = find_playlist();
        Song song = find_song();
        boolean was_removed = playlist.remove_song(song);
        if (was_removed)
            {System.out.println(song.get_name() + " was removed form " + playlist.get_name());}
        else
            {System.out.println(song.get_name() + "is not in " + playlist.get_name());}
        reset_to_main();
    }

//------------------------------------------------------------------------------------------------|Search Menus|

    public void all_songs_in_playlist_menu()
    {
        Playlist playlist = find_playlist();
        ArrayList<Song> playlist_songs = playlist.get_songs();
        for (Song s : playlist_songs)
        {
            s.print_all_values();
        }
        reset_to_main();
    }

    public void all_songs_above_playcount_menu()
    {
        System.out.println("Enter the playcount minimum");
        int minimum = get_ans_int();
        for(Song s : this.songs)
        {
            if (s.get_plays() > minimum)
            {
                s.print_all_values();
            }
        }
        reset_to_main();
    }

//----------------------------------------------------------------------------------------|repeated function menus|--------------------------------------------------------
    // gets all the information that is needed from the user in order to create a song.
    // then uses the data class to store the class in the xml file songs.
    // this prossess returns a song so that it can be used in other menues where a new
    // song is needed e.g. add_new_song_to_playlist.

    private Song add_new_song_menu()
    {
        System.out.println("enter the name of the song");
        String name = get_ans_string();
        System.out.println("Enter lenth of the song in the format MM.SS");
        float lenth = get_ans_float();
        System.out.println("Enter the amount of plays the song has");
        int plays = get_ans_int();
        System.out.println("Enter the name of the artist");
        String artist = get_ans_string();
        Song s = new Song(name, lenth, plays, artist);
        return s;
    }
    // most of the function for this prossess hapens in the data class.
    // in get playlist_names, store_song, add song to playlist and seve playlist


    // i wrote this 5 minits ago and i have no idea how i have pulld this one off but it should work.
    // sorry future me
    private Song find_song()
    {
        System.out.println("enter the name of the song you are looking for");
        String name = get_ans_string();
        Song song = new Song(true);
        for (Song s : this.songs)
        {
            if (s.get_name().equals(name))
            {
                song = s;
            }
        }
        if (song.check_none())
        {
            System.out.println("this song dose not exist");
            reset_to_main();
        }
        return song;
    }

    private Playlist find_playlist()
    {
        System.out.println("Enter the name of the playlist you want");
        String name = get_ans_string();
        Playlist playlist = new Playlist(true);
        for (Playlist p : this.playlists)
        {
            if (p.get_name().equals(name))
            {
                playlist = p;
            }
        }
        if (playlist.check_none())
        {
            System.out.println("that playlist dose not exist");
            reset_to_main();
        }
        return playlist;
    }




}