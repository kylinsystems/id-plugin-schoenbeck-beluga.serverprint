# Serverprint Testcases
## From Toolbar
### Print Profile / Sub Profile / Copy
* Standard profile
* User profile overrides Standard Profile completely (2/2 copy types)
* User profile overrides Standard Profile partially (1/2 copy types)
* BP-Profile overrides Standard Profile completely (2/2 copy types)
* BP-Profile overrides Standard Profile partially (1/2 copy types)
* If a Standard Profile, a User Profile and a BP-Profile all deliver copies for the same copy type, the BP-Profile has priority

### Process
* Jasper Reports provide files
    * ! iD Reports provide files -> they do not currently, or we failed to configure properly
    * ! Processes provide files -> tests using the URLFileSource plugin failed, that might be solely due to that plugin but we don't know for sure
* Process is skipped if "use from archive" is marked and there is a file to use
* Process is not skipped if "use from archive" is marked but there is no file to use

### Printoptions
* Print all copies if none have printoptions
* Print all copies if they have the same printoptions
* Print both copies if one has any printoption and the other has none
* Ignore copies using "process only" printoptions, print the other
* If two copies have different (not "process only") printoptions, ask the user which to use

