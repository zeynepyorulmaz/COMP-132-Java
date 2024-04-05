
public class Playlist {
    private String name;
    private Song[] songList;
    private String user;
    private int numSongs;

    public Playlist(String name, String user){
        //A constructor that initializes the  with the provided name and user, and initializes the array to have size 10.
        this.name = name;
        this.user = user;
        songList = new Song[10];
    }

    public void addSong(Song s){
        songList[numSongs] = s;
        numSongs +=1;
        s.incPop();;


    }
    public void removeSong(int index){
    	songList[index].decPop();
    	for (int i = index; i< numSongs-1; i++){
    		songList[i] = songList[i+1];
    		
    	}
    	numSongs -= 1;
    	

    }
    public int getNumSongs(){
        return numSongs;

    }
    public int totalDuration(){
    	int total = 0;
        for (Song s : songList){
            if (s!= null) {
            total += s.getDuration();}
            

        }
        return total;


    }
    public double price(){
    	double total = 0;
        for (Song s : songList){
        	
        	if (s!= null) {
            total += s.getCost();}
        }
        return total;

    }
    public String getName(){
        return name;
    }

    public String getUser(){
        return user;
    }
    public String toString(){
    	String songListStr = "\n";
        for (Song s : songList){
            if (s!= null) {
            	songListStr += "* " + s.getTitle() + "\n";
            }
            
            }
  
        String str = "Playlist name: " + name+ "\n" +
                "User name: " + user + "\n" +
                "Number of songs: " + numSongs + "\n" +
                "Songs in playlist: " + songListStr;
        return str;

        }
    



    public Song getSong(int index) {
    	return this.songList[index];
    }
    
    
    
    public Song[] getSongList() {
    	return songList;
    }
}
