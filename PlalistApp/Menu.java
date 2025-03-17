package PlalistApp;

import java.util.ArrayList;
import java.util.Scanner;
        // the menu is the only thing that the user will see. it is the frunt end of this
        // program. this means that it contains allot of error mitigation in the form of try cach
        // statments.
        // this class contains menues that the user can select a value and then error checking on that input

public class Menu {
    Data data;
    // check_ans_string checks the ans to see if it in a given array.
    // if it is not it asks the user to reenter a valid responce.
    // this function will itarate itself until a valid anser is enterd

    public Menu() {
        this.data = new Data();
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
        add_new_song_menu();
        System.out.println("your song is now added");
        reset_to_main();
    }


    private void add_exsisting_song_to_playlist() {
        Song song = find_song();
        if (song.check_none()) {
            reset_to_main();
        }

        Playlist playlist = find_playlist();
        if (playlist.check_none()) {
            reset_to_main();
        }
        this.data.add_song_to_playlist(playlist, song);
        reset_to_main();

    }

    private void add_new_song_to_playlist() {
        Song song = add_new_song_menu();
        Playlist playlist = find_playlist();
        if (playlist.check_none()) {
            reset_to_main();
        }
        if (song.check_none()) {
            reset_to_main();
        }

        this.data.add_song_to_playlist(playlist, song);
        System.out.println("the song is now added to " + playlist.get_name());
        reset_to_main();
    }

    private void add_new_playlist_menu()
    {
        System.out.println("Please enter the name of the playlist you wish to add");
        String playlist_name = get_ans_string();
        Playlist playlist = new Playlist(playlist_name);
        this.data.store_new_playlist(playlist);
        System.out.println("new playlist " + playlist_name+ "has been added");
        reset_to_main();
    }

//-----------------------------------------------------------------------------------------------|Remove Menus|
    public void remove_song_menu()
    {
        System.out.print(
                "Please enter the number corasponding with the option you want.\n"+
                "1: remove song from playlist\n" +
                "2: remove song from libary\n");
        ArrayList<String> valid = new ArrayList<String>();
        valid.add("1");
        valid.add("2");
        String ans = check_ans_string(valid);
        if (ans.equals("1"))
        {
            remove_song_from_playlist();
        }
        else
        {remove_song_from_libary();}
    }

    private void remove_song_from_playlist()
    {
        Song song = find_song();
        Playlist playlist = find_playlist();
        this.data.remove_song_from_playlist(song, playlist);
        System.out.println("the song has been removed");
        reset_to_main();

    }

    private void remove_song_from_libary()
    {
        Song song = find_song();
        this.data.remove_song_form_libary(song);
        System.out.println("The song has been removed");
        reset_to_main();
    }

//------------------------------------------------------------------------------------------------|Search Menus|

    public void all_songs_in_playlist_menu()
    {
        Playlist playlis = find_playlist();
        ArrayList<Integer> song_ids = playlis.get_song_ids();
        ArrayList<Song> songs = this.data.get_songs(song_ids);
        if (!songs.isEmpty())
        {
            for(Song s: songs)
            {
                s.print_all_values();
            }
        }
        else
        {
            System.out.println("there is no songs in this playlist at this point.");
        }
        reset_to_main();
    }

