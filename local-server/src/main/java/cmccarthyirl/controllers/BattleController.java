package cmccarthyirl.controllers;


import cmccarthyirl.models.BattleReport;
import cmccarthyirl.models.BattleResultsLog;
import cmccarthyirl.storage.HeroList;
import cmccarthyirl.storage.ResultsContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class BattleController {

    BattleReport battleReport;

    @PostMapping("/battle")
    public ResponseEntity<?> calculateFight(@RequestParam(value = "yourHeroId") int candidateHero, @RequestParam(value = "chosenHeroId") int hardCodedHero) {
        int candidatesHeroAge = HeroList.getHero(candidateHero).getAge();
        int randomNum = new Random().nextInt((1000 - 1) + 1) + 1;

        battleReport = new BattleReport();
        battleReport.setResultId(randomNum);
        battleReport.setMessage("Please use the above Report ID to retrieve your Battle report");

        BattleResultsLog battleResultsLog = checkResults(candidatesHeroAge, HeroList.getHero(hardCodedHero).getAge(), HeroList.getHero(hardCodedHero).getName(), randomNum, candidateHero);
        List<BattleResultsLog> battleResultsLogList = new ArrayList<>();
        battleResultsLogList.add(battleResultsLog);

        if (ResultsContainer.getResult() != null) {
            ResultsContainer.add(battleResultsLog);
        } else {
            new ResultsContainer(battleResultsLogList);
        }

        return new ResponseEntity<>(battleReport, HttpStatus.OK);
    }

    private BattleResultsLog checkResults(int candidatesHeroAge, int hardCodedHeroAge, String hardCodedHeroName, int randomNum, int candidateHero) {
        BattleResultsLog battleResultsLog;

        if (candidatesHeroAge == hardCodedHeroAge) {
            battleResultsLog = new BattleResultsLog("DRAW", randomNum, "Both Heros fought for days to test their might, in the end Dead Pool got tired of waiting for a winner and killed them both");
        } else if (candidatesHeroAge > hardCodedHeroAge) {
            battleResultsLog = new BattleResultsLog("WIN", randomNum, HeroList.getHero(candidateHero).getName() + " fought like a true champion and destroyed " + hardCodedHeroName);
        } else {
            battleResultsLog = new BattleResultsLog("LOSS", randomNum, HeroList.getHero(candidateHero).getName() + " fought well but in the end " + hardCodedHeroName + " kicked his ass!");
        }
        return battleResultsLog;
    }
}