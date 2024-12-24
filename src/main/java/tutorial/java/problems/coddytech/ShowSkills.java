package tutorial.java.problems.coddytech;

import java.util.*;

public class ShowSkills {
    public static void main(String[] args){
        User user = new User("bob", "bob@example.com");
        user.learn("Python");
        user.learn("C++");
        user.learn("Python");
        user.learn("HTML");
        user.learn("HTML");
        user.learn("HTML");
        user.showSkills();
        user.clearSkill("HTML");
        user.showSkills();
    }
}

class User{

    public String username;
    public String email;
    private String location = "unset";
    public ArrayList<String> skills = new ArrayList<>();

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void info(){
        System.out.println("Username: " + this.username);
        System.out.println("Email: " + this.email);
        System.out.println("Location: " + this.location);
    }

    public void learn(String skill){
        this.skills.add(skill);
    }

    public void showSkills(){
        TreeMap<String, Integer> skillMap = new TreeMap<>();
        for(String skill : skills){
            if(skillMap.containsKey(skill)){
                skillMap.put(skill, skillMap.get(skill)+1);
            }else{
                skillMap.put(skill, 1);
            }
        }
        for(Map.Entry<String, Integer> entry : skillMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void clearSkill(String skill){
        skills.removeAll(Arrays.asList(skill));
    }

}