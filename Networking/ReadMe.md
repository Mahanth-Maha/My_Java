# Networking Scripts LAB Based

## RMI Cal ->
  ```
  Calculator.java
  Impl.java
  Server.java
  Client.java
  ```
### Run
Shell
  ```
  javac *.java & rmic Impl & rmiregistry & cd .. & java Networking.Server & java Networking.Server
  ```
Win
```
  javac *.java ;rmic Impl ;rmiregistry ;cd .. ;java Networking.Server ;java Networking.Server
  ```

  
## Ping Cal ->
  ```
  HelloCommand.java
  EchoCommand.java
  CommandExe.java
  ```
### Run
Shell
  ```
  javac *.java & cd .. & java Networking.CommandExe 
  ```
Win
```
  javac *.java ;cd .. ;java Networking.CommandExe 
  ```
