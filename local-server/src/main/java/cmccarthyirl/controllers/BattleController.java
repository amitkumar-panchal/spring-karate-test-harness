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


    @PostMapping(value = "/battle", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> calculateFight(@RequestParam(value = "yourHeroId") int candidateHeroId, @RequestParam(value = "chosenHeroId") int selectedHeroId) {
        int battleId = new Random().nextInt((1000 - 1) + 1) + 1;

        final BattleReport battleReport = new BattleReport();
        battleReport.setResultId(battleId);
        battleReport.setMessage("Please use the above Report ID to retrieve your Battle report");

        final BattleResultsLog battleResultsLog = checkResults(candidateHeroId, battleId, selectedHeroId);
        List<BattleResultsLog> battleResultsLogList = new ArrayList<>();
        battleResultsLogList.add(battleResultsLog);

        if (ResultsContainer.getResult() != null) {
            ResultsContainer.add(battleResultsLog);
        } else {
            new ResultsContainer(battleResultsLogList);
        }

        return new ResponseEntity<>(battleReport, HttpStatus.OK);
    }

    private BattleResultsLog checkResults(int candidateHeroId, int battleId, int selectedHeroId) {
        final BattleResultsLog battleResultsLog;
        final int candidatesHeroAge = HeroList.getHero(candidateHeroId).getAge();

        if (candidatesHeroAge == HeroList.getHero(selectedHeroId).getAge()) {
            battleResultsLog = new BattleResultsLog("DRAW", battleId, "Both Hero's fought for days to test their might, in the end Dead Pool got tired of waiting for a winner and killed them both");
        } else if (candidatesHeroAge > HeroList.getHero(selectedHeroId).getAge()) {
            battleResultsLog = new BattleResultsLog("WIN", battleId, HeroList.getHero(candidateHeroId).getName() + " fought like a true champion and destroyed " + selectedHeroId);
        } else {
            battleResultsLog = new BattleResultsLog("LOSS", battleId, HeroList.getHero(candidateHeroId).getName() + " fought well but in the end " + selectedHeroId + " kicked his ass!");
        }
        return battleResultsLog;
    }
}