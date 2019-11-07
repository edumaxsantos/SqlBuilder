package sqlBuilder;

import java.util.List;


public class SqlBuilder {

    private String sql;


    public SqlBuilder() {

    }

    public SqlBuilder select(List<String> columns) {
        sql = "SELECT ";
        columns.forEach(column -> sql += column + ", ");
        sql = sql.substring(0, sql.lastIndexOf(","));
        sql += " ";
        return this;
    }

    public SqlBuilder from(String table) {
        sql += "FROM " + table;
        return this;
    }

    public SqlBuilder where(String where, String value) {
        sql += " WHERE " + where + value;
        return this;
    }

    public SqlBuilder and(String column, String value) {
        sql += " AND " + column + value;
        return this;
    }

    public static String equalsTo(String value) {
        return " = '" + value + "'";
    }

    public static String equalsTo(int value) {
        return " = " + Integer.toString(value);
    }


    public String build() {
        return sql;
    }

}
