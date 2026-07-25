private static boolean processMove(String move) {
    try {
        String[] parts = move.split(" ");
        if (parts.length != 2) return false;

        int fromRow = 8 - Character.getNumericValue(parts[0].charAt(1));
        int fromCol = parts[0].charAt(0) - 'a';
        int toRow = 8 - Character.getNumericValue(parts[1].charAt(1));
        int toCol = parts[1].charAt(0) - 'a';

        // Check board limits
        if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 ||
            toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            return false;
        }

        char piece = board[fromRow][fromCol];

        // No piece at source
        if (piece == '.') return false;

        // White turn
        if (whiteTurn && Character.isLowerCase(piece))
            return false;

        // Black turn
        if (!whiteTurn && Character.isUpperCase(piece))
            return false;

        // Cannot capture your own piece
        char target = board[toRow][toCol];
        if (target != '.') {
            if (Character.isUpperCase(piece) == Character.isUpperCase(target))
                return false;
        }

        // Move the piece (simple version)
        board[toRow][toCol] = piece;
        board[fromRow][fromCol] = '.';

        return true;

    } catch (Exception e) {
        return false;
    }
}
