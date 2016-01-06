# Gradle for Android and Java Final Project

In this project, you will create an app with multiple flavors that uses
multiple libraries and Google Could Endpoints. The finished app will consist
of four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Config

I put a config file where is define a public and local URL for the backend. There is 
a boolean called "DEBUG" for defining what type of url I want to work with. If DEBUG
is true then the app use the local URL, otherwise the app use the public URL deployed 
to google app engine.
