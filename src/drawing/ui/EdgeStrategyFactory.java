package drawing.ui;

import drawing.shapes.EdgeStrategyOrthogonalHLine;
import drawing.shapes.EdgeStrategyOrthogonalVLine;
import drawing.shapes.EdgeStrategyStraightLine;
import drawing.shapes.IEdgeStrategy;

public class EdgeStrategyFactory {
    public static final String EDGE_STRATEGY_HLINE = "HLine";
    public static final String EDGE_STRATEGY_VLINE = "VLine";
    public static final String EDGE_STRATEGY_STRAIGHT = "Straight";

    public static IEdgeStrategy createEdgeStrategy(String strategy){
        IEdgeStrategy edgeStrategy;

        switch(strategy){
            case EDGE_STRATEGY_HLINE:
                edgeStrategy = new EdgeStrategyOrthogonalHLine();
                break;

            case EDGE_STRATEGY_VLINE:
                edgeStrategy = new EdgeStrategyOrthogonalVLine();
                break;

            case EDGE_STRATEGY_STRAIGHT:
                edgeStrategy = new EdgeStrategyStraightLine();
                break;

            default:
                edgeStrategy = null;
                break;
        }

        return edgeStrategy;
    }
}
