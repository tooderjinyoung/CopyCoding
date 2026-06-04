public class Track {


    private String gameMusic;
    private String tileIamge;
    private String startImage;

    public Track(String gameMusic, String tileIamge, String startImage) {

        this.gameMusic = gameMusic;
        this.tileIamge = tileIamge;
        this.startImage = startImage;

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






}
