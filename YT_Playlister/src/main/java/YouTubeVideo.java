class YouTubeVideo {

    private final String title;
    private final String description;
    private final String publishedAt;
//    private Date publishedAt;
//    private String channelTitle;

    public YouTubeVideo(String title, String desc, String date) {
        this.title = title;
        this.description = desc;
        this.publishedAt = date;
    }

    @Override
    public String toString() {
        String separator = Param.newLine + Param.separatorSingle + Param.newLine;
        return  separator + "TITLE: "       + getTitle() +
                separator + "DESCRIPTION: " + getDescription() +
                separator + "PUBLISHED AT: "+ getPublishedAt() +
                separator;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPublishedAt() { return publishedAt; }
}
