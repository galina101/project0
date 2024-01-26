## Introduction

The program is a Journaling app that provides prompts to the user. The program allows users to add journal entries, view, delete and search them.

## App Behavior
At the start the application provides a prompt based on 5 themes: 
1. Beginner (BG),
2. Brainstorming (BR),
3. Daily Journal (DJ),
4. Creative Writing (CW),
5. Body Positivity (BP). 

The app asks for input of one of the prompt options. Based on the type of prompt selected by the user, the program returns a prompt randomly from a set of prompts. Using the prompt the user creates a new entry. After an entry is created the user has an option to add a new entry (New), view all entries (View), update an entry (Update) or delete an entry (Delete).

## Technical Features
The app has built-in unit test cases:
1. Verifies that the list of entries is empty when created
2. Verifies that one entry is added successfully
3. Confirms the deletion of one entry
4. Confirms the deletion of multiple entries
5. Confirms that a custom exception is thrown when user enters an invalid number of entry
5. Confirms that the search works as expected
6. Confirms that update feature works as expected

The app tracks some actions via logging in logfile.log. The log restarts on every launch of the file.