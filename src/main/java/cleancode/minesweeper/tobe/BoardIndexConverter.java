package cleancode.minesweeper.tobe;

public class BoardIndexConverter {

    private static final char BASE_CHAR_FOR_COL = 'a';

    public int getSelectedColumnIndex(String cellInput, int colSize) {
        char cellInputColumn = cellInput.charAt(0);
        return convertColumnFrom(cellInputColumn, colSize);
    }

    public int getSelectedRowIndex(String cellInput, int rowSize) {
        String cellInputRow = cellInput.substring(1);
        return convertRowFrom(cellInputRow, rowSize);
    }


    private int convertRowFrom(String cellInputRow, int rowSize) {
        int rowIndex = Integer.parseInt(cellInputRow) - 1;
        if (rowIndex < 0 || rowIndex > rowSize) {
            throw new GameException("잘못된 입력입니다.");
        }

        return rowIndex;
    }

    private int convertColumnFrom(char cellInputColumn, int colSize) {
        int colIndex = cellInputColumn - BASE_CHAR_FOR_COL;
        if (colIndex < 0 || colIndex > colSize) {
            throw new GameException("잘못된 입력입니다.");
        }

        return colIndex;
    }
}
