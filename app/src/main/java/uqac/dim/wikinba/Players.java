package uqac.dim.wikinba;

import java.util.List;

public class Players {

    private String astHigh, birth, blkHigh, draft, height, name, nationality, position, ptsHigh, rebHigh, stlHigh, weight;
    private int experience, mvp, rings;
    private List<String> teamsPlayer;

    public Players(){}

    public Players(String astHigh, String birth, String blkHigh, String draft, String height, String name,
                   String nationality, String position, String ptsHigh, String rebHigh, String stlHigh,
                   String weight, int experience, int mvp, int rings, List<String> teamsPlayer) {
        this.astHigh = astHigh;
        this.birth = birth;
        this.blkHigh = blkHigh;
        this.draft = draft;
        this.height = height;
        this.name = name;
        this.nationality = nationality;
        this.position = position;
        this.ptsHigh = ptsHigh;
        this.rebHigh = rebHigh;
        this.stlHigh = stlHigh;
        this.weight = weight;
        this.experience = experience;
        this.mvp = mvp;
        this.rings = rings;
        this.teamsPlayer = teamsPlayer;
    }

    public String getAstHigh() {
        return astHigh;
    }

    public String getBirth() {
        return birth;
    }

    public String getBlkHigh() {
        return blkHigh;
    }

    public String getDraft() {
        return draft;
    }

    public String getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public String getPtsHigh() {
        return ptsHigh;
    }

    public String getRebHigh() {
        return rebHigh;
    }

    public String getStlHigh() {
        return stlHigh;
    }

    public String getWeight() {
        return weight;
    }

    public int getExperience() {
        return experience;
    }

    public int getMvp() {
        return mvp;
    }

    public int getRings() {
        return rings;
    }

    public List<String> getTeamsPlayer() {
        return teamsPlayer;
    }

}
