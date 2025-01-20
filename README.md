# Android Example App

Goal of this app is to display a bunch of information about the characters of the Rick and Morty universe. Don't know Rick and Morty? Well it's a shame, because it's the best TV show!

## Setup dev environment

### PREREQUISITE
* Java 17 JDK installed
  * Can be done from: <https://www.azul.com/downloads/?version=java-17-lts&os=macos&package=jdk>
* JAVA_HOME env variable is set and exported:
  * Can be done by pasting command below into "~/.zprofile" for zsh shell or into "~/.bash_profile" for bash shell
    ```
    export JAVA_HOME=$(/usr/libexec/java_home -v 17)
    ```
* Install Android Studio from https://developer.android.com/studio

## Build and run app
* Using Android Studio -> File -> Open
* Navigate to the folder where your project located, *choose* app folder 
* Wait for gradle to finish sync
* Run app using Run app button (control+R)

## What should be done
* Error handling
* Better Logging
* Some tests would be nice :)
* Add some throttling when user searches
* Network module should be abstracted so ktor is not leaked to higher level modules
* Introduce entity model for character as now network model is stored in db
