package utils;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH(0, 1),
    NORTHEAST(1, 1),
    EAST(1, 0),
    SOUTHEAST(1, -1),
    SOUTH(0, -1),
    SOUTHWEST(-1, -1),
    WEST(-1, 0),
    NORTHWEST(-1, 1),

    NNE(1, 2),
    NNW(-1, 2),
    SSE(1, -2),
    SSW(-1, -2),
    EEN(2, 1),
    EES(2, -1),
    WWN(-2, 1),
    WWS(-2, -1),
    NON_DIRECTION(0,0);

    private int xDegree;
    private int yDegree;

    private Direction(int xDegree, int yDegree) {
        this.xDegree = xDegree;
        this.yDegree = yDegree;
    }

    public int getXDegree() {
        return xDegree;
    }

    public int getYDegree() {
        return yDegree;
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> everyDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }

    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(NORTH, NORTHEAST, NORTHWEST);
    }

    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(SOUTH, SOUTHEAST, SOUTHWEST);
    }

    public static Direction valueOf(int xDegree, int yDegree) {
        if (xDegree == 0 && yDegree == 1) {
            return NORTH;
        } else if (xDegree == 1 && yDegree == 1) {
            return NORTHEAST;
        } else if (xDegree == 1 && yDegree ==0){
            return EAST;
        } else if (xDegree == 1 && yDegree == -1){
            return SOUTHEAST;
        } else if (xDegree == 0 && yDegree == -1){
            return SOUTH;
        } else if (xDegree == -1 && yDegree == -1){
            return SOUTHWEST;
        } else if (xDegree == -1 && yDegree ==0){
            return WEST;
        } else if (xDegree == -1 && yDegree ==1 ){
            return NORTHWEST;
        } else if (xDegree == 1 && yDegree==2){
            return NNE;
        } else if (xDegree == 2 && yDegree== 1){
            return EEN;
        } else if (xDegree == 1 && yDegree == -2){
            return SSE;
        } else if (xDegree == -2 && yDegree == -1){
            return WWS;
        } else if (xDegree == -1 && yDegree == 2){
            return NNW;
        } else if (xDegree == -1 && yDegree == -2){
            return SSW;
        } else if (xDegree == -2 && yDegree == 1){
            return WWN;
        } else if (xDegree == 2 && yDegree== -1) {
            return EES;
        }
        return NON_DIRECTION;
    }
}