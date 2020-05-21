# YouTube Playlister
Program provides information about videos/songs in a YouTube playlist. Idea behind this program is that some videos are sometimes deleted by uploaders, so this is a way to make sure you have saved at least song names (before they are deleted).

## Starting the program

#### Console
If you don't want to clone this project, navigate to `jar` folder (or just  click [here](https://github.com/ajvazz/YouTube-Playlister/blob/master/YT_Playlister/jar/YT_Playlister.jar)) and download .jar file. Then, go to its download location, open terminal/console, and type:  
`java -cp YT_Playlister.jar App`. Visit _Usage_ to see how to use the program.

#### IntelliJ IDEA
First, clone this repository with `git clone https://github.com/ajvazz/YouTube-Playlister.git`. Then, open IntelliJ IDEA and import this program (as Maven).  
**Note**: there might be some IntelliJ-based problems with initial program start up. Feel free to contact me if you have any questions.

## Usage

1. When you run this program, it will prompt you to enter a YouTube playlist link, or ID of a playlist.  
For example, this is a YT playlist (valid  input): https://www.youtube.com/playlist?list=PL7DA3D097D6FDBC02.  
And this is an ID of that playlist (also valid input): PL7DA3D097D6FDBC02.

2. Next, program will ask you where do you want to save the output (generates a file). Recommended extension is `.txt`.

3. As a last (optional) step, program will ask you if you want some other additional information besides just video name & uploader.

## Results
The program sends an API request, and quickly recieves an answer with the results. They are saved in a file whose path the user has provided in the second step.  
**Note:** YouTube allows only first 500 results of a playlist. Click [here](https://stackoverflow.com/questions/25918405/youtube-api-v3-page-tokens/25928207#25928207) if you want to know more.

## Known Problems
1. (Only in IntelliJ IDEA) You need to have a **blank space** after typing/copying link to console. Otherwise, if you press `Enter`, IntelliJ would open that link in browser and that's probably not what you would want.  
2. There is a possibility that more people will use this program and many calls during a single day will create a problem from everyone - YouTube allows only a certain number of calls (few hundred/thousand) a day. If that happens, you can wait some time and try again later, or generate your own API key, and paste it in the code instead of the currently there (it is in `Param` class). Visit [this link](https://developers.google.com/youtube/registering_an_application) to see how to obtain your own API key.

If you encounter new bugs, send me an email!


## Implementation
This program is using:  
* [Java 13](https://www.oracle.com/java/)
* [REST Assured](http://rest-assured.io/) - Java library for REST API calls
* [YouTube Data API](https://developers.google.com/youtube/v3) - communication with YouTube
* [TestNG](https://testng.org/doc/) - testing request results
* [Maven](https://maven.apache.org/)

## Contact
For any kind of information, please feel free to contact me: nenadajvaz@hotmail.com.
