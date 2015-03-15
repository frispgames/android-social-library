# Frisp Android Social Library

### What does it do?
Provides an interface into the android API for sharing to social media. Currently only supports sharing of images and text. This was created for the android component of frisp-social-unity-asset.

### Usage

```JAVA
  FrispSocial.shareImage("Caption", "Message", "Base64Image");
```

### Build

Run ```ant jar``` in the directory to build a jar file for the social plugin

### Integrating with Unity

After creating the jar file you will need to copy it into the following directory:  
```Unity/<Project Name>/Assets/Plugins/Android/```
