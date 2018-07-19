package com.tsguild.wordguesser;

import com.tsguild.wordguesser.dao.*;
import com.tsguild.wordguesser.model.Score;
import com.tsguild.wordguesser.model.Word;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private HighScoreDao scores;
    private WordDao words;

    @Inject
    public MainController(HighScoreDao scores, WordDao words) {
        this.scores = scores;
        this.words = words;
    }

    private final Map<String, String> currentGame = new HashMap<>();
    private int turns;
    private long points;

    @RequestMapping(value = "/highscores", method = RequestMethod.GET)
    public String topScores(HttpServletRequest request, Model model) {
        List<Score> scoreList = new ArrayList<>();
        scoreList.addAll(scores.getAllScores());
        model.addAttribute("topscores", scoreList);
        return "/highscores";
    }

    @RequestMapping(value = "/{letters}", method = RequestMethod.GET)
    public String getLetter(@PathVariable("letters") String letters, Model model) {
        model.addAttribute("letters", letters);
        return letters;
    }

    @RequestMapping(value = "/gameboard", method = RequestMethod.GET)
    public String gameBoard(@PathVariable("letters") String letters, Model model) {
        boolean gaming = true;
        Word word = new Word("Llama", 20);
        Word newWord = new Word("");
        char[] blanks = word.getGuesses();
        model.addAttribute("word", blanks);
        boolean charChecking = true;
        int i = 0;
        List<Word> myWords = new ArrayList<>();
        myWords.addAll(words.getAllWords());

        do {
            do {
                String userG = this.getLetter(letters, model); //needs to be a path variable
                char guess = letters.charAt(0);
                charChecking = word.guessLetter(guess);
                String s = word.getWord();
                turns = 5;
                if (charChecking = true) {
                    turns--;
                    model.addAttribute("turns", turns);
                } else if (charChecking = false) {
                    model.addAttribute("word", blanks);
                }
                model.addAttribute("guess", guess);
                if (word.getIsComplete()) {
                    points = points + word.getPoints();
                    String pointsString = String.valueOf(points);
                    currentGame.put(s, pointsString);
                    model.addAttribute("score", points);
                    blanks = word.getLetters();
                    i = i + 1;
                    newWord = myWords.get(i);
                    model.addAttribute("word", newWord);

                } else if (!word.getIsComplete()) {
                    gaming = false;
                    return "results";
                }
            } while (turns > 0);
            points = points + word.getPoints();
            model.addAttribute("score", points);
        } while (gaming);

        return "/gameboard";
    }

    @RequestMapping(value = "/gameboard?new=game", method = RequestMethod.GET)
    public String newGame(HttpServletRequest request, Model model) {
        turns = 5;
        long points = 0;

        String setName = "Camelids";
        words.loadWordSet(setName);
        /*
        Word word = new Word("Llama", 20);
        char[] blanks = word.getGuesses();
        model.addAttribute("word", blanks);
        turns = 5;
        List<Word> myWords = new ArrayList<>();
        myWords.addAll(words.getAllWords());
         */
        return "/gameboard";
    }
    ///make this part of the gameboard endpoint
    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String newResult(HttpServletRequest request,
            @PathVariable String name, Model model) {
        model.addAttribute("score", points);
        List<Score> newL = new ArrayList<>();
        newL = scores.getTopThree();
        Score score = new Score();
        Score newScore = new Score();
        score = newL.get(2);
        long s = score.getPoints();
        if (points > s) {
            newScore.setName(name);
            newScore.setPoints(points);
            scores.updateScore(name, points);
            model.addAttribute("score", points);
        }
        return "/results";
    }
}
