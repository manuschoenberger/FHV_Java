package Stoppuhr;

import java.awt.*;
import java.awt.event.*;

public class StoppuhrAWT extends Frame {
	private static final long serialVersionUID = 1L;
	private Label _timerLabel;
    private Button _startButton, _stopButton;
    private int _minutes, _seconds;
    private boolean _running;

    public StoppuhrAWT() {
        setTitle("Stoppuhr");
        setSize(300, 200);
        setLayout(new BorderLayout());
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent e) {
        		System.exit(0);
        	}
        });

        _timerLabel = new Label("00:00", Label.CENTER);
        _timerLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(_timerLabel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel();
        _startButton = new Button("Start");
        _startButton.addActionListener(new StartButtonListener());
        buttonPanel.add(_startButton);

        _stopButton = new Button("Stop");
        _stopButton.addActionListener(new StopButtonListener());
        _stopButton.setEnabled(false);
        buttonPanel.add(_stopButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            _running = true;
            _startButton.setEnabled(false);
            _stopButton.setEnabled(true);
            startTimer();
        }
    }

    private class StopButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            _running = false;
            _stopButton.setEnabled(false);
            _startButton.setEnabled(true);
        }
    }

    private void startTimer() {
        Thread timerThread = new Thread(() -> {
            while (_running) {
                try {
                    Thread.sleep(1000); // Pause für eine Sekunde
                    incrementTime();
                    updateTimerLabel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.start();
    }

    private void incrementTime() {
        _seconds++;
        if (_seconds >= 60) {
            _seconds = 0;
            _minutes++;
        }
    }

    private void updateTimerLabel() {
        String time = String.format("%02d:%02d", _minutes, _seconds);
        _timerLabel.setText(time);
    }

    public static void main(String[] args) {
        new StoppuhrAWT();
    }
}