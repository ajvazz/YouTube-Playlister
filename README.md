# YouTube Playlister
Program provides information about videos/songs in a YouTube playlist.

Idea behind this program is that some videos are sometimes deleted by uploaders, so this is a way to make sure you have saved at least song names before they are deleted.

## Starting the program

#### 1. Console
You can create your own .jar file of this program, but you first need to generate it. Steps:
* Open terminal and type `git clone https://github.com/ajvazz/YouTube-Playlister.git`
* Then, type `cd YouTube-Playlister/YT_Playlister`
* To build jar file, enter: `mvn clean compile assembly:single`
* If no errors occured, a _target_ folder should appear. Just do `cd target`
* Then, to start the program, type: `java -jar name_of_generated_JAR_file.jar playlistLink [outputFile]`  

For more info on the last step, visit **Usage**.

#### 2. IntelliJ IDEA
First, clone this repository with `git clone https://github.com/ajvazz/YouTube-Playlister.git`. Then, open IntelliJ IDEA and import this program (as Maven). Since the program is run via _program arguments_, you would need to go to Edit Configurations in IntelliJ IDEA and under `Program arguments`. In there, enter link of YouTube playlist and an optional file output (important, needs to be a JSON file, so it needs to end with .json).
**Note**: there might be some IntelliJ-based problems with initial program start up. Set project SDK to Java 8 (or 1.8). Feel free to contact me if you have any questions.

## Usage
**How to run the program?**  
For example, if you'd like to save information about someone's [best 90s songs](https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02) and save output in custom destination, you'd start the program like this:  
`java -jar name_of_generated_JAR_file.jar https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02 path/to/output.json`

When you run this program as stated above (either via console or IntelliJ), an output file with playlist information will appear. If you haven't provided an output file, a default one will be created instead, in current directory.

### Input
This is a YT playlist link (valid  input): https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02.  
And this is an ID of that same playlist (also valid input): PL7DA3D097D6FDBC02.

## Results
Results are saved in JSON format, containing fields `videoTitle` and `uploadedBy`, for each video in playlist.  
**Note:** YouTube allows only first 500 results of a playlist. Click [here](https://stackoverflow.com/questions/25918405/youtube-api-v3-page-tokens/25928207#25928207) if you want to know more.

## Known Problems
1. There is a possibility that more people will use this program and many calls during a single day will create a problem from everyone - YouTube allows only a certain number of calls (few dozen/hundred) a day. If that happens, you can wait some time and try again later; or generate your own API key, and paste it in the code instead of the currently there (it is in `YouTubeAPI` class). Visit [this link](https://developers.google.com/youtube/registering_an_application) to see how to obtain your own API key.
2. Some users might run into problems when starting the program (occured when using _zsh_ bash).  
If the program displays `zsh: no matches found: _playlistLink_`, you just need to put quotes around link!

If you encounter new bugs, send me an email!


## Implementation
This program is using:  
* [Java 8](https://www.oracle.com/java/)
* [REST Assured](http://rest-assured.io/) - Java library for REST API calls
* [JUnit](https://junit.org/junit5/) - testing request results
* [Maven](https://maven.apache.org/)

## Contact
For any kind of information, please feel free to contact me: nenadajvaz@hotmail.com.
