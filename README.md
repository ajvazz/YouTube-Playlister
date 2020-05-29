# YouTube Playlister
Program provides information about videos/songs in a YouTube playlist. Idea behind this program is that some videos are sometimes deleted by uploaders, so this is a way to make sure you have saved at least song names before they are deleted.

## Starting the program

#### 1. Console
If you don't want to clone this project, navigate to `target` folder (or just  click [here](https://github.com/ajvazz/YouTube-Playlister/blob/dragan/YT_Playlister/target/YouTubePlaylister.jar)) and download this .jar file. Then, go to its download location, open terminal/console, and type:  
`java -jar YouTubePlaylister.jar playlist_link path_to_output_file`.

**For example**, if you'd like to save information about someone's [best 90s songs](https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02), you'd start the program like this:  
`java -jar YouTubePlaylister.jar https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02 playlistOutput.json`.

#### 2. IntelliJ IDEA
First, clone this repository with `git clone https://github.com/ajvazz/YouTube-Playlister.git`. Then, open IntelliJ IDEA and import this program (as Maven). Since the program is run via _program arguments_, you would need to go to Edit Configurations in IntelliJ IDEA and under `Program arguments` just pass YouTube playlist's link and a file output, the same as you would in a console.
**Note**: there might be some IntelliJ-based problems with initial program start up. Feel free to contact me if you have any questions.

## Usage
When you run this program as stated above (either via console or IntelliJ), an output file with playlist information will appear. It is located in path you provided when you started the program.

### Input
This is a YT playlist link (valid  input): https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02.  
And this is an ID of that same playlist (also valid input): PL7DA3D097D6FDBC02.

## Results
Results are saved in JSON format, containing fields `videoTitle` and `uploadedBy`, for each video in playlist.  
**Note:** YouTube allows only first 500 results of a playlist. Click [here](https://stackoverflow.com/questions/25918405/youtube-api-v3-page-tokens/25928207#25928207) if you want to know more.

## Known Problems
1. There is a possibility that more people will use this program and many calls during a single day will create a problem from everyone - YouTube allows only a certain number of calls (few dozen/hundred) a day. If that happens, you can wait some time and try again later; or generate your own API key, and paste it in the code instead of the currently there (it is in `YouTubeAPI` class). Visit [this link](https://developers.google.com/youtube/registering_an_application) to see how to obtain your own API key.

If you encounter new bugs, send me an email!


## Implementation
This program is using:  
* [Java 8](https://www.oracle.com/java/)
* [REST Assured](http://rest-assured.io/) - Java library for REST API calls
* [JUnit](https://junit.org/junit5/) - testing request results
* [Maven](https://maven.apache.org/)

## Contact
For any kind of information, please feel free to contact me: nenadajvaz@hotmail.com.
