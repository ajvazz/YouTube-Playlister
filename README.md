# YouTube-Playlister
Program provides basic information about videos/songs in a playlist from YouTube (not working for YouTube Music e.g.).

## Usage
When you run this program, it will prompt you to enter a YouTube playlist link.  

Note the difference between _playlist link_ and a _link of a song within the playlist_:   
Invalid link to playlist: https://www.youtube.com/watch?v=fPO76Jlnz6c&list=PL7DA3D097D6FDBC02  
Valid link to playlist: https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02

_Note:_ You need to have a **blank space** after typing/copying link to console. Otherwise, if you press `Enter`, IntelliJ would open that link in browser and that's probably not what you would want.

## Results
After a couple of seconds, the console will display each video's title and its uploader. In the `resources` folder exists a file which contains a bit more details.  

__Note:__ If playlist contains more than 50 videos, only first 50 will be shown (This is a "feature" in [YouTube Data API](https://developers.google.com/youtube/v3). This fix should be fixed soon)

## Problems
If you have problems with results, probably the solution is to generate your own API key for YouTube Data API, and use it instead of the one in the program code. Visit [this link](https://developers.google.com/youtube/registering_an_application) to see how to obtain your own API key.

## Implementation
This program is using:  
* [Java 13](https://www.oracle.com/java/)
* [REST Assured](http://rest-assured.io/) - Java library for REST API calls
* [YouTube Data API](https://developers.google.com/youtube/v3) - communication with YouTube
* [TestNG](https://testng.org/doc/) - testing request results
* [Maven](https://maven.apache.org/)

## Contact
For any kind of information, please feel free to contact me: nenadajvaz@hotmail.com.
