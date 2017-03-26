package game.gui;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.logic.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class GameWindow extends JFrame { 

	// MARK: PROPRIETIES
	private Game game;
	private GameScreenPanel gamePanel;

	//	Buttons
	JButton btnAddHero;
	JButton btnRemoveElement;
	JButton btnEditGame;
	JButton btnApply;
	JButton btnAddWall;
	JButton btnAddDoor;
	JButton btnAddNewRow;
	JButton btnAddLever;
	JButton btnAddGuard;
	JButton btnNewButton;
	JButton btnAddOgre;
	JButton btnAddPilar;
	JButton btnAddNewColumn;
	JButton btnNewGame;

	/**
	 * Create the frame.
	 */
	public GameWindow(Game game) {

		// create new window
		setTitle("Game Window");
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//	Creates game panel
		GameScreenPanel panel = new GameScreenPanel(game);
		setGamePanel(panel);
		//	Create game
		setGame(game);

		getContentPane().setLayout(new MigLayout("", "[][][][][grow]", "[grow][grow][][][][][][grow][][][grow][][][grow][][grow]"));

		this.btnEditGame = new JButton("Edit game");

		btnNewGame = new JButton("New game");
		btnNewGame.setFocusable(false);
		getContentPane().add(btnNewGame, "cell 0 0");
		btnEditGame.setFocusable(false);
		getContentPane().add(btnEditGame, "cell 1 0,alignx left,aligny center");
		getContentPane().add(panel, "cell 4 0 1 16,grow");

		panel.requestFocusInWindow();
		panel.setFocusable(true);
		panel.setVisible(true);

		JLabel lblGeneral = new JLabel("General");
		lblGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGeneral, "cell 0 2,alignx left");

		this.btnRemoveElement = new JButton("Remove");
		getContentPane().add(btnRemoveElement, "cell 0 3");

		this.btnAddDoor = new JButton("Add Door");
		getContentPane().add(btnAddDoor, "cell 0 4,alignx left,aligny center");

		this.btnAddPilar = new JButton("Add Pilar");
		getContentPane().add(btnAddPilar, "cell 1 4,alignx left");

		this.btnAddWall = new JButton("Add Wall");
		getContentPane().add(btnAddWall, "cell 0 5,alignx left");

		this.btnAddHero = new JButton("Add Hero");
		getContentPane().add(btnAddHero, "cell 1 5,alignx left");

		this.btnAddNewRow = new JButton("Add New Line");
		getContentPane().add(btnAddNewRow, "cell 0 6,alignx left");

		this.btnAddNewColumn = new JButton("Add New Column");
		getContentPane().add(btnAddNewColumn, "cell 1 6,alignx left");

		JLabel lblFirstLevel = new JLabel("First Level");
		getContentPane().add(lblFirstLevel, "cell 0 8,alignx left");

		this.btnAddLever = new JButton("Add Lever");
		getContentPane().add(btnAddLever, "cell 0 9,alignx left,aligny center");

		this.btnAddGuard = new JButton("Add Guard");
		getContentPane().add(btnAddGuard, "cell 1 9,alignx left");

		JLabel lblSecondLevel = new JLabel("Second Level");
		getContentPane().add(lblSecondLevel, "cell 0 11,alignx left");

		this.btnAddOgre = new JButton("Add Ogre");
		getContentPane().add(btnAddOgre, "cell 0 12");

		this.btnNewButton = new JButton("Add Key");
		getContentPane().add(btnNewButton, "cell 1 12");

		JLabel lblApplyChanges = new JLabel("Apply Changes");
		getContentPane().add(lblApplyChanges, "cell 0 14,alignx left");

		this.btnApply = new JButton("Apply");
		getContentPane().add(btnApply, "cell 0 15,alignx left");

		setVisible(true);
		
		//	Add buttons actions
		this.addButtonsActionListeners();
		//	Remove buttons focusable
		this.removeButtonsFocusable();
	}
	/** 
	 * Set buttons no focusable
	 * */
	private void removeButtonsFocusable(){
		btnRemoveElement.setEnabled(false);
		btnRemoveElement.setFocusable(false);
		btnAddDoor.setFocusable(false);
		btnAddDoor.setEnabled(false);
		btnAddPilar.setFocusable(false);
		btnAddPilar.setEnabled(false);
		btnAddHero.setEnabled(false);
		btnAddHero.setFocusable(false);
		btnAddWall.setEnabled(false);
		btnAddWall.setFocusable(false);
		btnAddNewRow.setEnabled(false);
		btnAddNewRow.setFocusable(false);
		btnAddNewColumn.setEnabled(false);
		btnAddNewColumn.setFocusable(false);
		btnAddLever.setEnabled(false);
		btnAddLever.setFocusable(false);
		btnApply.setEnabled(false);
		btnApply.setFocusable(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setEnabled(false);
		btnAddOgre.setFocusable(false);
		btnAddOgre.setEnabled(false);
		btnAddGuard.setEnabled(false);
		btnAddGuard.setFocusable(false);
	}
	
	/** 
	 * Adds buttons actions
	 * */
	private void addButtonsActionListeners(){
		
		btnAddHero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add Hero
				gamePanel.setMouseAction(GameWindowEditMouseActions.addHero);
			}
		});
		

		//	Adds first level buttons actions
		addFirstLevelButtonsActions();
		
		//	Adds second level buttons actions
		addSecondLevelButtonsActions();
		
		//	Add general buttons action listeners
		addGeneralButtonsActionListeners();
		
		//	Add view elements buttons action listeners
		addViewElementsButtonsActionListeners();
	}
	
	/** 
	 * Adds view elements
	 * */
	private void addViewElementsButtonsActionListeners(){
		btnAddDoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add door
				gamePanel.setMouseAction(GameWindowEditMouseActions.addDoor);
			}
		});
		btnAddPilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add pilar
				gamePanel.setMouseAction(GameWindowEditMouseActions.addPilar);
			}
		});
		btnAddWall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add Wall
				gamePanel.setMouseAction(GameWindowEditMouseActions.addWall);
			}
		});
		btnAddNewRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add new line
				addLine();
			}
		});
		btnAddNewColumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Adds new row
				addRow();
			}
		});
	}
	
	/** 
	 * Adds general buttons action listeners
	 * */
	private void addGeneralButtonsActionListeners(){
		btnEditGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Edit game
				editGame();
			}
		});
		btnRemoveElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Remove element
				gamePanel.setMouseAction(GameWindowEditMouseActions.removeElement);
			}
		});
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Apply game changes
				applyGameChanges();
			}
		});
	}
	
	/** 
	 * Adds first level button action listeners
	 * */
	private void addFirstLevelButtonsActions(){
		btnAddLever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add lever
				gamePanel.setMouseAction(GameWindowEditMouseActions.addLever);
			}
		});
		btnAddGuard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add guard
				gamePanel.setMouseAction(GameWindowEditMouseActions.addGuard);
			}
		});
	}
	
	/** 
	 * Adds second level buttons action listeners
	 * */
	private void addSecondLevelButtonsActions(){
		btnAddOgre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add ogre
				gamePanel.setMouseAction(GameWindowEditMouseActions.addOgre);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//	Add key
				gamePanel.setMouseAction(GameWindowEditMouseActions.addKey);
			}
		});
	}
	
	
	/** 
	 * Adds new row to game map
	 * */
	private void addLine(){
		game.getCurrentMap().addLine();
		//	Repaint map
		gamePanel.repaint();

	}
	/** 
	 * Adds new row to the map
	 * */
	private void addRow(){
		game.getCurrentMap().addRow();
		//	Repaint map
		gamePanel.repaint();
	}

	/** 
	 * Enables game editing
	 * */
	private void editGame(){
		//	Stop game
		gamePanel.setEditing(true);

		//	Enable / Disable proper buttons
		this.enableEditingButtons(true);
	}
	/** 
	 * Enable / Disable editing buttons
	 * */
	private void enableEditingButtons(boolean value){
		this.btnRemoveElement.setEnabled(value);
		this.btnEditGame.setEnabled(!value);
		this.btnApply.setEnabled(value);
		this.btnAddWall.setEnabled(value);
		this.btnAddDoor.setEnabled(value);
		this.btnAddLever.setEnabled(value);
		this.btnAddGuard.setEnabled(value);
		this.btnNewButton.setEnabled(value);
		this.btnAddOgre.setEnabled(value);
		this.btnAddPilar.setEnabled(value);
		this.btnAddNewRow.setEnabled(value);
		this.btnAddNewColumn.setEnabled(value);
		this.btnAddHero.setEnabled(value);
	}
	/** 
	 * Apply editing changes
	 * */
	private void applyGameChanges(){
		//	Check if game is playable
		if (game.getCurrentMap().isPlayable()){

			//	Resume game
			gamePanel.setEditing(false);

			//	Enable / Disable editing buttons
			this.enableEditingButtons(false);
		} else {
			JOptionPane.showMessageDialog(this, "Map is not playable!");
		}
	}

	/**
	 * @return the gamePanel
	 */
	public GameScreenPanel getGamePanel() {
		return gamePanel;
	}
	/**
	 * @param panel the gamePanel to set
	 */
	public void setGamePanel(GameScreenPanel panel) {
		this.gamePanel = panel;
	}
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
}
