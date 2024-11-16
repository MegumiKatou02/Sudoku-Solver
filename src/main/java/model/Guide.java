package model;

public class Guide {
    private StringBuilder str;

    public Guide() {
        str = new StringBuilder("<html><pre>");
        str.append(" - Input theo dạng 9 x 9 <br>");
        str.append(" - Khoảng cách giữa các số là kí tự <br>   gì cũng được (ngoài số) <br>");
        str.append(" - Các kí tự trống là gì cũng được <br>  (ngoài khoảng trắng)");
        str.append("<pre></html>");
    }

    public StringBuilder getStringBuilder() {
        return str;
    }
}