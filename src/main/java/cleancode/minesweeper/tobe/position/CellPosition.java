package cleancode.minesweeper.tobe.position;

import java.util.Objects;

public class CellPosition {
    // VO 생성 시 만족해야할 성격 -> 불변성, 동등성, 유효성 검사
    private final int rowIndex;
    private final int columnIndex;

    private CellPosition(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || columnIndex < 0) {
            throw new IllegalArgumentException("rowIndex and columnIndex should be non-negative");
        }

        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public static CellPosition of(int rowIndex, int columnIndex) {
        return new CellPosition(rowIndex, columnIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPosition that = (CellPosition) o;
        return rowIndex == that.rowIndex && columnIndex == that.columnIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, columnIndex);
    }

    public boolean isRowIndexMoreThanOrEqual(int rowIndex) {
        return this.rowIndex >= rowIndex;
    }

    public boolean isColIndexMoreThanOrEqual(int colIndex) {
        return this.columnIndex >= colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public CellPosition calculatePositionBy(RelativePosition relativePosition) {
        if (this.canCalculatePositionBy(relativePosition)) {
            return CellPosition.of(this.rowIndex + relativePosition.getDeltaRow(), this.columnIndex + relativePosition.getDeltaCol());
        }

        throw new IllegalArgumentException("움직일 수 있는 좌표가 아닙니다.");
    }

    public boolean canCalculatePositionBy(RelativePosition relativePosition) {
            return this.rowIndex + relativePosition.getDeltaRow() >= 0
                && this.columnIndex + relativePosition.getDeltaCol() >= 0;
    }

    public boolean isRowIndexLessThan(int rowIndex) {
        return this.rowIndex < rowIndex;
    }

    public boolean isColIndexLessThan(int columnIndex) {
        return this.columnIndex < columnIndex;
    }
}
