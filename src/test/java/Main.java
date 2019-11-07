import sqlBuilder.Builder;
import sqlBuilder.SqlBuilder;

import java.util.ArrayList;
import java.util.List;

import static sqlBuilder.SqlBuilder.equalsTo;

public class Main {

    public static void main(String[] args) {
        Builder builder = new Builder();

        builder.setTable("CLC.TBCLCR_LNCM_RECB")
                .setOrder("NU_RFRN_MVMN", true);

        System.out.println(builder.build());

        SqlBuilder sql = new SqlBuilder();

        List<String> columns = new ArrayList<>();
        columns.add("TESTE");
        columns.add("AAA");

        sql.select(columns)
                .from("CLC.TBCLCR_LNCM_RECB")
                .where("SOMETHING", equalsTo(5))
                .and("OUTRO", equalsTo("OPA"));

        System.out.println(sql.build());
    }
}
