package tilegame.pages;

import java.util.HashMap;

public class PageManager {
    public enum PAGESENUM{
        HOMEPAGE,
        LEADERBOARDPAGE,
        CREDENTIALSPAGE
    }
    private final HashMap<PAGESENUM, Page> pages = new HashMap<>();
    private Page currentPage;
    private static PageManager instance;
    private PageManager(){
        currentPage = null;
    }
    public static PageManager getInstance(){
        if (instance == null){
            instance = new PageManager();
        }
        return instance;
    }
    public void addPage(PAGESENUM key, Page page){
        pages.put(key, page);
    }
    public void setCurrentPage(PAGESENUM key) {
        currentPage = pages.get(key);
    }

    public Page getCurrentPage() {
        return currentPage;
    }
}
