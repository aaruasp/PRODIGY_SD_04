# ✅ Sudoku Solver – Java GUI Application 🧠

### 🚀 Task 4 – Software Development Internship @ Prodigy Infotech

This is a simple yet powerful Sudoku Solver developed using **Java** with a user-friendly **Swing GUI**. It uses a recursive **backtracking algorithm** to solve any valid 9x9 Sudoku puzzle automatically.

---

## 🧩 Features

- 🧮 Enter any unsolved 9x9 Sudoku puzzle manually.
- 🤖 Click **"Solve"** to let the algorithm solve the puzzle instantly.
- ♻️ Use **"Clear"** to reset the grid and enter a new puzzle.
- ⚠️ Automatically detects and alerts if the puzzle has no valid solution.

---

## 📸 GUI Preview

*(Insert screenshot here if available)*

---

## 💡 How It Works

- The algorithm checks each empty cell and tries placing digits from 1 to 9.
- For each number, it validates that the number doesn't already exist in the same row, column, or 3x3 box.
- If valid, it proceeds recursively; if not, it backtracks.
- The result is a completely solved puzzle (if solvable).

---

## 🛠️ Tech Stack

- **Language:** Java  
- **GUI:** Java Swing  
- **Algorithm:** Recursive Backtracking

---

## 📁 Project Structure

```bash
SudokuSolver/
│
├── SudokuSolverGUI.java      # Main Java file with GUI and solving logic
├── README.md                 # This file
