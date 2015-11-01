import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.List;

/**
 * Created by pcont_000 on 01/11/2015.
 */
public class GetTable {
    public static void main(String [] args){

        Configuration conf = new Configuration();
        try {
            HTableInterface table = new HTable(conf, "excite");
            Get g = new Get(Bytes.toBytes("hermes-201510301509"));
            g.addColumn(Bytes.toBytes("colfam1"),null);
            Result result = table.get(g);
            List<Cell> values = result.listCells();
            for (Cell c: values){
                System.out.println("Valor Recuperado: " + Bytes.toString(c.getValueArray()));

                //should appear there.
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
