import java.util.List;
import java.util.Map;

public class LineData {
    public static StringBuilder getLineData(List<OrderLine> lines, Map<String, MenuItem> menu){
        StringBuilder line_data = new StringBuilder();
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            line_data.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        return line_data;
    }
}
