package at.fhv.msc.java;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GraphPlotter extends Frame {
	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_FRAME_HEIGHT = 500;
	private static final int DEFAULT_FRAME_WIDTH = 500;
	
	private TextField _aInput;
	private TextField _bInput;
	private TextField _cInput;
	private Label _labelA;
	private Label _labelB;
	private Label _labelC;
	private Panel _panel;
	private Button _add;
	private Button _remove;
	private GraphCanvas _graph;
	private Color _darkModeColor;
	
	private ArrayList<Polynomial> _polynomials;
	
	public GraphPlotter() {
		
		// create array for input polynomials
		_polynomials = new ArrayList<Polynomial>();
		
		initFrame();
		initInputPanel();
		initMenuBar();
		initExitFrame();
		initButtons();
		
		// add contents to panel
		_panel.add(_labelA);
		_panel.add(_aInput);
		_panel.add(_labelB);
		_panel.add(_bInput);
		_panel.add(_labelC);
		_panel.add(_cInput);
		_panel.add(_add);
		_panel.add(_remove);
		
		// add panel and graph to frame
		add(_panel, BorderLayout.NORTH);
		_graph = new GraphCanvas();
		add(_graph, BorderLayout.CENTER);
		
		// resizing axes when changing frame size
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                _graph.resizeAxes();
            }
        });
	}

	private void initFrame() {
		setTitle("Graph Plotter");
		setSize(DEFAULT_FRAME_HEIGHT, DEFAULT_FRAME_WIDTH);
		setLayout(new BorderLayout());
		_darkModeColor = new Color(61,61,61);
		setBackground(_darkModeColor);
	}
	
	private void initInputPanel() {
		_panel = new Panel();
		_panel.setLayout(new FlowLayout());
		_labelA = new Label("f(x) =");
		_labelB = new Label("  x² +");
		_labelC = new Label("  x  +");
		_aInput = new TextField(1);
		_bInput = new TextField(1);
		_cInput = new TextField(1);
	}
	
	private void initMenuBar() {
		MenuBar menu = new MenuBar();
		setMenuBar(menu);
		
		Menu file = new Menu("File");
		menu.add(file);
		
		MenuItem exit = new MenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		
		file.add(exit);
		
		Menu help = new Menu("Help");
		menu.add(help);
		
		MenuItem about = new MenuItem("About");
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				showAboutBox();
			}
		});
		
		help.add(about);
	}
	

	private void initExitFrame() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});
	}
	
	private void initButtons() {
		_add = new Button("Plot");
		_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				addPolynomial();
				_graph.repaint();
			}
		});

		_remove = new Button("Remove");
		_remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				removePolynomial();
				_graph.repaint();
			}
		});
	}

	private void showAboutBox() {
		String aboutText = "Graph Plotter v2.0\n\n" + " by Manuel Schönberger";
		
		AboutBox about = new AboutBox(this, "About", aboutText);
		about.setVisible(true);
	}
	
    private void addPolynomial() {
        double a = parseInputToDouble(_aInput.getText());
        double b = parseInputToDouble(_bInput.getText());
        double c = parseInputToDouble(_cInput.getText());
        Color color = getRandomColor();

        _polynomials.add(new Polynomial(a, b, c, color));
    }

    private void removePolynomial() {
        if (!_polynomials.isEmpty()) {
            _polynomials.remove(_polynomials.size() - 1);
        }
    }
    
    private Color getRandomColor() {
    	int r = 0, g = 0, b = 0;
    	while(((r + g + b) < 200) || (r + g + b == 0)) {
	        r = (int) (Math.random() * 255);
	        g = (int) (Math.random() * 255);
	        b = (int) (Math.random() * 255);
    	}

        return new Color(r, g, b);
    }
    
    private double parseInputToDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
	
	private class GraphCanvas extends Canvas {
		private static final long serialVersionUID = 1L;
		
		private int _centerX;
		private int _centerY;
		private int _width;
		private int _height;
		private double _zoomLevel;
		
		private static final double DEFAULT_SCALE_X_AXIS = 5.0;
		private static final double ZOOM_AMOUNT = 0.1;

		public GraphCanvas() {
			resizeAxes();
			_zoomLevel = 1.0;
			
	        addMouseWheelListener(new MouseWheelListener() {
	            public void mouseWheelMoved(MouseWheelEvent e) {
	                int notches = e.getWheelRotation();
	                if (notches < 0) {
	                    _zoomLevel *= (1 + ZOOM_AMOUNT);
	                } else {
	                    _zoomLevel /= (1 + ZOOM_AMOUNT);
	                }
	                
	                resizeAxes();
	            }
	        });
		}
		
		public void resizeAxes() {
			_centerX = this.getWidth() / 2;
			_centerY = this.getHeight() / 2;
			_width = (int) (getWidth() / _zoomLevel);
			_height = (int) (getHeight() / _zoomLevel);
			repaint();
		}
		
		public void paint(Graphics graph) {
//			super.paint(graph);
			
			Graphics2D graph2D = (Graphics2D) graph;
			
			// set space for axes and graph
			graph2D.setColor(_darkModeColor);
			graph2D.fillRect(0, 0, _width, _height);
			
			// configure axes
			Axes axes = new Axes(_centerX, _centerY, _width, _height, DEFAULT_SCALE_X_AXIS, _zoomLevel);
			axes.axesConfig(graph2D);

			graph2D.setStroke(new BasicStroke(3.0f));

			// plot each graph
			for(Polynomial polynomial : _polynomials) {
				
				// get input and save as coefficient
				double a = polynomial.getA() / _zoomLevel;
				double b = polynomial.getB();
				double c = polynomial.getC() * _zoomLevel;
				
				graph.setColor(polynomial.getColor());
				
				// plot graph (f(x) = a * x² + b * x + c)
				double preAbsX = 0.0;
				double preAbsY = 0.0;
				for (double relX = -_width / 2; relX < (_width / 2); relX += 0.1) {
					double relY = a * Math.pow(relX / DEFAULT_SCALE_X_AXIS, 2) + b * (relX / DEFAULT_SCALE_X_AXIS) + c;
					double absX = _centerX + (int)(relX * DEFAULT_SCALE_X_AXIS);
					double absY = _centerY - (int)(relY * DEFAULT_SCALE_X_AXIS);

					graph.drawLine((int)preAbsX, (int)preAbsY, (int)absX, (int)absY);
					preAbsX = absX;
					preAbsY = absY;
				}
			}
		}
	}

	public static void main(String[] args) {
		GraphPlotter graphPlotter = new GraphPlotter();
		graphPlotter.setVisible(true);
	}
}
