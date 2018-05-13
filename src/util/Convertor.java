package util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * データ形式を変換するクラス。
 *
 * @author ozaki
 *
 */
public class Convertor {

    /** 文字列日付を日付型に変換する。 */
    public static LocalDateTime string2Date(String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        LocalDateTime formatDate = LocalDateTime.parse(date, dtf);
         return formatDate;
    }

    public static String FormatNoteId(int id) {
        String formattedId = String.format("SN%07d", String.valueOf(id));
        return formattedId;
    }

}
