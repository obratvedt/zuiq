package com.example.oyvin.zuiq.states;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.oyvin.zuiq.R;
import com.example.oyvin.zuiq.models.Answer;
import com.example.oyvin.zuiq.models.Question;
import com.example.oyvin.zuiq.sprites.AnswerBtn;

import java.util.ArrayList;

import sheep.graphics.Image;

public class GameState extends BackgroundState {
    private static GameState gameState = null;
    float time = 0;
    boolean drawPlayerReady= true;
    boolean drawQuestion = false;
    Paint readyTextPaint, questionAnsTxt;
    int playerId = 1;
    ArrayList<Question> questions = new ArrayList<>();
    AnswerBtn answer1Btn, answer2Btn, answer3Btn, answer4Btn;


    public static GameState getInstance() {
        if(gameState == null){
            gameState = new GameState();
        }
        return gameState;
    }

    private GameState() {
        super();
        readyTextPaint = new Paint();
        readyTextPaint.setColor(Color.WHITE);
        readyTextPaint.setTextSize(50);
        questionAnsTxt = new Paint();
        questionAnsTxt.setColor(Color.WHITE);
        questionAnsTxt.setTextSize(50);
        Answer answer1 = new Answer("heidundrade");
        Answer answer2 = new Answer("2");
        Answer answer3 = new Answer("f24");
        Answer rightAnswer = new Answer("asf23");

        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(rightAnswer);

        Question questionTest = new Question("Hvor er snalgebarg", answers, rightAnswer,"Bleie");
        questions.add(questionTest);

        answer1Btn = new AnswerBtn(new Image(R.drawable.optionbtn));
        answer2Btn = new AnswerBtn(new Image(R.drawable.optionbtn));
        answer3Btn = new AnswerBtn(new Image(R.drawable.optionbtn));
        answer4Btn = new AnswerBtn(new Image(R.drawable.optionbtn));
        this.addTouchListener(answer1Btn);
        this.addTouchListener(answer2Btn);
        this.addTouchListener(answer3Btn);
        this.addTouchListener(answer4Btn);
    }

    public void draw(Canvas canvas){
        super.draw(canvas);
        if(drawPlayerReady){
            canvas.drawText("Player" + playerId + " get ready", canvas.getWidth()/2-100, canvas.getHeight()/2, readyTextPaint);
        }
        if (drawQuestion){
            Question tempQ = questions.get(0);
            canvas.drawText(tempQ.getText(), canvas.getWidth()/2-200, canvas.getHeight()/4, questionAnsTxt);
            answer1Btn.setPosition(canvas.getWidth()/4, canvas.getHeight()/2);
            answer2Btn.setPosition(canvas.getWidth()/1.5f, canvas.getHeight()/2);
            answer3Btn.setPosition(canvas.getWidth()/4, canvas.getHeight()/1.2f);
            answer4Btn.setPosition(canvas.getWidth()/1.5f, canvas.getHeight()/1.2f);
            answer1Btn.draw(canvas);
            answer2Btn.draw(canvas);
            answer3Btn.draw(canvas);
            answer4Btn.draw(canvas);
            canvas.drawText(tempQ.getAnswers().get(0).getText(),answer1Btn.getX(),answer1Btn.getY(),questionAnsTxt);
            canvas.drawText(tempQ.getAnswers().get(1).getText(),answer2Btn.getX(),answer2Btn.getY(),questionAnsTxt);
            canvas.drawText(tempQ.getAnswers().get(2).getText(),answer3Btn.getX(),answer3Btn.getY(),questionAnsTxt);
            canvas.drawText(tempQ.getAnswers().get(3).getText(),answer4Btn.getX(),answer4Btn.getY(),questionAnsTxt);

        }

    }

    public void update(float dt){
        super.update(dt);
        time = time + dt;
        if (time >= 5){
            drawPlayerReady = false;
            drawQuestion = true;
            answer1Btn.update(dt);
            answer2Btn.update(dt);
            answer3Btn.update(dt);
            answer4Btn.update(dt);


        }



    }
}
