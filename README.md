# CmdSpy
See the commands executed by the player on your Nukkit server

# Example
![image](https://user-images.githubusercontent.com/83061703/210245705-dc0719b8-3de7-4fbd-837a-23a72f8bf2b5.png)

# Command
| Command  | Aliases | Description | Permission |
| -------- | ------- | ----------- | ---------- |
| /cmdspy  | /spy    | Spying on executed commands | spy.use | 

# Config 
```yaml
# Command
command:
  name: "spy"
  description: "Spying on executed commands"
  aliases: ["cmdspy"] 

# Use "§" or "&" to change the color of the message!
# Placeholders: {prefix}, {sender}, {command}

# Message prefix
spy-prefix: '§7[§cSPY§7]§f'
log-prefix: '§7[SPY]§f'

# Spy On/Off
spy-on: '{prefix} §fYou have successfully §cenabled§f the display of executed commands.'
spy-off: '{prefix} §fYou have successfully §cdisabled§f the display of executed commands.'

# Notification of the executed command
spy-message-format: '{prefix} §c{sender} §7-> §f{command}'

enable-logger: true
logger-format: '{prefix} Player §b{sender} §fexecuted §7{command}'

# Errors
no-permission: '{prefix} §fYou do not have permission to use this command!'
only-ingame: '{prefix} §fThis command can only be used in the game!'

```
