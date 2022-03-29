package com.anthony.game;

import com.anthony.card.Card;
import com.anthony.card.Rank;
import com.anthony.card.Suit;
import com.anthony.user.Dealer;
import com.anthony.user.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {
    GameLogic testLogic = new GameLogic();
    Player testPlayer = new Player("testPlayer");
    Dealer testDealer = new Dealer();
    Card testCard1 = new Card(Suit.Club, Rank.King);
    Card testCard2 = new Card(Suit.Diamond, Rank.King);

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("Starting..." + testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("Ending..." + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Tie game with both players having equal hands")
    void check_tie_for_equal_hands() {
        testPlayer.addCard(testCard1);
        testDealer.addCard(testCard2);
        boolean expected_result = true;
        boolean actual_result = testLogic.checkTieGame(testPlayer,testDealer);
        assertEquals(expected_result, actual_result);
    }

    @Test
    @DisplayName("Tie game with both players having hand value of 30")
    void check_tie_game_for_bust(){
        for(int i = 0; i < 3; i++){
            testPlayer.addCard(testCard1);
            testDealer.addCard(testCard2);
        }
        boolean expected_result = true;
        boolean actual_result = testLogic.checkTieGame(testPlayer,testDealer);
        assertEquals(expected_result, actual_result);
    }

    @Test
    void checkPlayerWin() {
    }

    @Test
    void checkBust() {
    }
}