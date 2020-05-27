class YouTubeVideo {

    private final String title;
    private final String channel;
    private final String description;
    private final String publishedAt;

    public YouTubeVideo(String title, String desc, String date, String channel) {
        this.title = title;
        this.channel = channel;
        this.description = desc;
        this.publishedAt = date;
    }

    public String getTitle() { return title; }
    public String getChannel() { return channel; }
    public String getDescription() { return description; }
    public String getPublishedAt() { return publishedAt; }

    @Override
    public String toString() {
        final String TAB = "            ";
        return  //TAB + "\"description\": "   + getDescription()  + "," + Param.newLine +
                //TAB + "\"publishedAt\": "   + getPublishedAt()  + "," + Param.newLine +
                TAB + "\"title\": "     + getTitle()    + "," + Param.newLine +
                TAB + "\"channel\": "   + getChannel();
    }
}
