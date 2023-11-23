package database;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    private String table;
    private List<String> selectColumns;
    private List<String> conditions;
    private List<String> values;
    private List<String> columns;

    /**
     * Constructor with standard definitions
     */
    public QueryBuilder(){
        this.table = "";
        this.selectColumns = new ArrayList<>();
        this.conditions = new ArrayList<>();
        this.values = new ArrayList<>();
        this.columns = new ArrayList<>();


    }

    /**
     * @param tableName
     * @return QueryBuilder
     *
     */
    public QueryBuilder table(String tableName){
        this.table = tableName;
        return this;
    }

    /**
     * @param columns
     * @return QueryBuilder
     *
     */
    public QueryBuilder select(String... columns){
        for (String column : columns){
            this.selectColumns.add(column);
        }

        return this;
    }

    /**
     * @param column
     * @param operator
     * @param value
     * @return QueryBuilder
     */
    public QueryBuilder where(String column, String operator, Object value) {
        String condition = column + " " + operator + " '" + value.toString() + "'";
        this.conditions.add(condition);
        return this;
    }


    /**
     * @param table
     * @return QueryBuilder
     */
    public QueryBuilder insertInto(String table){

        this.table = table;

        return this;
    }

    public QueryBuilder values(String... values) {

        this.values.clear();

        for (String value : values) {
            this.values.add("'" + value + "'");
        }

        return this;
    }

    /**
     * @param columns
     * @return QueryBuilder
     */
    public QueryBuilder columns(String... columns) {

        this.columns.clear();

        for (String column : columns) {
            this.columns.add("`" + column + "`");
        }

        return this;
    }


    /**
     * @return ResultSet
     *
     */
    public ResultSet execute(){
        return db.execute(this.build(), false);
    }

    /**
     * @return String
     *
     * Returns built query that can be executed in Db class
     */
    public String build() {

        if (table == null) {
            throw new IllegalStateException("Table not specified");
        }


        StringBuilder query = new StringBuilder();
        if (values.isEmpty()) {

            if (this.selectColumns.isEmpty()) {
                throw new IllegalStateException("Columns not specified");
            }

            query.append("SELECT ");
            query.append(String.join(", ", this.selectColumns));
            query.append(" FROM ");
            query.append(table);
            if (!this.conditions.isEmpty()) {
                query.append(" WHERE ");
                query.append(String.join(" AND ", this.conditions));
            }

        } else {

            if (this.columns.isEmpty()) {
                throw new IllegalStateException("Columns not specified");
            }

            query.append("INSERT INTO ");
            query.append(table);
            query.append(" (");
            query.append(String.join(", ", columns));
            query.append(") VALUES (");
            query.append(String.join(", ", values));
            query.append(")");

        }


        return query.toString();
    }
}
