# Beluga Serverprint
An iDempiere plugin that creates printable documents and distributes or prints them. See more [here](https://wiki.idempiere.org/en/Plugin:_Beluga_Serverprint).

### Cloning
This repository uses submodules. It is advisable to run `git clone --recurse-submodules` when cloning.

### Building
**Warning:** Currently the build process does not work as intended!
Run `mvn verify` in the top-level directory. Maven will first build the required JSPI, then the plugin. 