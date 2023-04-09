package User;

import Course.Model.Assignment;
import Course.Model.Course;
import Course.Model.NavigationTab;
import Message.Model.Message;

import java.util.ArrayList;

public class NavigationTabManager {
    private ArrayList<NavigationTab> tabs;
    NavigationTab activeTab;

    public NavigationTabManager(){
        tabs = new ArrayList<NavigationTab>();
        tabs.add(new Course());
        tabs.add(new Assignment());
        tabs.add(new Message());
        activeTab = tabs.get(0);
    }

    public void displayActiveTab(){
        activeTab.display();
    }
    public void setActiveTab(NavigationTab tab){
        activeTab = tab;
    }
}
