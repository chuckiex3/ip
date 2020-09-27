# Toto's User Guide
      /-\    /-\
     /  |_!_/  |      Hullo I'm Toto!
    /@ O  v  O @\

## Setting up
1. Ensure that you have Java 11 installed in your computer. You can download it from [here](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).
2. Download the ip.jar file into a folder.
3. In your terminal, navigate to the folder before typing the following:
      - chcp 65001
      - java -Dfile.encoding=UTF-8 -jar ip.jar

  **Example: ip.jar saved in Downloads**
  ![ip.jar in Downloads example](https://github.com/chuckiex3/ip/tree/master/images/howtocalljar.png)

  >!! Please change the font in your terminal to NSimSun.
  >> 1. Right click on the top of your terminal and click on 'Properties' from the drop down menu.

  ![Right click on the terminal](https://github.com/chuckiex3/ip/tree/master/images/changefontonterminal.png)

  >> 2. Click on the 'Font' tab.
  >> 3. Scroll down and choose the font NSimSun.

  ![Change font to NSimSun](https://github.com/chuckiex3/ip/tree/master/images/changetoNSimSun.png)

4. Type in commands by referring to the next section, Features. 

## Features
Toto allows you to save your tasks as `deadline`, `event` or `todo`. There are also commands like `list`, `done`, `find`, `on` and `bye`. Toto will also automatically `save` your tasks in a .txt file, every time you make changes to your task list.

>!! Words within [square brackets] are the expected user inputs.

### Starting the program
Displays a greeting from Toto.

#### First run
For first time users, Toto will create a new folder and file to store your task list. Where the folder is created depends on where you've downloaded the jar file.
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	Hullo I'm Toto!
      /-\    /-\
     /  |_9_/  |
    /,,o  3  o,,\

	How can Toto help today?
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	weewoo Toto has made a folder~
hehe Toto just made a new file for you! @ C:\Users\Francene\Documents\SEM3\ip\.\data\taskList.txt :o3
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

#### Subsequent runs
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	Hullo I'm Toto!
      /-\    /-\
     /  |_9_/  |
    /,,o  3  o,,\

	How can Toto help today?
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
folder has been found
@C:\Users\Francene\Documents\SEM3\ip\.\data
	Toto found your saved file..
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	welcome back master! Toto has missed you~ <3
	Toto has loaded your saved task list~
      /-\    /-\
     /  |_9_/  |
   p/,,=  w  =,,\p
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### Deadline
A task which has to be done by a certain date and time.
#### Usage
##### `deadline [taskDescription] /by [dd/MM/yyyy] [hhmm]` -adds a deadline
Example: `deadline coding exercises /by 28/08/2020 1300`

Parameters:
* `taskDescription`: name of the task.
* `dd/MM/yyyy`: the due date of the task, in the format day/month/year.
* `hhmm`: time the task is due, in 24h format.

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
	Toto added: coding exercises
1:[D][✘] coding exercises (by: Aug 28 2020 01.00 PM)
	now you have 1 task(s)
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
o0.0o Toto's done saving
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### Event
A task that starts at a specific time and ends at a specific time.
#### Usage
##### `event [taskDescription] /at [dd/MM/yyyy] [hhmm]` -adds an event
Example: `event birthday party /at 20/09/2020 1800`

Parameters:
* `taskDescription`: name of the task.
* `dd/MM/yyyy`: the day of the event, in the format day/month/year.
* `hhmm`: start time of the event, in 24h format.

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
        Toto added: birthday party
2:[E][✘] birthday party (at: Sep 20 2020 06.00 PM)
        now you have 2 task(s)
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
o0.0o Toto's done saving
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### Todo
A task without any date/time attached to it.
#### Usage
##### `todo [taskDescription]` -adds a todo
Example: `todo watch lecture videos`

Parameters:
* `taskDescription`: name of the task.

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
        Toto added: watch lecture videos
3:[T][✘] watch lecture videos
        now you have 3 task(s)
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
o0.0o Toto's done saving
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### List
Lists all the tasks in the task list.
#### Usage
##### `list` -lists all available tasks on the task list

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
1: [D][✘] coding exercises (by: Aug 28 2020 01.00 PM)
2: [E][✘] birthday party (at: Sep 20 2020 06.00 PM)
3: [T][✘] watch lecture videos
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### Done
Marks a task as done.
#### Usage
##### `done [taskNumber]` -marks the task at the corresponding index as done
Example: `done 2`

Parameters:
* taskNumber: index of the task on the task list.

>!! You may want to `list` before using the `done` command to ensure you're marking the correct task as done! :)

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
        Toto is proud of you! =w=
2: [E][✓] birthday party (at: Sep 20 2020 06.00 PM)
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### Delete
Deletes a task from the task list.
#### Usage
##### `delete [taskNumber]` -deletes task at the corresponding index
Example: `delete 3`

Parameters:
* taskNumber: index of the task on the task list.

>!! You may want to `list` before using the `delete` command so that you delete the task you have in mind! :)

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
        aaaah why though?
3: [T][✘] watch lecture videos
        now you have 2 task(s)
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### Find
Finds tasks that match the `keyword` input by the user.
#### Usage
##### `find [keyword]` -finds tasks that match the keyword given
Example: `find birthday`

Parameters:
* keyword: word input by the user.

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
        Toto has found 1 match(es)!
1:[E][✓] birthday party (at: Sep 20 2020 06.00 PM)
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### On
Lists task(s), specifically `deadline`/`event`, that occur(s) on the date input by the user.
#### Usage
##### `on [dd/MM/yyyy]` -lists tasks occurring on the given date
Example: `on 20/09/2020`

Parameters:
* [dd/MM/yyyy]: date input by the user, in the format day/month/year.

> date input by the user has to follow the dd/MM/yyyy format!

Expected outcome: `on 20/09/2020`

```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
1: [E][✓] birthday party (at: Sep 20 2020 06.00 PM)
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

If no tasks occur on the date specified, example: `on 29/09/2020`
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
        no tasks on 29/09/2020!
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

### Bye
Quits the program.
#### Usage
#### `bye` -exits the program

Expected outcome:
```
-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
        Toto will be lonely... :<
      /-\    /-\
     /  |_9_/  |
    / TT  w  TT \

-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
```

## Summary:
**Command** | **Format** | **Example**
----------- | ---------- | -----------
`deadline` | deadline [taskDescription] /by [dd/MM/yyyy] [hhmm] | deadline coding exercises /by 28/08/2020 1300
`event` | event [taskDescription] /at [dd/MM/yyyy hhmm] | event birthday party /at 20/09/2020 1800
`todo` | todo [taskDescription] | todo watch lecture videos
`list` | list | list
`done` | done [taskNumber] | done 2
`find` | find [keyword] | find watch
`on` | on [dd/MM/yyyy] | on 20/09/2020
`bye` | bye | list
