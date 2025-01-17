package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PainterController {

    @FXML
    private Canvas drawingCanvas;

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    private GraphicsContext gc;

    @FXML
    public void initialize() {
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);  
        gc.setLineWidth(2);  
    }

    @FXML
    private void startDrawing(MouseEvent event) {
        if (penButton.isSelected()) {
            gc.beginPath();
            gc.moveTo(event.getX(), event.getY());
        } else if (eraserButton.isSelected()) {
            gc.clearRect(event.getX() - 10, event.getY() - 10, 20, 20);
        }
    }

    @FXML
    private void draw(MouseEvent event) {
        if (penButton.isSelected()) {
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
        } else if (eraserButton.isSelected()) {
            gc.clearRect(event.getX() - 10, event.getY() - 10, 20, 20);
        }
    }

    @FXML
    private void clearButtonPressed() {
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
    }
}
