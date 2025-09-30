SIZE = 3
EMPTY = " "
board = [[EMPTY for _ in range(SIZE)] for _ in range(SIZE)]

def init_board():
    for i in range(SIZE):
        for j in range(SIZE):
            board[i][j] = EMPTY

def print_board():
    print("-------------")
    for row in board:
        print("| " + " | ".join(row) + " |")
        print("-------------")

def is_valid_move(row, col):
    return 0 <= row < SIZE and 0 <= col < SIZE and board[row][col] == EMPTY

def has_won(player):
    # check rows and columns
    for i in range(SIZE):
        if all(board[i][j] == player for j in range(SIZE)) or \
           all(board[j][i] == player for j in range(SIZE)):
            return True
    # check diagonals
    if all(board[i][i] == player for i in range(SIZE)) or \
       all(board[i][SIZE - 1 - i] == player for i in range(SIZE)):
        return True
    return False

def is_board_full():
    return all(board[i][j] != EMPTY for i in range(SIZE) for j in range(SIZE))

def tic_tac_toe():
    current_player = "X"
    game_over = False
    init_board()
    print("🎮 Welcome to Tic Tac Toe!")
    print_board()

    while not game_over:
        try:
            row, col = map(int, input(f"Player {current_player}, enter row and column (0-2): ").split())
        except ValueError:
            print("❌ Invalid input! Enter two numbers separated by space.")
            continue

        if not is_valid_move(row, col):
            print("❌ Invalid move! Try again.")
            continue

        board[row][col] = current_player
        print_board()

        if has_won(current_player):
            print(f"🏆 Player {current_player} wins!")
            game_over = True
        elif is_board_full():
            print("🤝 It's a draw!")
            game_over = True
        else:
            current_player = "O" if current_player == "X" else "X"

if __name__ == "__main__":
    tic_tac_toe()
