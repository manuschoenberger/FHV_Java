import java.awt.*;
import java.awt.event.*;

public class TempCalc extends Frame {
	private static final long serialVersionUID = 1L;
	
	private TextField _temp;
	private Button _analyse;
	private Panel _inputPanel;
	private Panel _analysePanel;
	private Panel _outputPanel;
	
	public TempCalc() {
		this.setTitle("Temperature Calculator");
		this.setSize(470,450);
		this.setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});
		
		
		
		_inputPanel = new Panel();
		_inputPanel.setLayout(new FlowLayout());
		
		_analysePanel = new Panel();
		_analysePanel.setLayout(new FlowLayout());
		
		_outputPanel = new Panel();
		_outputPanel.setLayout(new FlowLayout());
		
		Label labelTemp = new Label("temp:");
		_temp = new TextField(2);
		_inputPanel.add(labelTemp);
		_inputPanel.add(_temp);
		
		Label resLabel = new Label();
		_outputPanel.add(resLabel);
		
		_analyse = new Button("Analyse");
		_analysePanel.add(_analyse);
		
		this.add(_inputPanel, BorderLayout.NORTH);
		this.add(_analysePanel, BorderLayout.CENTER);
		this.add(_outputPanel, BorderLayout.SOUTH);

		
		
		
		_analyse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				double res = Double.parseDouble(_temp.getText());

				if (res >= 37.2) {
					resLabel.setForeground(Color.red);
					resLabel.setText("High");
				}
				
				if (res > 36 && res < 37.2) {
					resLabel.setForeground(Color.orange);
					resLabel.setText("Fine");
				}
				
				if (res <= 36) {
					resLabel.setForeground(Color.blue);
					resLabel.setText("Low");
				}
			}
		});
	}

	public static void main(String[] args) {
		TempCalc tc = new TempCalc();
		tc.setVisible(true);

	}

}
