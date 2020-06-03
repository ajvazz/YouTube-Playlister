class YouTubeVideo {

    private final String title;
    private final String channel;

    public YouTubeVideo(String title, String channel) {
        this.title = title;
        this.channel = channel;
    }

    public String getTitle()   { return title; }
    public String getChannel() { return channel; }

    @Override
    public String toString() {
        final String TAB = "           ";
        return  TAB + "\"videoTitle\": \""  + getTitle()    + "\"," + System.lineSeparator() +
                TAB + "\"uploadedBy\": \""  + getChannel()  + "\"";
    }
}
