public class Song {
    private String title;
    private Singer singer;
    private int duration;
    private double cost;
    private int popularity;
    public Song(String title, Singer singer, int duration, double cost){
        this.title = title;
        this.singer = singer;
        this.duration = duration;
        this.cost = cost;
        popularity = 0;
    }
    public Song(String title, Singer singer, int duration){
        this.title = title;
        this.singer = singer;
        this.duration = duration;
        this.cost = 4.99;
        popularity = 0;

    }
    public int getPopularity() {
    	return popularity;
    }
    public String getTitle(){
        return title;
    }
    public Singer getSinger(){
        return singer;
    }
    public int getDuration(){
        return duration;
    }
    public double getCost(){
        return cost;
    }
    public void setCost(double c){
        cost = c;
    }
    public void incPop() {
    	this.popularity+=1;
    	
    }
    public void decPop() {
    	this.popularity-=1;    
    }
}

