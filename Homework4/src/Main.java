//Gilbert Isaac Salazar
//HW 4
//This program does something

import java.util.*;
import java.io.*;

/**********************************************************/
/* Feed                                                   */
/**********************************************************/

class Feed{
    private String _title;
    private String _desc;
    public Feed(){}
    public Feed(String a, String b){
        _title = a; _desc = b;
    }
    public void setTitle(String a){_title = a;}
    public void setDesc(String a){_desc = a;}
    public String getTitle(){return _title;}
    public String getDesc(){return _desc;}
    public String toString(){return _title + " " + _desc;}
}

/**********************************************************/
/* NewsFeed				                  */
/**********************************************************/

class NewsFeed {
    private ArrayList<Feed> _newsFeed;
    public NewsFeed(){_newsFeed = new ArrayList<Feed>();}
    public NewsFeed(String fileName) throws IOException {
        _newsFeed = new ArrayList<>();
        Scanner infile = new Scanner(new File(fileName));
        //Gets a new line every iteration and splits it by semicolon for title and description
        while(infile.hasNext()){
            String[] news = infile.nextLine().split(",");
            _newsFeed.add(new Feed(news[0], news[1]));
        }
    }
    public Feed getRandomFeed(){
        //random number generator to pick random number from 0 to size of arraylist
        Random rand = new Random();
        int idx = rand.nextInt(0, _newsFeed.size());
        return _newsFeed.get(idx);
    }
}
/**********************************************************/
/* Strategy Pattern Interface/Classes                     */
/**********************************************************/

// Provided: Strategy Interface
interface AnalysisBehavior {
    double analyze(String[] words, String searchWord);
}

// Task: Complete Class CountIfAnalysis
class CountIfAnalysis implements AnalysisBehavior {


}
// Task: Complete Class CountAllAnalysis
class CountAllAnalysis implements AnalysisBehavior {


}

/**********************************************************/
/* Observer Pattern Interface/Classes                     */
/**********************************************************/

interface Subject {  // Notifying about state changes
    void subscribe(Observer obs);
    void unsubscribe(Observer obs);
    void notifyObservers(Feed f);
}

interface Observer {  // Waiting for notification of state changes
    void update(Feed f, String platformName);
}


abstract class SocialMediaPlatform implements Subject {
    private String _name;
    private ArrayList<Feed> _feed;
    private ArrayList<Observer> _observers;
    private int _updateRate;

    public SocialMediaPlatform(String n, int x){
        _name = n;
        _feed = new ArrayList<Feed>();
        _observers = new ArrayList<Observer>();
        _updateRate = x;
    }
    public void addFeed(Feed f){_feed.add(f);}
    public Feed getFeed(int i){return _feed.get(i);}
    public int getRate(){return _updateRate;}
    public String getName(){return _name;}
    public int size(){return _feed.size();}
    public void subscribe(Observer obs){_observers.add(obs);}
    public void unsubscribe(Observer obs){_observers.remove(obs);}
    public void notifyObservers(Feed f){
        for (Observer observer : _observers)
            observer.update(f, _name);
    }
    public void generateFeed(NewsFeed nf){

    }
    public double analyzeFeed(String w, AnalysisBehavior ab){

    }
    public String toString(){
        String s = "";
        for (Feed f: _feed)
            s = s + f.getTitle() + ", " + f.getDesc() + "\n";
        return s;
    }
}

// Concrete Social Media Platforms
class Instagram extends SocialMediaPlatform {
    public Instagram() {
        super("Instagram", 30);  // 30% update rate
    }
}

class Facebook extends SocialMediaPlatform{
    public Facebook(){
        super("Facebook", 50);
    }
}

class Twitter extends SocialMediaPlatform{
    public Twitter(){
        super("Twitter", 20);
    }
}

class User implements Observer{
    private String _name;
    private ArrayList<SocialMediaPlatform> _myfeeds;
    public User(){_myfeeds = new ArrayList<SocialMediaPlatform>();}
    public User(String s){
        _name = s;
        _myfeeds = new ArrayList<SocialMediaPlatform>();
    }
    public void addPlatform(SocialMediaPlatform smp){_myfeeds.add(smp);}
    public void update(Feed f, String s){
        for (int i=0; i<_myfeeds.size(); i++){
            SocialMediaPlatform smp = _myfeeds.get(i);
            if (smp.getName().equals(s))
                _myfeeds.get(i).addFeed(f);
        }
    }
    public String toString(){
        String s = "";
        for (SocialMediaPlatform smp : _myfeeds) {
            for (int i=0; i<smp.size(); i++){
                Feed f = smp.getFeed(i);
                s = s + f.getTitle() + " " + f.getDesc() + "\n";
            }
        }
        return s;
    }
}

/**********************************************************/
/* Factory Pattern Interface/Classes                      */
/**********************************************************/

// Factory Creator Interface
interface SMPFactory {
    SocialMediaPlatform createPlatform();
}

// Concrete Factory classes for each platform
class InstagramFactory implements SMPFactory {
    public SocialMediaPlatform createPlatform() {
        return new Instagram();
    }
}

class FacebookFactory implements SMPFactory {
    public SocialMediaPlatform createPlatform(){
        return new Facebook();
    }
}

class TwitterFactory implements SMPFactory{
    public SocialMediaPlatform createPlatform(){
        return new Twitter();
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        // Create main newsfeed from file
        NewsFeed nf = new NewsFeed("data.txt");

        // Create SMP factories
        SMPFactory instagramFactory = new InstagramFactory();
        SMPFactory facebookFactory = new FacebookFactory();
        SMPFactory twitterFactory = new TwitterFactory();


        // Create the platforms container and add SMPs
        ArrayList<SocialMediaPlatform> platforms = new ArrayList<>();
        platforms.add(instagramFactory.createPlatform());
        platforms.add(facebookFactory.createPlatform());
        platforms.add(twitterFactory.createPlatform());

        // Create Users and subscribe
        User user1 = new User("Alice");
        user1.addPlatform(instagramFactory.createPlatform());
        for(int i = 0; i < platforms.size(); i++) {
            platforms.get(i).subscribe(user1);
        }

        // Run a simulation to generate random feeds for the SMPs


        // Perform analysis
        AnalysisBehavior ab = new CountAllAnalysis();
        System.out.println(platforms.get(0).analyzeFeed("guess", new CountAllAnalysis()));

        // Print Users' Contents

    }

}