    public void all_songs_above_playcount_menu()
    {
        System.out.println("Please enter a minimum play count");
        int ans = get_ans_int();
        ArrayList<Song> songs = data.get_songs_above_play_count(ans);
        if (!songs.isEmpty())
        {
            for(Song s : songs)
            {
                s.print_all_values();
            }
        }
        else
        {
            System.out.println("there are no songs above a play count of " + ans);
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
        System.out.println("plese enter the name of the song you wish to add");
        String song_name = get_ans_string();
        System.out.println("plese enter the name of the artist");
        String artist_name = get_ans_string();
        System.out.println("please enter the play count of the song");
        int play_count = get_ans_int();
        System.out.println("please enter the lenght of the song");
        float lenght = get_ans_float();

        Song song = new Song(song_name,lenght ,play_count,artist_name);
        this.data.store_new_song(song);
        return song;
    }
        // most of the function for this prossess hapens in the data class.
        // in get playlist_names, store_song, add song to playlist and seve playlist


        // i wrote this 5 minits ago and i have no idea how i have pulld this one off but it should work.
        // sorry future me
    private Song find_song()
    {
        System.out.println("please enter the name of the song you are looking for.");
        Song song = new Song(true);
        String ans = get_ans_string();
        ArrayList<Song> songs = this.data.find_song_with_name();

        if (songs.isEmpty()) // if there is no song
        {
            System.out.println("there is no such song");
            System.out.println("you will need to add the song first.");
            song.set_none();

        }
        else if (songs.size() < 2) // if there is only one song
        {
            System.out.println("is this the song you are looking for");
            for (Song s : songs) {
                s.print_all_values();
            }
            ArrayList<String> valid = new ArrayList<String>();
            valid.add("y");
            valid.add("Y");
            valid.add("n");
            valid.add("N");
            System.out.println("is the song you are looking for. enter y for yes and n for no.");
            System.out.println("if this is not the song you are looking for it is not in the song libary.");
            String song_ans = check_ans_string(valid);
            if (song_ans.toLowerCase().equals("y")) {
                song = songs.get(0);
            } else {

                song.set_none();
            }

        }
        else // if there is more than one song with the same name.
        {
            System.out.println("Please select the number corrasponding to the song you are looking for");
            System.out.println("if the song you are looking for is not here plaes enter: 0");
            int count = 0;
            for (Song s: songs)
            {
                count +=1;
                System.out.println(count + ": ");
                s.print_all_values();
            }
            ArrayList<String> valid = new ArrayList<String>();
            for (int i = 1; i <= count; i+=1 )
            {
                valid.add(String.valueOf(i));
            }
            valid.add("0");
            String song_ans = check_ans_string(valid);
            if (!song_ans.equals("0"))
                song = songs.get(Integer.valueOf(ans)-1);
            else
            {
                System.out.println("the song is not in the libary.");
                System.out.println("you will need to add the song first.");
                song.set_none();
            }
        }
        return song;
    }

    private Playlist find_playlist()
    {
        Playlist playlist = new Playlist(true);
        System.out.println("Please enter number coraspnding with the playlist you are looking for ");
        ArrayList<Playlist> playlists = this.data.get_all_playlists();
        if (playlists.isEmpty()) // if there is no playlist
        {
            System.out.println("you have no playlists yet you need to create a playlist first.");
            reset_to_main();
        }
        else if(playlists.size() < 2) // if there is only one playlist
        {
            System.out.println("is this the playlist you are looking for");
            System.out.println("enter y for Yes and n for No");
            Playlist temp = playlists.get(0);
            temp.print_defanition_values();
            ArrayList<String> valid = new ArrayList<String>();
            valid.add("y");
            valid.add("Y");
            valid.add("n");
            valid.add("N");
            String ans = check_ans_string(valid);
            if (ans.toLowerCase().equals("y"))
            {
                playlist = playlists.get(0);
            }
            else
            {
                System.out.println("you need to make a new playlist first");
            }
        }
        else // if there is moltipul playlists.
        {
            System.out.println("plses enter the number corasponding with the playlist you are looking for.");
            System.out.println("or enter 0 if the song you are looking for is not here");
            int count = 0;
            for (Playlist p : playlists)
            {
                count+=1;
                System.out.println(count);
                p.print_defanition_values();
            }
            ArrayList<String> valid = new ArrayList<String>();
            for(int i = 1; i<=count; i+=1)
            {
                valid.add(String.valueOf(i));
            }
            valid.add("0");
            String playlist_ans = check_ans_string(valid);
            if (!playlist_ans.equals("0"))
            {
                playlist = playlists.get(Integer.valueOf(playlist_ans)-1);
            }
            else
            {
                System.out.println("The playlist you are looking for dose not exsist.");
                System.out.println("You will need to make the playlist first.");
            }

        }
        return playlist;
    }




}
