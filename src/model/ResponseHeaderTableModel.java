package model;

import javax.swing.table.AbstractTableModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResponseHeaderTableModel extends AbstractTableModel {
    String[][] data;

    public ResponseHeaderTableModel(Map<String, List<String>> headers) {
        data = new String[headers.size()][2];
        Set entries = headers.entrySet();
        Iterator entriesIterator = entries.iterator();
        int i = 0;
        while (entriesIterator.hasNext()) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            data[i][0] = (String) mapping.getKey();
            data[i][1] = join((List<String>) mapping.getValue(), ",");
            i++;
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    private String join(List<String> list, String conjunction) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String item : list) {
            if (first)
                first = false;
            else
                sb.append(conjunction);
            sb.append(item);
        }
        return sb.toString();
    }
}
