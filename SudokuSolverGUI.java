package com.nt.main;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class SudokuSolverGUI extends JFrame {
    private JTextField[][] cells = new JTextField[9][9];
    private JButton solveButton;

    public SudokuSolverGUI() {
        setTitle("Sudoku Solver");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));

        Font cellFont = new Font("Arial", Font.BOLD, 20);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(cellFont);
                gridPanel.add(cells[row][col]);
            }
        }

        solveButton = new JButton("Solve Sudoku");
        solveButton.addActionListener(e -> solve());

        add(gridPanel, BorderLayout.CENTER);
        add(solveButton, BorderLayout.SOUTH);
    }

    private void solve() {
        int[][] board = new int[9][9];

        // Read input from fields
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = cells[i][j].getText();
                if (!text.isEmpty()) {
                    try {
                        board[i][j] = Integer.parseInt(text);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid input at (" + (i+1) + "," + (j+1) + ")");
                        return;
                    }
                } else {
                    board[i][j] = 0;
                }
            }
        }

        if (solveSudoku(board)) {
            // Update GUI with solved board
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    cells[i][j].setText(String.valueOf(board[i][j]));
                }
            }
            JOptionPane.showMessageDialog(this, "Sudoku Solved Successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No solution exists for this Sudoku!");
        }
    }

    private boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0; // backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[startRow + i][startCol + j] == num)
                    return false;

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SudokuSolverGUI().setVisible(true));
    }
}
