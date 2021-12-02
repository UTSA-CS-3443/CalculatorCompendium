/**
 * SnakeController controls the Snake view and game.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663) *
 */
package application.controller;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import application.Main;
import application.model.Snake;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeController implements Initializable {

	public static final int WIDTH = 800;
	public static final int HEIGHT = WIDTH;

	private ObservableList<Node> snake;

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	// Goes to the right by default.
	private Direction direction = Direction.RIGHT;
	private boolean moved = false;
	private boolean running = false;
	private double speed = 0.15;
	private int score = 0;

	private AudioClip gameOver;
	private AudioClip ateFood;	
	private AudioClip gameMusic;

	private String[] foodColors = { "#ff9bca", "#f2be63", "#809ce4" };

	private Timeline timeline = new Timeline();

	@FXML
	private Pane pnGame;

	@FXML
	private Label lblScore;

	@FXML
	private ImageView imgGameOver;

	@Override
	/**
	 * Initializes the view and starts the game.
	 * 
	 * @param location,  an URL
	 * @param resources, a ResourceBundle
	 */
	public void initialize(URL location, ResourceBundle resources) {

		try {
			gameOver = new AudioClip(new File("./audio/gameover.mp3").toURI().toString());
			ateFood = new AudioClip(new File("./audio/grow.mp3").toURI().toString());
			gameMusic = new AudioClip(new File("./audio/gamemusic.mp3").toURI().toString());
		} catch (Exception e) {
			System.out.println("Error loading the file - please check its location.");
			e.printStackTrace();
		}
		
		Main.stage.setTitle("Snake Game!");
		Main.stage.requestFocus();

		updateContent();

		startGame();

	}

	@FXML
	/**
	 * Handles what happens when a key is pressed.
	 * 
	 * @param event, a KeyEvent
	 */
	void handleKeyAction(KeyEvent event) {

		if (!moved) {
			return;
		}
		// System.out.println(event.getCode());
		switch (event.getCode()) {
		case UP:
			if (direction != Direction.DOWN)
				direction = Direction.UP;
			break;
		case W:
			if (direction != Direction.DOWN)
				direction = Direction.UP;
			break;
		case DOWN:
			if (direction != Direction.UP)
				direction = Direction.DOWN;
			break;
		case S:
			if (direction != Direction.UP)
				direction = Direction.DOWN;
			break;
		case LEFT:
			if (direction != Direction.RIGHT)
				direction = Direction.LEFT;
			break;
		case A:
			if (direction != Direction.RIGHT)
				direction = Direction.LEFT;
			break;
		case RIGHT:
			if (direction != Direction.LEFT)
				direction = Direction.RIGHT;
			break;
		case D:
			if (direction != Direction.LEFT)
				direction = Direction.RIGHT;
			break;
		case Y:
			startGame();
			break;
		case N:
			try {

				Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
				Main.stage.setTitle("Calculator Compendium");
				(Main.stage).setScene(new Scene(root, 800, 800));
				(Main.stage).show();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

		moved = false;
	}

	/**
	 * This method creates, handles and updates the game components.
	 */
	private void updateContent() {

		lblScore.setText("Score: " + score);

		imgGameOver.setVisible(false);

		// Create the snake.
		Group snakeBody = new Group();
		snake = snakeBody.getChildren();

		// Create the food.
		Rectangle food = createFood();

		// TODO: Fix Speed
		KeyFrame frame = new KeyFrame(Duration.seconds(speed), event -> {

			if (!running) {
				return;
			}

			boolean toRemove = snake.size() > 1;
			Node tail = toRemove ? snake.remove(snake.size() - 1) : snake.get(0);

			double tailX = tail.getTranslateX();
			double tailY = tail.getTranslateY();

			switch (direction) {
			case UP:
				tail.setTranslateX(snake.get(0).getTranslateX());
				tail.setTranslateY(snake.get(0).getTranslateY() - Snake.BLOCK_SIZE);
				break;
			case DOWN:
				tail.setTranslateX(snake.get(0).getTranslateX());
				tail.setTranslateY(snake.get(0).getTranslateY() + Snake.BLOCK_SIZE);
				break;
			case LEFT:
				tail.setTranslateX(snake.get(0).getTranslateX() - Snake.BLOCK_SIZE);
				tail.setTranslateY(snake.get(0).getTranslateY());
				break;
			case RIGHT:
				tail.setTranslateX(snake.get(0).getTranslateX() + Snake.BLOCK_SIZE);
				tail.setTranslateY(snake.get(0).getTranslateY());
				break;
			}

			moved = true;

			if (toRemove)
				snake.add(0, tail);

			// Did we collide with ourselves?
			for (Node rect : snake) {
				if (rect != tail && tail.getTranslateX() == rect.getTranslateX()
						&& tail.getTranslateY() == rect.getTranslateY()) {
					stopGame();
					break;
				}
			}

			// Did we collide with a wall?
			if (tail.getTranslateX() < 0 || tail.getTranslateX() >= Snake.WIDTH || tail.getTranslateY() < 0
					|| tail.getTranslateY() >= Snake.HEIGHT) {
				stopGame();
			}

			// Eat food and grow!
			if (tail.getTranslateX() == food.getTranslateX() && tail.getTranslateY() == food.getTranslateY()) {

				// Move the food.
				food.setTranslateX((int) (Math.random() * (Snake.HEIGHT - Snake.BLOCK_SIZE)) / Snake.BLOCK_SIZE
						* Snake.BLOCK_SIZE);
				food.setTranslateY((int) (Math.random() * (Snake.HEIGHT - Snake.BLOCK_SIZE)) / Snake.BLOCK_SIZE
						* Snake.BLOCK_SIZE);

				// Change color.
				food.setFill(Color.web(randomColor()));

				Rectangle body = newSnakePart();
				body.setTranslateX(tailX);
				body.setTranslateY(tailY);
				snake.add(body);
				
				ateFood.play();
				score += 5;
				lblScore.setText("Score: " + score);
				lblScore.toFront();

				speedUp();

			}

		});

		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);

		pnGame.getChildren().addAll(food, snakeBody);
	}

	/**
	 * This method returns a random color from the foodColors Array.
	 * 
	 * @return color, a String
	 */
	private String randomColor() {
		Random ran = new Random();
		String color = foodColors[ran.nextInt(foodColors.length)];
		return color;
	}

	private Rectangle newSnakePart() {
		Rectangle part = new Rectangle(Snake.BLOCK_SIZE, Snake.BLOCK_SIZE);
		part.setFill(Color.web(Snake.COLOR));
		part.setArcHeight(10.0d);
		part.setArcWidth(10.0d);
		return part;
	}

	/**
	 * This method creates food, assigning it a random color and position within the
	 * pane.
	 * 
	 * @return food, a Rectangle
	 */
	private Rectangle createFood() {
		Rectangle food = new Rectangle(Snake.BLOCK_SIZE, Snake.BLOCK_SIZE);
		food.setFill(Color.web(randomColor()));
		food.setTranslateX(
				(int) (Math.random() * (Snake.WIDTH - Snake.BLOCK_SIZE)) / Snake.BLOCK_SIZE * Snake.BLOCK_SIZE);
		food.setTranslateY(
				(int) (Math.random() * (Snake.HEIGHT - Snake.BLOCK_SIZE)) / Snake.BLOCK_SIZE * Snake.BLOCK_SIZE);
		food.setArcHeight(10.0d);
		food.setArcWidth(10.0d);
		return food;
	} 

	/**
	 * This method speeds up the game to increase game difficulty.
	 */
	private void speedUp() {
		double rate = timeline.getRate();
		rate += 0.025;
		timeline.setRate(rate);
		//System.out.println("Timeline Rate: " + rate);
	}

	/**
	 * This method handles what happens when the game is stopped due to game over.
	 */
	private void stopGame() {
		running = false;
		gameMusic.stop();
		gameOver.play();
		timeline.stop();
		snake.clear();
		imgGameOver.setVisible(true);
	}

	/**
	 * This method initializes the game and resets components.
	 */
	private void startGame() {
		// Reset game variables
		score = 0;
		direction = Direction.RIGHT;
		timeline.setRate(1.0);
		
		imgGameOver.setVisible(false);
		gameMusic.setCycleCount(AudioClip.INDEFINITE);
		gameMusic.play();
		
		Rectangle head = newSnakePart();
		snake.add(head);
		
		lblScore.setText("Score: " + score);
		lblScore.toFront();
		
		timeline.play();
		running = true;
	}

}
