public class Track {


    private String gameMusic;
    private String tileIamge;
    private String startImage;


    private String titleName;


    public Track(String gameMusic, String tileIamge, String startImage, String titleName) {

        this.gameMusic = gameMusic;
        this.tileIamge = tileIamge;
        this.startImage = startImage;
        this.titleName = titleName;

    }


    public String getTileIamge() {
        return tileIamge;
    }
    public void setTileIamge(String tileIamge) {
        this.tileIamge = tileIamge;
    }
    public String getStartImage() {
        return startImage;
    }
    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }
    public String getGameMusic() {
        return gameMusic;
    }
    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }
    public String getTitleName() {
        return titleName;
    }
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }





}
