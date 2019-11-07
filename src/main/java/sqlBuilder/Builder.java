package sqlBuilder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Builder {

    private String table;
    private Map<String, String> filters;
    private List<String> selects;
    private String fieldToOrder;
    private boolean isDesc;

    public Builder() {
        filters = new LinkedHashMap<>();
        selects = new ArrayList<>();
    }

    public Builder setTable(String table) {
        this.table = table;
        return this;
    }

    public Builder addSelect(String select) {
        selects.add(select);
        return this;
    }

    public Builder addFilter(String filter, String value) {
        filters.put(filter, value);
        return this;
    }

    public Builder setOrder(String field, boolean isDesc) {
        this.fieldToOrder = field;
        this.isDesc =isDesc;
        return this;
    }

    public String build() {

        if(table == null)
            throw new NullPointerException("TABLE não definida");

        StringBuilder builder = new StringBuilder("SELECT");
        if(selects.isEmpty()) {
            builder.append(" * ");
        } else {
            for(int i = 0; i < selects.size(); i++) {
                builder.append(selects.get(i));
                if(i + 1 < selects.size())
                    builder.append(", ");
            }
        }

        builder.append("\nFROM ").append(table).append("\n");

        if(!filters.isEmpty()) {
            filters.entrySet()
                    .forEach(key -> builder.append(key).append(" = ").append(filters.get(key)).append("\n"));
        }

        if(fieldToOrder != null) {
            builder.append("ORDER BY ")
                    .append(fieldToOrder);
            if(isDesc)
                builder.append(" DESC\n");
            else
                builder.append(" ASC\n");
        }

        return builder.toString();
    }
}
