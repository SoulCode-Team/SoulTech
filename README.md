# SoulTech  ![SoulTech logo](https://raw.githubusercontent.com/SoulSkin/SoulTech/master/Logo/SoulTech%20Repo%20Logo.png)
A Minecraft mod that adds tools, weapons, and tons of other cool stuff!

Downloads
===

Latest drone.io build status: ![Build Status](https://drone.io/github.com/SoulSkin/SoulTech/status.png)

Unstable Releases From Drone.io: [Files](https://drone.io/github.com/SoulSkin/SoulTech/files)

Stable builds from CurseForge: (coming soon!)

(The following is copied from https://github.com/pahimar/Equivalent-Exchange-3
###Compiling SoulTech
IMPORTANT: Please report any issues you have, there might be some problems with the documentation!
Also make sure you know EXACTLY what you're doing!  It's not any of our faults if your OS crashes, becomes corrupted, etc.
***
[Setup Java](#setup-java)

[Setup Gradle](#setup-gradle)

[Setup Git](#setup-git)

[Setup SoulTech](#setup-soultech)

[Compile SoulTech](#compile-soultech)

[Updating Your Repository](#updating-your-repository)

####Setup Java
The Java JDK is used to compile SoulTech.

1. Download and install the Java JDK.
	* [Windows/Mac download link](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).  Scroll down, accept the `Oracle Binary Code License Agreement for Java SE`, and download it (if you have a 64-bit OS, please download the 64-bit version).
	* Linux: Installation methods for certain popular flavors of Linux are listed below.  If your distribution is not listed, follow the instructions specific to your package manager or install it manually [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
		* Gentoo: `emerge dev-java/oracle-jdk-bin`
		* Archlinux: `pacman -S jdk7-openjdk`
		* Ubuntu/Debian: `apt-get install openjdk-7-jdk`
		* Fedora: `yum install java-1.7.0-openjdk`
2. Windows: Set environment variables for the JDK.
    * Go to `Control Panel\System and Security\System`, and click on `Advanced System Settings` on the left-hand side.
    * Click on `Environment Variables`.
    * Under `System Variables`, click `New`.
    * For `Variable Name`, input `JAVA_HOME`.
    * For `Variable Value`, input something similar to `C:\Program Files\Java\jdk1.7.0_51` exactly as shown (or wherever your Java JDK installation is), and click `Ok`.
    * Scroll down to a variable named `Path`, and double-click on it.
    * Append `;%JAVA_HOME%\bin` EXACTLY AS SHOWN and click `Ok`.  Make sure the location is correct; double-check just to make sure.
3. Open up your command line and run `javac`.  If it spews out a bunch of possible options and the usage, then you're good to go.  If not, either try the steps again or check the [FAQ](https://github.com/SoulSkin/SoulTech/wiki/Frequently-Asked-Questions).

####Setup Gradle
Gradle is used to execute the various build tasks when compiling SoulTech.
If you would rather not install gradle, forgeGradle comes with a gradle wrapper. For all of the following commands, you can use `gradlew` instead of `gradle` and skip installing Gradle.

1. Download and install Gradle.
	* [Windows/Mac download link](http://www.gradle.org/downloads).  You only need the binaries, but choose whatever flavor you want.
		* Unzip the package and put it wherever you want, eg `C:\Gradle`.
	* Linux: Installation methods for certain popular flavors of Linux are listed below.  If your distribution is not listed, follow the instructions specific to your package manager or install it manually [here](http://www.gradle.org/downloads).
		* Gentoo: `emerge dev-java/gradle-bin`
		* Archlinux: You'll have to install it from the [AUR](https://aur.archlinux.org/packages/gradle).
		* Ubuntu/Debian: `apt-get install gradle`
		* Fedora: Install Gradle manually from its website (see above), as Fedora ships a "broken" version of Gradle.  Use `yum install gradle` only if you know what you're doing.
2. Windows: Set environment variables for Gradle.
	* Go back to `Environment Variables` and then create a new system variable.
	* For `Variable Name`, input `GRADLE_HOME`.
	* For `Variable Value`, input something similar to `C:\Gradle-1.11` exactly as shown (or wherever your Gradle installation is), and click `Ok`.
	* Scroll down to `Path` again, and append `;%GRADLE_HOME%\bin` EXACTLY AS SHOWN and click `Ok`.  Once again, double-check the location.
3. Open up your command line and run `gradle`.  If it says "Welcome to Gradle [version].", then you're good to go.  If not, either try the steps again or check the [FAQ](https://github.com/SoulSkin/SoulTech/wiki/Frequently-Asked-Questions).


####Setup Git
Git is used to clone SoulTech and update your local copy.

1. Download and install Git [here](http://git-scm.com/download/).
	* *Optional*: Download and install a Git GUI client, such as Github for Windows/Mac, SmartGitHg, TortoiseGit, etc.  A nice list is available [here](http://git-scm.com/downloads/guis).

####Setup SoulTech
This section assumes that you're using the command-line version of Git.

1. Open up your command line.
2. Navigate to a place where you want to download SoulTech's source (e.g. `C:\Github\`) by executing `cd [folder location]`.  This location is known as `mcdev` from now on.
3. Execute `git clone https://github.com/SoulSkin/SoulTech.git`.  This will download SoulTech's source into `mcdev`.
4. Right now, you should have a directory that looks something like:

***
	mcdev
	\-SoulTech
		\-SoulTech's files (should have `build.gradle`)
***

####Compile SoulTech
1. Execute `gradle setupCiWorkspace`. This sets up Forge and downloads the necessary libraries to build SoulTech.  This might take some time, be patient.
	* You will generally only have to do this once until the Forge version in `build.properties` changes.
2. Execute `gradle build`. If you did everything right, `BUILD SUCCESSFUL` will be displayed after it finishes.  This should be relatively quick.
    * If you see `BUILD FAILED`, check the error output (it should be right around `BUILD FAILED`), fix everything (if possible), and try again.
3. Navigate to `mcdev\SoulTech\build\libs`.
    *  You should see a `.jar` file named `GameOfLife-{minecraftVersion}-{modversion} universal.jar`.
4. Copy the jar into your Minecraft mods folder, and you are done!

####Updating Your Repository
In order to get the most up-to-date builds, you'll have to periodically update your local repository.

1. Open up your command line.
2. Navigate to `mcdev` in the console.
3. Make sure you have not made any changes to the local repository, or else there might be issues with Git.
	* If you have, try reverting them to the status that they were when you last updated your repository.
4. Execute `git pull master`.  This pulls all commits from the official repository that do not yet exist on your local repository and updates it.

###Contributing
***
####Submitting a PR
So you found a bug in SoulSkin's code?  Think you can make it more efficient?  Want to help in general?  Great!

1. If you haven't already, create a Github account.
2. Click the `Fork` icon located at the top-right of this page (below your username).
3. Make the changes that you want to and commit them.
	* If you're making changes locally, you'll have to execute `git commit -a` and `git push` in your command line.
4. Click `Pull Request` at the right-hand side of the gray bar directly below your fork's name.
5. Click `Click to create a pull request for this comparison`, enter your PR's title, and create a detailed description telling SoulSkin what you changed.
6. Click `Send pull request`, and wait for feedback!

####Creating an Issue
SoulTech crashes every time?  Have a suggestion?  Found a bug?  Create an issue now!

1. Make sure your issue hasn't already been answered or fixed.  Also think about whether your issue is a valid one before submitting it.
	* Please mark issues that are questions with the title "[question]".
2. Go to [the issues page](http://github.com/SoulSkin/SoulTech/issues).
3. Click `New Issue` right below `Star` and `Fork`.
4. Enter your Issue's title (something that summarizes your issue), and then create a detailed description ("Hey SoulSkin, could you add/change xxx?" or "Hey, found an exploit:  stuff").
	* If you are reporting a bug report from an unofficial version, make sure you include the following:
		* Commit SHA (usually located in a changelog or the jar name itself)
		* ForgeModLoader log (please put it in pastebin or similar!)
		* Server log if applicable (please put it in pastebin or similar!)
		* Detailed description of the bug and pictures if applicable
5. Click `Submit new issue`, and wait for feedback!
