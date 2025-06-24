This mod is an approach to add a custom projectile in Java Minecraft 1.21.4 after all the Fabric API changes between 1.19 - 1.21.4
Mod only available for Version 1.21.4 as of now.

|[Youtube Tutorial](https://youtu.be/FWusCHDab40) - By Yours Truly|

|THE EASY WAY|
1) Dowload [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 1.21.4
2) Copy Paste the Fabric API and TrackFPS jar files from 'Mod Files' to 'appdata/roaming/minecraft/mods'
3) Run Minecraft 1.21.4

|THE LONG WAY|
1) Clone this Repo to your device
2) Make desirable changes
3) Run ./gradlew build in terminal
4) Dowload [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 1.21.4
5) Copy The TrackFPS.jar file from 'build/libs' folder and paste it to 'appdata/roaming/minecraft/mods' 
6) Copy The FabricAPI jar file from 'Mod Files' folder and paste it to 'appdata/roaming/minecraft/mods'
7) Run Minecraft 1.21.4

|Unresolved Errors|
1) The Lance Entity disappears the second it hits any living mob/entity even though no discard logic is added in the OnEntityHit function.
2) The Lance Entity when thrown sticks to blocks/ground vertically unlike a normal trident ingame. 
Potential Solutions : Not Found
These errors won't be worked upon for now atleast.

