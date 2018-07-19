/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.wordguesser.dao;

import com.tsguild.wordguesser.model.Score;
import com.tsguild.wordguesser.model.Word;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ahill
 */
public class WordAndScoreTest {

    public WordAndScoreTest() {
        
    }

    @Test
    public void testWordCreation() {
        
        // If I make a new word
        Word word = new Word("Llama", 10);
        
        // The guess array should be initialized to all '_' characters
        // but be of the same length as the number of letters in the word
        Assert.assertNotNull(word.getGuesses());
        Assert.assertEquals("Llama".length(), word.getGuesses().length);
        Assert.assertEquals('_', word.getGuesses()[0]);
        Assert.assertEquals('_', word.getGuesses()[1]);
        Assert.assertEquals('_', word.getGuesses()[2]);
        Assert.assertEquals('_', word.getGuesses()[3]);
        Assert.assertEquals('_', word.getGuesses()[4]);
        
        // The letters array should be initialized to all the characters of the original word.
        Assert.assertNotNull(word.getLetters());
        Assert.assertEquals("Llama".length(), word.getLetters().length);
        Assert.assertEquals('L', word.getLetters()[0]);
        Assert.assertEquals('l', word.getLetters()[1]);
        Assert.assertEquals('a', word.getLetters()[2]);
        Assert.assertEquals('m', word.getLetters()[3]);
        Assert.assertEquals('a', word.getLetters()[4]);
        
    }
    
    public void testWordAndScorePoints() {
        
        // If I make a new word
        Word word = new Word("Llama", 10);
        // It should be worth 10 points
        Assert.assertEquals(10, word.getPoints());
        
        // If I make a new score w/ 10 points
        Score score = new Score("Lily", 10);
        // And tell it to add the points of my word
        score.addToScore(word);
        
        // The word should be worth 10 points
        Assert.assertEquals(10, word.getPoints());
        // But the score should be worth 10 + 10, or 20 points
        Assert.assertEquals(20, score.getPoints());
        
        // If I add that word's points to the score again
        score.addToScore(word);
        
        // The score should be worth 20 + 10, or 30 points
        Assert.assertEquals(30, score.getPoints());
    }
    
