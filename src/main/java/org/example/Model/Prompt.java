package org.example.Model;

import org.example.Service.Main;

import java.util.ArrayList;
import java.util.Random;

public class Prompt {
    /** Brainstorming Journal Prompts*/
    ArrayList<String> brainstormingPrompts = new ArrayList<String>();
    ArrayList<String> beginnerPrompts = new ArrayList<String>();
    ArrayList<String> dailyJournalPrompts = new ArrayList<String>();
    ArrayList<String> creativeWritingPrompts = new ArrayList<String>();
    ArrayList<String> bodyPositivityPrompts = new ArrayList<String>();



    public Prompt() {

        /** Prompts can be found here: https://dayoneapp.com/blog/journal-prompts/
         * */
        brainstormingPrompts.add("What is the current problem or challenge I am facing?");
        brainstormingPrompts.add("What are my goals and objectives related to this problem or challenge?");
        brainstormingPrompts.add("What are some potential solutions to this problem or challenge?");
        brainstormingPrompts.add("What are some creative and unconventional solutions I can consider?");
        brainstormingPrompts.add("What are some pros and cons of each potential solution?");
        brainstormingPrompts.add("How can I collaborate with others to find a solution?");
        brainstormingPrompts.add("What are some resources I can utilize to help solve this problem or challenge?");
        brainstormingPrompts.add("How can I apply my skills, knowledge, and experience to this problem or challenge?");
        brainstormingPrompts.add("What are some potential roadblocks or challenges to implementing a solution, and how can I overcome them?");
        brainstormingPrompts.add("How can I prioritize and organize my thoughts and ideas to effectively solve this problem or challenge?");

        /** Beginner Journal Prompts*/


        beginnerPrompts.add("What happened today?");
        beginnerPrompts.add("What was the best thing that happened today?");
        beginnerPrompts.add("What was the worst thing that happened today?");
        beginnerPrompts.add("What was the most interesting thing I saw or heard today?");
        beginnerPrompts.add("What was the most challenging thing I faced today?");
        beginnerPrompts.add("What am I grateful for today?");
        beginnerPrompts.add("What did I learn today?");
        beginnerPrompts.add("What was the most fun thing I did today?");
        beginnerPrompts.add("What was the most surprising thing that happened today?");
        beginnerPrompts.add("What did I do today that I am proud of?");

        /** Daily Journal (DJ) */
        dailyJournalPrompts.add("How am I feeling today?");
        dailyJournalPrompts.add("What are my top priorities for the day?");
        dailyJournalPrompts.add("What’s something I can do to make today amazing?");
        dailyJournalPrompts.add("What am I nervous or anxious about today?");
        dailyJournalPrompts.add("What am I thankful for today?");
        dailyJournalPrompts.add("What could I have done differently today?");
        dailyJournalPrompts.add("How can I make tomorrow even better?");
        dailyJournalPrompts.add("What did I do today that brought me joy or fulfillment? How can I incorporate more of these activities into my daily routine?");
        dailyJournalPrompts.add("What challenges did I face today? How did I overcome them? What can I learn from these experiences?");
        dailyJournalPrompts.add("What did I learn today? How can I apply this knowledge in the future?");

        /** Creative Writing (CW) */
        creativeWritingPrompts.add("Write a story from the perspective of an inanimate object that has come to life.");
        creativeWritingPrompts.add("Write a poem about a childhood memory that has stayed with you.");
        creativeWritingPrompts.add("Write about a character who wakes up one day with a superpower.");
        creativeWritingPrompts.add("Write a story about a group of people who are stranded on a deserted island.");
        creativeWritingPrompts.add("Write a story from the perspective of a character who has lost their memory and is trying to piece together their past.");
        creativeWritingPrompts.add("Write a poem that explores the concept of time and how it shapes our lives.");
        creativeWritingPrompts.add("Write about a relationship that taught you an important lesson about yourself or the world around you.");
        creativeWritingPrompts.add("Write a story about a time traveler who accidentally gets stuck in the wrong time period.");
        creativeWritingPrompts.add("Write a story about a character who discovers a mysterious book with a hidden message.");
        creativeWritingPrompts.add("Write about a place that has had a significant impact on your life, and what memories or emotions it brings up for you.");


        /** Body Positivity (BP) */
        bodyPositivityPrompts.add("What do I love most about my body, and why?");
        bodyPositivityPrompts.add("What beliefs or messages about my body do I need to let go of in order to cultivate more self-love and acceptance?");
        bodyPositivityPrompts.add("What would it feel like to let go of the need to compare my body to others, and instead focus on my own unique strengths and beauty?");
        bodyPositivityPrompts.add("What are some ways I can prioritize my physical health and well-being, without falling into the trap of diet culture or body shaming?");
        bodyPositivityPrompts.add("What role does social media or the media in general play in shaping my body image, and how can I cultivate a more positive relationship with these sources of influence?");
        bodyPositivityPrompts.add("How can I be more compassionate towards my body, especially when I’m feeling self-critical or negative?");
        bodyPositivityPrompts.add("What activities or practices help me feel connected to and in tune with my body?");
        bodyPositivityPrompts.add("How can I shift my focus from appearance-based goals (e.g. weight loss, achieving a certain body shape) to more holistic measures of health and wellness (e.g. energy levels, mood, strength, etc.)?");
        bodyPositivityPrompts.add("What does it mean to truly embody self-love and body positivity, and how can I take small steps towards this every day?");
        bodyPositivityPrompts.add("What are some ways I can celebrate and care for my body, regardless of its shape or size?");



    }

    //this method will return a random prompt based on the prompt type
    public String returnPrompt (String promptType){
        Random rand = new Random();
        int randomInteger = rand.nextInt(10);
        Main.log.warn("Random integer for today is "+randomInteger);
       // System.out.println(randomInteger); - can be converted into a log
        String prompt = "null";

        switch (promptType) {
            case "BR":
                prompt = brainstormingPrompts.get(randomInteger);
                break;
            case "BG":
                prompt = beginnerPrompts.get(randomInteger);
                break;
            case "DJ":
                prompt = dailyJournalPrompts.get(randomInteger);
                break;
            case "CW":
                prompt = creativeWritingPrompts.get(randomInteger);
                break;
            case "BP":
                prompt = bodyPositivityPrompts.get(randomInteger);
                break;
        }
        return prompt;
    }

}


