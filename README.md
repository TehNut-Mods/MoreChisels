#More Chisels [![Build Status](http://tehnut.info/jenkins/job/MoreChisels/badge/icon)](http://tehnut.info/jenkins/job/MoreChisels/)

Assorted chisels for [Chisel-2](https://github.com/TheCricket/Chisel-2).

##Downloads

Downloads for MoreChisels (as well as all of my other mods) can be found on my [Jenkins](http://tehnut.info/jenkins/) or [CurseForge](http://minecraft.curseforge.com/mc-mods/227904-morechisels).

##Chisels done:

* Gems: Whitelisting in config to add chisels OreDict gems
* Fluxed Chisel: Runs on Redstone Flux.
* Bound Chisel: Runs on your Blood Magic LP network.
* Ironwood/Steeleaf: Twilight Forest compat 
* Bedrockium: Extra Utilities compat
* Skyroot/Holystone/Zanite/Gravitite: Aether II compat

##Chisels to come:

* See [this](https://github.com/TehNut/MoreChisels/issues/3) issue.

## Want to suggest some chisel types?

[Join my channel](https://webchat.esper.net/?channels=tehnut) (#TehNut) on [Espernet](https://www.esper.net/) and discuss there.

##Dev setup

1. Clone/Fork/Whatever you need to do to get it on your local machine.
2. Run `gradlew [setupDevWorkspace|setupDecompWorkspace] [eclipse|idea]` This will automatically setup your workspace for you.
3. Drop a Deobfuscated version of Chisel-2 in `../libs/` and add it as a library.
4. Do things.