    @Test
    public void testWeirdWords(){
        Word word = new Word("Mixed-Up");
        Assert.assertEquals("Mixed-Up".length(), word.getGuesses().length);
       
        // Mixed should be hidden by '_'
        Assert.assertEquals('_', word.getGuesses()[0]);
        Assert.assertEquals('_', word.getGuesses()[1]);
        Assert.assertEquals('_', word.getGuesses()[2]);
        Assert.assertEquals('_', word.getGuesses()[3]);
        Assert.assertEquals('_', word.getGuesses()[4]);
        
        // The dash should stay & be visible
        Assert.assertEquals('-', word.getGuesses()[5]);
        
        // Up should be hidden by '_'
        Assert.assertEquals('_', word.getGuesses()[6]);
        Assert.assertEquals('_', word.getGuesses()[7]);
        
        // Guessing all the words should return true
        // but it should not be complete until all letters are guessed
        // the dash shouldn't count.
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('M'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('i'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('x'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('e'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('d'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('U'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('p'));
        // Now that everything is guessed, it should be complete
        Assert.assertTrue(word.getIsComplete());
        
        // If you ever did try to guess the dash
        // it should return false
        Assert.assertFalse(word.guessLetter('-'));
        
    }
    
    @Test
    public void testWordGuessCompletition() {
        // If I make a new word
        Word word = new Word("Llama", 10);
        
        // The guess array should be initialized to all '_' characters
        // but be of the same length as the number of letters in the word
        Assert.assertEquals("Llama".length(), word.getGuesses().length);
        Assert.assertEquals('_', word.getGuesses()[0]);
        Assert.assertEquals('_', word.getGuesses()[1]);
        Assert.assertEquals('_', word.getGuesses()[2]);
        Assert.assertEquals('_', word.getGuesses()[3]);
        Assert.assertEquals('_', word.getGuesses()[4]);
        
        // The word shouldn't be marked as 'completed' until all the letters are guessed.
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('l'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('a'));
        Assert.assertFalse(word.getIsComplete());
        Assert.assertTrue(word.guessLetter('m'));
        // Now that it is entirely guessed it should be complete
        Assert.assertTrue(word.getIsComplete());
        
        // If you reset the guesses, it shouldn't be complete anymore
        word.resetGuesses();
        Assert.assertFalse(word.getIsComplete());
    }
    
    @Test
    public void testWordGuesses() {
        
        // If I make a new word
        Word word = new Word("Llama", 10);
        
        // The guess array should be initialized to all '_' characters
        // but be of the same length as the number of letters in the word
        Assert.assertEquals("Llama".length(), word.getGuesses().length);
        Assert.assertEquals('_', word.getGuesses()[0]);
        Assert.assertEquals('_', word.getGuesses()[1]);
        Assert.assertEquals('_', word.getGuesses()[2]);
        Assert.assertEquals('_', word.getGuesses()[3]);
        Assert.assertEquals('_', word.getGuesses()[4]);
        
        // If I guess the letter L (uppercase)
        // it should return true, because 'Llama' contains 2 Ls.
        Assert.assertTrue(word.guessLetter('L'));
        
        // It should update the 'guess' character array
        // to have all L's revealed regardless of casing
        // all other letters should stay hidden as '_'
        Assert.assertEquals('L', word.getGuesses()[0]);
        Assert.assertEquals('l', word.getGuesses()[1]);
        Assert.assertEquals('_', word.getGuesses()[2]);
        Assert.assertEquals('_', word.getGuesses()[3]);
        Assert.assertEquals('_', word.getGuesses()[4]);
        
        // If I guess an M, it should also be true
        Assert.assertTrue(word.guessLetter('M'));
        
        // and now the m should be revealed
        Assert.assertEquals('L', word.getGuesses()[0]);
        Assert.assertEquals('l', word.getGuesses()[1]);
        Assert.assertEquals('_', word.getGuesses()[2]);
        Assert.assertEquals('m', word.getGuesses()[3]);
        Assert.assertEquals('_', word.getGuesses()[4]);
        
        // And finally an A
        Assert.assertTrue(word.guessLetter('A'));
        
        // The whole word should be revealed
        Assert.assertEquals('L', word.getGuesses()[0]);
        Assert.assertEquals('l', word.getGuesses()[1]);
        Assert.assertEquals('a', word.getGuesses()[2]);
        Assert.assertEquals('m', word.getGuesses()[3]);
        Assert.assertEquals('a', word.getGuesses()[4]);
        
        
        // If I guess a bunch of other letters, they should all return false
        // because the word has already been completed, and revealed
        Assert.assertFalse(word.guessLetter('l'));
        Assert.assertFalse(word.guessLetter('m'));
        Assert.assertFalse(word.guessLetter('a'));
        Assert.assertFalse(word.guessLetter('c'));
        Assert.assertFalse(word.guessLetter('v'));
        Assert.assertFalse(word.guessLetter('b'));
        
        Assert.assertEquals('L', word.getGuesses()[0]);
        Assert.assertEquals('l', word.getGuesses()[1]);
        Assert.assertEquals('a', word.getGuesses()[2]);
        Assert.assertEquals('m', word.getGuesses()[3]);
        Assert.assertEquals('a', word.getGuesses()[4]);
        
    }
    
    @Test
    public void testWordGuessReset() {
        
        // If I make a word
        Word word = new Word("Llama", 10);
        
        // And then completely guess it
        Assert.assertTrue(word.guessLetter('l'));
        Assert.assertTrue(word.guessLetter('a'));
        Assert.assertTrue(word.guessLetter('m'));
        
        Assert.assertEquals('L', word.getGuesses()[0]);
        Assert.assertEquals('l', word.getGuesses()[1]);
        Assert.assertEquals('a', word.getGuesses()[2]);
        Assert.assertEquals('m', word.getGuesses()[3]);
        Assert.assertEquals('a', word.getGuesses()[4]);
        
        // But reset the guesses on the word
        word.resetGuesses();
        
        // All of the characters in the Guess array should be reset to '_'
        Assert.assertEquals("Llama".length(), word.getGuesses().length);
        Assert.assertEquals('_', word.getGuesses()[0]);
        Assert.assertEquals('_', word.getGuesses()[1]);
        Assert.assertEquals('_', word.getGuesses()[2]);
        Assert.assertEquals('_', word.getGuesses()[3]);
        Assert.assertEquals('_', word.getGuesses()[4]);
        
        // And I should be able to completely guess it again
        Assert.assertTrue(word.guessLetter('l'));
        Assert.assertTrue(word.guessLetter('a'));
        Assert.assertTrue(word.guessLetter('m'));
        
        Assert.assertEquals('L', word.getGuesses()[0]);
        Assert.assertEquals('l', word.getGuesses()[1]);
        Assert.assertEquals('a', word.getGuesses()[2]);
        Assert.assertEquals('m', word.getGuesses()[3]);
        Assert.assertEquals('a', word.getGuesses()[4]);
        
    }

}
