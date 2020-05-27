class YouTubeVideo {

    private final String title;
    private final String description;
    private final String publishedAt;
//    private final Date publishedAt;
//    private final String channelTitle;

    public YouTubeVideo(String title, String desc, String date) {
        this.title = title;
        this.description = desc;
        this.publishedAt = date;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPublishedAt() { return publishedAt; }

    @Override
    public String toString() {
        final String separator = Param.newLine + Param.separatorSingle + Param.newLine;
        return  separator + "TITLE: "       + getTitle() +
                separator + "DESCRIPTION: " + getDescription() +
                separator + "PUBLISHED AT: "+ getPublishedAt() +
                separator;
    }
}
