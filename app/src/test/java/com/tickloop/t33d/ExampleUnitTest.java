package com.tickloop.t33d;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addToArray(){
        //generate arrays to test for equality
        String expected = "Player4";
        ArrayList<String> players = new ArrayList<String>();
        players.add("Sam");
        players.add("Tim");
        ArrayList<String> playersExpected = new ArrayList<String>();
        playersExpected.add("Sam");
        playersExpected.add("Tim");
        playersExpected.add("Player4");
        LobbyActivity activity = new LobbyActivity();
        //call method to add the new player to the array
        activity.addPlayerToArray(expected, players);
        //check for equality
        assertEquals(playersExpected.get(playersExpected.size()-1), players.get(players.size()-1));
    }

    @Test
    public void decideWinner(){
        //generate arrays to test for equality
        String expectedName = "Player4";
        ArrayList<String> players = new ArrayList<String>();
        players.add("Sam");
        players.add("Tim");
        players.add("Player4");
        ArrayList<String> playersExpected = new ArrayList<String>();
        playersExpected.add("Sam");
        playersExpected.add("Tim");
        playersExpected.add(expectedName);
        LobbyActivity lobby = new LobbyActivity();
        int randomVal = (int)(Math.random()*players.size());
        //call method to determine winner
        String value = lobby.decideWinner(players, randomVal);
        String expected = playersExpected.get(randomVal);
        //ensure the winner is returned
        assertEquals(expected, value);
    }

}