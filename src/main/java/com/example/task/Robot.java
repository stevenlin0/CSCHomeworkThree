package com.example.task;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private ImageView robotView;
    private final int stepSize = 5; // Number of pixels to move per step
    private double xPosition = 50;
    private double yPosition = 50;



    public Robot() {
        Image robotImage = new Image(getClass().getResource("/robot.png").toExternalForm());
        robotView = new ImageView(robotImage);
        robotView.setX(xPosition);
        robotView.setY(yPosition);

    }


    public ImageView getRobotImageView() {
        return robotView;
    }

    public void handleMovement(KeyEvent event, Image mazeImage) {
        //This is for when you want manual movement and stuff
        switch (event.getCode()) {
            case UP:
                if (canMove(xPosition, yPosition - stepSize, mazeImage)) {
                    yPosition -= stepSize;
                }
                break;
            case DOWN:
                if (canMove(xPosition, yPosition + stepSize, mazeImage)) {
                    yPosition += stepSize;
                }
                break;
            case LEFT:
                if (canMove(xPosition - stepSize, yPosition, mazeImage)) {
                    xPosition -= stepSize;
                }
                break;
            case RIGHT:
                if (canMove(xPosition + stepSize, yPosition, mazeImage)) {
                    xPosition += stepSize;
                }
                break;
        }
        robotView.setX(xPosition);
        robotView.setY(yPosition);

        System.out.println(xPosition + ", " + yPosition);
    }



    private boolean canMove(double x, double y, Image mazeImage) {
        double robotWidth = robotView.getImage().getWidth();
        double robotHeight = robotView.getImage().getHeight();

        double xLeft = x;  // Left boundary of the robot
        double xRight = x + robotWidth / 1.5;  // Right boundary
        double yTop = y;  // Top boundary
        double yBottom = y + robotHeight / 1.5;  // Bottom boundary

        if (xLeft < 0 || yTop < 0 || xRight >= mazeImage.getWidth() || yBottom >= mazeImage.getHeight()) {
            return false;
        }

        // Checks corners of the robot for walls
        Color topLeft = mazeImage.getPixelReader().getColor((int) xLeft, (int) yTop);
        Color topRight = mazeImage.getPixelReader().getColor((int) xRight, (int) yTop);
        Color bottomLeft = mazeImage.getPixelReader().getColor((int) xLeft, (int) yBottom);
        Color bottomRight = mazeImage.getPixelReader().getColor((int) xRight, (int) yBottom);

        return !isWall(topLeft) && !isWall(topRight) && !isWall(bottomLeft) && !isWall(bottomRight);
    }

    private boolean isWall(Color pixelColor) {
        Color wallColor = Color.web("#005399");
        Color wallColor2 = Color.web();
        Color wallColor3 = Color.web ()
        return pixelColor.equals(wallColor);
    }





}
